## Exp4s

Scala wrapper around Exp4j library. This is still under-development and 
more features to come. Read more about [exp4j](http://www.objecthunter.net/exp4j/). 

### Maven co-ordinates / download

Exp4s is hosted only my personal github maintained repo server. 
Please find the below co-ordinates to usage.

**current version** 0.0.3

    //moma -> my own maven archive :)
    resolvers ++= Seq("moma" at "https://github.com/prassee/moma/raw/master/snapshots")
    libraryDependencies ++= Seq("me.prassee" %% "exp4s" % "<current_version>")

### Usage


      import Exp4sProcessor._
      
**Step 2**

      // a more idomatic way of doing
      // pass the formula , the variables followed by the values
      val x = forFormula("(sqrt(a^2) + sqrt(b^2))")("a", "b")(1, 2)
      println(x)

**Step3**

      // shortcut and simplified one  - formula followed by "with" keyword and variables and values as next set of params
      val compiledForm: Double = compileFormula("(sqrt(a^2) + sqrt(b^2)) with a,b", 1, 2)
      println(compiledForm)
      
### @TODO 

* support for custom functions
* support for async formula execution

### License

Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
