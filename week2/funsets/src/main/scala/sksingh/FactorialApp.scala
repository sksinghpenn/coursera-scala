package sksingh

import scala.annotation.tailrec

object FactorialApp extends App {


  def factorial(x: Int): Int = {

    @tailrec
    def factorial(x: Int, acc: Int): Int = {
      if (x == 0) acc
      else factorial((x - 1), x * acc)
    }

    factorial(x, 1)
  }

  println(factorial(6))
}
