package exp4s

import net.objecthunter.exp4j.ExpressionBuilder
import scala.util.Try

object Exp4sProcessor {

  private implicit class AsTuple(config: Array[String]) {

    def ~>(values: Seq[Double]): Map[String, Double] = {
      val len = values.length
      val x: Array[(String, Double)] = for {
        conf  <- config
        value <- values.toArray
        same = config.indexOf(conf) == values.indexOf(value)
        if same
      } yield conf -> value
      x.toMap
    }
  }

  private implicit class TupleToValue(formulaRep: String) {
    private val eb = new ExpressionBuilder(formulaRep)

    def ~~>(values: Map[String, Double]): Double =
      values
        .foldLeft(eb.variables(values.keys.toList: _*).build())((a, mapping) => a.setVariable(mapping._1, mapping._2))
        .evaluate()

  }

  def forFormula(formulaStr: String)(variables: String*)(values: Double*): Double =
    formulaStr ~~> (variables.toArray ~> values.toArray)

}
