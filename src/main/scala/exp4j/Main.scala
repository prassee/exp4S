package exp4j

import net.objecthunter.exp4j.ExpressionBuilder

object Exp4jClient {
  def runFormula(
      formula: String, values: Array[Double]): Either[String, Double] = {
    val regex = "[a-z]+".r
    val variables =
      regex.findAllMatchIn(formula).toArray.map(x => x.matched).distinct
    val eb = new ExpressionBuilder(formula).variables(variables: _*).build()
    if (variables.length == values.length) {
      for {
        variable <- variables
        value <- values
        _ = {
          if (variables.indexOf(variable) == values.indexOf(value)) {
            eb.setVariable(variable, value)
          }
        }
      } yield ()
      Right(eb.evaluate())
    } else {
      Left("not enough values")
    }
  }
}

object Main extends App {
  val result = Exp4jClient.runFormula(
      "princ + ((princ * n * r) / 100)", Array(1000, 2, 10))

  println(result)
}
