package sksingh

object CurryingApp extends App {

  // ver1 => sum, cube, factorial without function

  /*def sumOfInts(a: Int, b: Int): Int = {
    if (a > b) 0
    else a + sumOfInts(a+1, b)
  }

  def sumOfCubeOfInts(a: Int, b: Int): Int = {

    if (a > b) 0
    else math.pow(a,3).toInt + sumOfCubeOfInts(a+1, b)
  }

  def sumOfFactorialOfInts(a: Int, b: Int): Int = {

    def factorial(x: Int): Int = {
      if (x == 0) 1
      else x * factorial(x-1)
    }

    if (a > b) 0
    else factorial(a) + sumOfFactorialOfInts(a+1, b)


  }

  println(sumOfInts(1,4))
  println(sumOfCubeOfInts(1,4))
  println(sumOfFactorialOfInts(1,4))
*/

  // ver2 => sum, cube, factorial function using passed function passed
  /*
    def sumOfInts(f: Int => Int, a: Int, b: Int): Int = {
      if (a > b) 0
      else f(a) + sumOfInts(f,a+1, b)
    }

    def sumOfCubeOfInts(f: Int => Int, a: Int, b: Int): Int = {

      if (a > b) 0
      else f(a) + sumOfCubeOfInts(f,a+1, b)
    }

    def sumOfFactorialOfInts(f: Int => Int, a: Int, b: Int): Int = {

      def factorial(x: Int): Int = {
        if (x == 0) 1
        else x * factorial(x-1)
      }

      if (a > b) 0
      else factorial(f(a)) + sumOfFactorialOfInts(f,a+1, b)


    }

    println(sumOfInts(x => x, 1,4))
    println(sumOfCubeOfInts(x => math.pow(x,3).toInt, 1,4))
    println(sumOfFactorialOfInts(x => x, 1,4))*/

  // ver3 => sum, cube, factorial function returned


  /*def sumOfInts(f: Int => Int) : (Int, Int) => Int = {

    def sumf(a: Int, b: Int): Int = {
      if (a > b) 0
      else f(a) + sumf(a + 1, b)
    }

    sumf
  }

  def sumOfCubeOfInts(f: Int => Int) : (Int, Int) => Int = {

    def sumf(a: Int, b: Int):Int = {
      if (a > b) 0
      else f(a) + sumf( a + 1, b)
    }

    sumf
  }



  println(sumOfInts(x => x)(1,4))
  println(sumOfCubeOfInts(x => math.pow(x,3).toInt)( 1,4))
*/

  // ver4 => use syntactic sugar to return the function

  def sumOfInts(f: Int => Int)(a: Int, b: Int): Int = {

    if (a > b) 0
    else f(a) + sumOfInts(f)(a + 1, b)

  }

  def sumOfCubeOfInts(f: Int => Int) (a:Int, b:Int):Int = {

    if (a > b) 0
    else f(a) + sumOfCubeOfInts(f)(a + 1, b)
  }


  println(sumOfInts(x => x) _)
  println(sumOfCubeOfInts(x => math.pow(x, 3).toInt)(1, 4))



}
