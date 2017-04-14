package exp4s

import org.scalatest.FlatSpec

class Exp4s extends FlatSpec {
  "an formula" should "print result for the input" in {
    import Exp4sProcessor._
    val x = forFormula("(sqrt(a^2) + sqrt(b^2))")("a", "b")(1, 2)
    println(x)
    // math.pow(10, (27.55 - (20 * math.log10(2412)) + math.abs(sStrength + 5)) / 20)
    val compiledForm: Double = compileFormula("(sqrt(a^2) + sqrt(b^2)) with a,b", 1, 2)
    println(compiledForm)

    val dist = compileFormula("(10^((27.55 - (20 * log10(2412)) + abs(x + 5)) / 20) ) with x", -73)
    println(dist)
  }
}
