package sksingh

object SquareRoot extends App {

  private val INITIAL_GUESS = 1
  private val MARGIN = 0.01

  def sqrt(x: Double): Double = {

    def sqrtIter(x: Double, estimate: Double): Double = {
      val newGuess = improve(x, estimate)
      if (isGoodEnough(x, improve(x, estimate))) newGuess else sqrtIter(x, newGuess)
    }

    def improve(x: Double, guess: Double): Double = (guess + (x / guess)) / 2

    def isGoodEnough(x: Double, guess: Double) = ((x - guess * guess).abs) / x < MARGIN

    sqrtIter(x, INITIAL_GUESS)
  }


  println(sqrt(0.001))
  println(sqrt(0.1e-20))
  println(sqrt(1.0e20))
  println(sqrt(1.0e50))

}
