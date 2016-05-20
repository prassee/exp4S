package exp4s

import net.objecthunter.exp4j.ExpressionBuilder

import scala.concurrent.Future

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

  def runFormulaAsycly(
      formula: String,
      values: Array[Double]): Future[Either[String, Double]] = {
    Future {
      runFormula(formula, values)
    }
  }
}
