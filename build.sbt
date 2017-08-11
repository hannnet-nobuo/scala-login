name := """play-scala-auth-sample"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  evolutions,
  cache,
  ws,
  //specs2 % Test,
  "mysql" % "mysql-connector-java" % "5.1.34",
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "org.scalatestplus" %% "play" % "1.4.0-M3" % "test"
)
libraryDependencies += "com.typesafe.play" %% "anorm" % "2.5.0"
// libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "2.0.0" % Test

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
