package sksingh

object SumAndProductGeneralization extends App {


  /*def sumOfInts(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sumOfInts(f)(a + 1, b)
  }*/

  /*def productsOfInt(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * productsOfInt(f)(a + 1, b)
  }*/


  def sumAndProduct(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero
    else combine(f(a), sumAndProduct(f, combine, zero)(a + 1, b))
  }

  def productsOfInt(f: Int => Int)(a: Int, b: Int): Int =  sumAndProduct(x => x, (x, y) => x * y, 1 )(a, b)
  def sumOfInts(f: Int => Int)(a: Int, b: Int): Int =  sumAndProduct(x => x, (x, y) => x + y, 0 )(a, b)

  println(sumOfInts(x => x)(1, 4))
  println(productsOfInt(x => x)(1, 4))
}
