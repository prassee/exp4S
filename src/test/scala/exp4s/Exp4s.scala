package exp4s

import org.scalatest.{ FlatSpec }

class Exp4sTestSuite extends FlatSpec with FormulaRepresentation {

  "an formula" should "print result for the input" in {

    import Exp4sProcessor._

    lazy val y = aPlusB._1 ~= aPlusB._2 ~> {
      case "a" => "a" -> 2.0
      case "b" => "b" -> 3.0
      case _   => "_" -> 0.0
    }

    val sumOfSqr = aplusBSqr._1 ~= aplusBSqr._2 ~> {
      case "a" => "a" -> 2
      case "b" => "b" -> 3
    }

    val withFnMatch = aplusBSqr._1 <~ aplusBSqr._2 ~> {
      case "a" => "a" -> 1.0
      case "b" => "b" -> 3.0
    }

    val withValue = aplusBSqr._1 <~ (aplusBSqr._2 >>> Seq(1.0, 2.0))

    println(sumOfSqr)
    println(withFnMatch)
    println(aplusBSqr._2 >>> Seq(1.0, 2.0))
    println(withValue)

  }

}

trait FormulaRepresentation {
  val aPlusB: (String, Array[String])    = "(aa + bb + 2ab+c)"       -> Array("a", "b", "c")
  val aplusBSqr: (String, Array[String]) = "(sqrt(a^2) + sqrt(b^2))" -> Array("a", "b")
}
