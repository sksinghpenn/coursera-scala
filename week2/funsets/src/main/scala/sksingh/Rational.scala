package sksingh

class Rational(x: Int, y: Int) {

  require(y != 0, "denom can not be zero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  //private val g  = gcd(x,y)

  val numer = x / gcd(x, y)

  val denom = y / gcd(x, y)


  def neg: Rational = -this

  def unary_- = new Rational(-numer, denom)

  def less(that: Rational): Boolean = numer * that.denom < that.numer * denom

  def max(that: Rational): Boolean = if (this.less(that)) false else true


  def add(that: Rational): Rational = {
    val rational = new Rational(this.numer * that.denom + that.numer * this.denom, this.denom * that.denom)
    simplifyRational(rational)
  }

  def +(that: Rational): Rational = {
    add(that)
  }

  def sub(that: Rational): Rational = {
    val rational = add(that.neg)
    simplifyRational(rational)
  }

  def -(that: Rational): Rational = {
    this + (- that)
  }


  def mul(that: Rational): Rational = {
    val rational = new Rational(this.numer * that.numer, this.denom * that.denom)
    simplifyRational(rational)
  }

  def div(that: Rational): Rational = {
    val rational = new Rational(this.numer * that.denom, this.denom * that.numer)
    simplifyRational(rational)
  }

  private def simplifyRational(rational: Rational) = {
    val numer = rational.numer
    val denom = rational.denom
    val gcd = Rational.gcd(numer, denom)
    new Rational(numer / gcd, denom / gcd)
  }

  def mkString: String = toString


  override def toString: String = {

    val g = gcd(this.numer, this.denom)

    if (numer == 0) 0.toString
    else if (denom == 1) numer.toString
    else (numer / g) + "/" + (denom / g)
  }
}


object Rational {
  def mkString(r: Rational) = r.numer + "/" + r.denom


  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)


}

object RationalTest extends App {

  //println(Rational.gcd(2,4))

  //val rational = new Rational(1, 0)

  //println(rational.add(new Rational(1, 2)))

  val r = new Rational(3, 2)
  //println(new Rational(2))

  println(-r)

  //println(new Rational(1, 2) add new Rational(1, 2))

  //println(new Rational(1,2).neg)

  /* println(rational.neg.mkString)

   println(rational.sub(new Rational(1, 3)).mkString)


   val x = new Rational(1, 3)
   val y = new Rational(5, 7)
   val z = new Rational(3, 2)

   val result1 = x - y - z


   println(result1)

   val result2 = x.sub(y).sub(z)

   println(result2)

   println(x.add(y).mul(z))
 */


  /*println(rational add new Rational(1, 4)  )




  println(rational.mul(new Rational(1, 4)).mkString)

  println(rational.div(new Rational(1, 4)).mkString)*/

  /* println(rational.less(new Rational(1,3)))
   println(rational.max(new Rational(1,3)))


   println(new Rational(1, 0))*/


}