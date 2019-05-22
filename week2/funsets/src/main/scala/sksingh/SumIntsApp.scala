package sksingh

import sksingh.SumOfCubeOfInts.sumOfCubeOfInts

import scala.annotation.tailrec

object SumInts extends App {

  def sumIntsNonTailRecursive(x: Int, y: Int): Int = {

    if (x > y) 0
    else (x + sumInts(x + 1, y))
  }

  def sumOfCubeOfIntsNonTailRecursive(x: Int, y: Int): Int = {

    if (x > y) 0

    else (math.pow(x, 3).toInt + sumOfCubeOfIntsNonTailRecursive(x + 1, y))
  }


  def sumInts(x: Int, y: Int): Int = {

    @tailrec
    def loop(acc: Int, x: Int, y: Int): Int = {

      if (x > y) acc
      else (loop((acc + x), x + 1, y))
    }

    loop(0, x, y)
  }


  def sumOfCubeOfInts(x: Int, y: Int): Int = {

    @tailrec
    def loop(acc: Int, x: Int, y: Int): Int = {

      if (x > y) acc

      else loop(acc + math.pow(x, 3).toInt, x + 1, y)
    }

    loop(0, x, y)


  }

  def sumOfIntsUsingHightOrderFunction(x: Int, y: Int, f: (Int) => Int): Int = {

    @tailrec
    def loop(acc: Int, x: Int, y: Int): Int = {

      if (x > y) acc

      else loop(acc + f(x), x + 1, y)
    }

    loop(0, x, y)

  }

  def identify(x: Int) = x

  def cube(x: Int) = math.pow(x,3).toInt



  println(sumInts(4, 6))
  println(sumOfIntsUsingHightOrderFunction(4, 6, x => x))
  println(sumOfIntsUsingHightOrderFunction(4, 6, identify))
  println(sumOfCubeOfInts(1, 4))
  println(sumOfIntsUsingHightOrderFunction(1, 4, x => math.pow(x, 3).toInt))
  println(sumOfIntsUsingHightOrderFunction(1, 4, cube))


  def sum(f: (Int)=> Int)(a: Int, b:Int) : Int = {
    def loop(a:Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))

    }

    loop(a,0)
  }

  println(sum((x:Int)=> x) (4, 6))

}
