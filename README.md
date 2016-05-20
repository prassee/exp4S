#exp4s

A Simple Scala wrapper around Exp4j library


#Usage

      import Exp4s._

      // the below example makes an sync call the SI calculation formula
      // first parameter takes the formula , the next one takes the values for the variables

      val siYield = runFormula(
          "(principle + (principle * rate * duration) / 100)", Array(1000, 10, 2))

      // returns Right(1200.0)
      println(siYield)

      // now lets see what happens when we done supply values for all the variables

      val siYieldWithmissedValue = runFormula(
          "(principle + (principle * rate * duration) / 100)", Array(1000, 10))

      // return Left(not enough values)
      println(siYieldWithmissedValue)
      
