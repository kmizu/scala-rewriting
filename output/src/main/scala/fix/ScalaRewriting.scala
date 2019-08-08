package fix

object ScalaRewriting {
  def foo(x: String): Unit = {
    println(x)
  }
  foo("hello")
}
