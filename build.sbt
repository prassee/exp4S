name := "exp4jClient"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "net.objecthunter" % "exp4j" % "0.4.7")


resolvers += Resolver.url("github repo for hamsters", url("http://scala-hamsters.github.io/hamsters/releases/"))(Resolver.ivyStylePatterns)
