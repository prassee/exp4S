package exp4s

import org.scalatest.FlatSpec

/**
  *
  */
class Exp4sTestSuite extends FlatSpec {

  "an formula" should "print result for the input" in {

    import Exp4sProcessor._

    val aplusBSqr: (String, Array[String]) = "(sqrt(a^2) + sqrt(b^2))" -> Array("a", "b")

    val sumOfSqr = aplusBSqr._1 ~= aplusBSqr._2 ~> {
      case "a" => "a" -> 2
      case "b" => "b" -> 3
    }

    val withFnMatch = aplusBSqr._1 <~ aplusBSqr._2 ~> {
      case "a" => "a" -> 1.0
      case "b" => "b" -> 3.0
    }

    val withValue = aplusBSqr._1 <~ (aplusBSqr._2 >> Seq(1, 2))

    println(sumOfSqr)
    println(withFnMatch)
  }

}
