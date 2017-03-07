name := "exp4s"

organization := "prassee"

version := "0.0.1"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq("net.objecthunter" % "exp4j" % "0.4.8")

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-deprecation",
  "-unchecked",
  "-feature",
  "-Xlint"
)
