package exp4s

import net.objecthunter.exp4j.ExpressionBuilder
import scala.util.Try

object Exp4sProcessor {

  implicit class AsTuple(config: Array[String]) {
    def ~>(fn: (String) => (String, Double)): Map[String, Double] = config.map(fn).toMap

    def >>(values: Seq[Double]):Map[String, Double]  =  {
      val len =  values.length
      val x: Array[(String, Double)] = for {
        conf <- config
        value <- values.toArray
        same = config.indexOf(conf) == values.indexOf(value)
        if(same)
          } yield conf -> value
      x.toMap
    }

  }

  implicit class TupleToValue(formulaRep: String) {
    private val eb = new ExpressionBuilder(formulaRep)
    def ~=(values: Map[String, Double]): Try[Double] = Try {
      values
        .foldLeft(eb.variables(values.keys.toList: _*).build())((a, mapping) => a.setVariable(mapping._1, mapping._2))
        .evaluate()
    }

    def <~(values: Map[String, Double]): Double =
      values
        .foldLeft(eb.variables(values.keys.toList: _*).build())((a, mapping) => a.setVariable(mapping._1, mapping._2))
        .evaluate()

  }

}
