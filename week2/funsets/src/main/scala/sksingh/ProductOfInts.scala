package sksingh

object ProductOfInts extends App {

  def product(f: (Int) => Int)(a: Int, b: Int): Int = {

    if (a > b) 1
    else f(a) * product(f)(a + 1, b)
  }

  def productUsingGeneralizefunc(f: (Int) => Int)(a: Int, b: Int): Int = mapReduce(f, (a, b) => a * b, 1) (a,b)





  def fact(n: Int) = product(x => x)(1, n)

  def mapReduce(f: (Int) => Int, combine: (Int, Int)=> Int, zero: Int)(a: Int, b: Int): Int = {

    if (a > b) zero
    else   combine(f(a), mapReduce(f, combine, zero)(a +1, b))
  }


  println(product(x => x)(1, 3))
  println(productUsingGeneralizefunc(x => x)(1, 3))

  println(fact(3))


}
