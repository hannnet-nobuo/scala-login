package models

import javax.inject.Inject

import anorm.SqlParser._
import anorm._

import play.api.db.DBApi

case class User(email:String, password:String)

@javax.inject.Singleton
class UserService @Inject() (dbapi: DBApi) {

  private val db = dbapi.database("default")

  /**
   * Parse a User from a ResultSet
   */
  val simple = {
    get[String]("user.email") ~
    get[String]("user.password") map {
      case email~password => User(email, password)
    }
  }

  def findOneByUsername(username: String) : Option[User] = {
    db.withConnection { implicit connection =>
      SQL("select * from user where email = {username}").on('username -> username).as(simple.singleOpt)
    }
  }


  def findByEmailAndPassword(email: String,password: String) : Boolean = {
    db.withConnection { implicit connection =>
      SQL("select count(*) from user where email = {email} and password = {password}")
      .on('email -> email , 'password -> password).as(scalar[Long].single).>(0)
    }
  }
}





