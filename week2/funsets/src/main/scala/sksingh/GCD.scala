package sksingh

object GCDApp extends App {

  def gcd(a: Int, b: Int): Int= {

    if (b == 0) a
    else gcd(b, a % b)
  }

  println(gcd(4,2))
}
