package exp4s

import org.scalatest.FlatSpec

class Exp4sTestSuite extends FlatSpec {
  "an formula" should "print result for the input" in {
    import Exp4sProcessor._
    val x = forFormula("(sqrt(a^2) + sqrt(b^2))")("a", "b")(1, 2)
  }
}
