## Exp4s

Scala wrapper around Exp4j library. This is still under-development and 
more features to come. Read more about [exp4j](http://www.objecthunter.net/exp4j/). 

### Maven co-ordinates / download

Exp4s is hosted only my personal github maintained repo server. 
Please find the below co-ordinates to usage.

**current version** 0.0.2

    //moma -> my own maven archive :)
    resolvers ++= Seq("moma" at "https://github.com/prassee/moma/raw/master/snapshots")
    libraryDependencies ++= Seq("me.prassee" %% "exp4s" % "0.0.2")

### Usage

**Step 1**

      import Exp4sProcessor._
      
**Step 2**

      // define formula and its variables as Array[String]
      val aplusBSqr: (String, Array[String]) = "(sqrt(a^2) + sqrt(b^2))" -> Array("a", "b")

**Step3**

      // now just supply values by calling 
      aplusBSqr._1 <~ (aplusBSqr._2 >> Seq(1, 2)
      
### @TODO 

* use macros to simplify usage 
* support for custom functions
* support for async formula execution

### License

Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
