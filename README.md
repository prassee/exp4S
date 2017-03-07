##exp4s

A Simple idiomatic Scala wrapper around Exp4j library. Read more about exp4j

###Download

    //moma -> my own maven archive :)
    resolvers ++= Seq("moma" at "https://github.com/prassee/moma/raw/master/snapshots")
    libraryDependencies ++= Seq("prassee" %% "exp4s" % "0.0.1")


###Usage

      import Exp4sProcessor._

      lazy val y =
        "(aa + bb + 2ab)" ~= Array("a", "b") ~> {
          case "a" => "a" -> 2.0
          case "b" => "b" -> 3.0
          case _   => "_" -> 0.0
        }
      // enjoy


### @TODO (wrapping Exp4j)

* support for custom functions
* support for async formula execution

### License

Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0