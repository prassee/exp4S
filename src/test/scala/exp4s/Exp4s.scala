package exp4s

import org.scalatest.FlatSpec

class Exp4s extends FlatSpec {
  "an formula" should "print result for the input" in {
    import Exp4sProcessor._

    val x = forFormula("(sqrt(a^2) + sqrt(b^2))")("a", "b")(1, 2)
    println(x)

    val compiledForm: Double = compileFormula("(sqrt(a^2) + sqrt(b^2)) with a,b", 1, 2)
    println(compiledForm)

  }
}
