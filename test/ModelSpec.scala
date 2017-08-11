import models.UserService
import org.scalatestplus.play._

class ModelSpec extends PlaySpec with OneAppPerSuite {

  var userService: UserService = app.injector.instanceOf(classOf[UserService])

  import models._

  // -- Date helpers
  
  def dateIs(date: java.util.Date, str: String) = {
    new java.text.SimpleDateFormat("yyyy-MM-dd").format(date) == str
  }
  
  // --
  
  "User model" should {
    
    "be retrieved by id" in {
        val user = userService.findOneByUsername("test1@example.com").getOrElse(User("",""))
      
        
        user.password must equal("test")
    }
    
    "email and pass" in {

        val isUser = userService.findByEmailAndPassword("test1@example.com", "test")

        isUser must equal(true)
        
    }
    
  }
  
}