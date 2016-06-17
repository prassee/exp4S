#exp4s

A Simple Scala wrapper around Exp4j library

#Download



#Usage


    import Exp4sProcessor._

      lazy val y =
        "(aa + bb + 2ab)" ~= Array("a", "b") ~> {
          case "a" => "a" -> 2.0
          case "b" => "b" -> 3.0
          case _   => "_" -> 0.0
        }
