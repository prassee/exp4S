name := "exp4s"

organization := "me.prassee"

version := "0.0.3"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq("net.objecthunter" % "exp4j" % "0.4.8", "org.scalatest" % "scalatest_2.11" % "3.0.1" % "test")

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-deprecation",
  "-unchecked",
  "-feature",
  "-Xlint"
)
