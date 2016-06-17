package exp4s

import net.objecthunter.exp4j.ExpressionBuilder

object Exp4sProcessor {

  implicit class AsTuple(config: Array[String]) {
    def ~>(fn: (String) => (String, Double)): Map[String, Double] = config.map(fn).toMap
  }

  implicit class TupleToValue(formulaRep: String) {
    private val eb = new ExpressionBuilder(formulaRep)
    def ~=(values: Map[String, Double]): Double =
      values
        .foldLeft(eb.variables(values.keys.toList: _*).build())((a, mapping) =>
              a.setVariable(mapping._1, mapping._2))
        .evaluate()
  }
}
