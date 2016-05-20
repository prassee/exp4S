name := "exp4s"

organization := "com.zilingo"

version := "0.0.1"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "net.objecthunter" % "exp4j" % "0.4.7")

publishTo := Some("Strawmine Ivy Repository" at "http://repository.strawmine.com/artifactory/libs-release-local")

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

isSnapshot := true

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-deprecation",
  "-unchecked",
  "-feature",
  "-Xlint"
)