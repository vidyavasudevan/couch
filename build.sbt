name := "couch"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

scalaHome := Some(file("/opt/scala-2.11.7"))

libraryDependencies ++= Seq(
  jdbc,
  cache,
  "mysql" % "mysql-connector-java" % "5.1.+"
)

libraryDependencies += "com.tinkerpop.blueprints" % "blueprints-orient-graph" % "2.4.0"

libraryDependencies += evolutions

libraryDependencies += "com.typesafe.play" %% "anorm" % "2.4.0"
