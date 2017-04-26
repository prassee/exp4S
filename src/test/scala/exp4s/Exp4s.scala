package exp4s

import org.scalatest.FlatSpec
import org.scalatest._

/**
  * A simple test class excercising prgrammtic expression and exp4s
  */
class Exp4s extends FlatSpec with Matchers {
  println("Exp4s Specification Test")

  import Exp4sProcessor._

  "an formula" should "compile and print same result for the input when excercised with a programatic experssion" in {
    val iss               = -23d
    val valFromOldFormula = (sStrength: Double) => math.pow(10, (27.55 - (20 * math.log10(2412)) + math.abs(sStrength + 5)) / 20)
    val valFromNewFormula = compileFormula("pow(10, (27.55 - (20 * log10(2412)) + abs(a + 5)) / 20) with a", iss)
    valFromOldFormula(iss) shouldBe valFromNewFormula
  }

}
