package sksingh

import scala.annotation.tailrec

object SumOfCubeOfInts extends App {


  def sumOfCubeOfIntsNonTailRecursive(x: Int, y: Int): Int = {

    if (x > y) 0

    else (math.pow(x, 3).toInt + sumOfCubeOfIntsNonTailRecursive(x + 1, y))
  }

  def sumOfCubeOfInts(x: Int, y: Int): Int = {

    @tailrec
    def loop(acc: Int, x: Int, y: Int): Int = {

      if (x > y) acc

      else loop(acc + math.pow(x, 3).toInt, x + 1, y)
    }

    loop(0, x, y)


  }


  println(sumOfCubeOfInts(1, 4))

}
