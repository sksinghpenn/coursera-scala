package sksingh

object CurryingVer2 extends App {

  def sum(x: Int, y: Int, z: Int) : Int = {
    x + y +z
  }


  def sum2(x: Int )(y: Int)(z: Int): Int = x + y + z


}
