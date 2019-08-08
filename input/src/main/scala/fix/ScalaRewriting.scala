/*
rule = ReplacingSymbolWithString
*/
package fix

object ScalaRewriting {
  def foo(x: Symbol): Unit = {
    println(x)
  }
  foo('hello)
}
