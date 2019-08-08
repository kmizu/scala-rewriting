package fix

import scalafix.v1._
import scala.meta._

class ReplacingSymbolWithString extends SemanticRule("ReplacingSymbolWithString") {
  override def fix(implicit doc: SemanticDocument): Patch = {
    val p = doc.tree.collect {
      case symbolLiteral @ Lit.Symbol(_) =>
        Patch.replaceTree(symbolLiteral, s""""${symbolLiteral.value.name}"""")
      case name @ Name("Symbol") =>
        Patch.replaceTree(name, "String")
    }.foldLeft(Patch.empty)(_ + _)
    p
  }
}
