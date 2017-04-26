package exp4s

import net.objecthunter.exp4j.ExpressionBuilder

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

  def forFormula(formStr: String)(vars: String*)(vals: Double*): Double = formStr ~~> (vars.toArray ~> vals.toArray)

  def compileFormula(formulaSource: String, values: Double*): Double = {
    val x           = formulaSource.split(" with ")
    val rawFormula  = x(0)
    val formulaVars = x(1).split(",")
    forFormula(rawFormula)(formulaVars: _*)(values: _*)
  }

}
