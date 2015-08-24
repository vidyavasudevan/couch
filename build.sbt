name := "couch"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "mysql" % "mysql-connector-java" % "5.1.+"
)

libraryDependencies += "com.tinkerpop.blueprints" % "blueprints-orient-graph" % "2.4.0"

play.Project.playScalaSettings
