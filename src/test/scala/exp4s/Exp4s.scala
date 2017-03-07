package exp4s

object Exp4s extends App with FormulaRepresentation {

  import Exp4sProcessor._

  lazy val y =
    aPlusB._1 ~= aPlusB._2 ~> {
      case "a" => "a" -> 2.0
      case "b" => "b" -> 3.0
      case _   => "_" -> 0.0
    }

  val sumOfSqr = aplusBSqr._1 ~= aplusBSqr._2 ~> {
    case "a" => "a" -> 2
    case "b" => "b" -> 3
  }

  println(sumOfSqr.get)

  for {
    result <- y
    _ = println(result)
  } yield ()

}

trait FormulaRepresentation {
  val aPlusB    = "(aa + bb + 2ab+c)"       -> Array("a", "b", "c")
  val aplusBSqr = "(sqrt(a^2) + sqrt(b^2))" -> Array("a", "b")
}
