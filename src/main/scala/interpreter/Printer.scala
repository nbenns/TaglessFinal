package interpreter

import algebra.{ExpAlg, MinusAlg}
import algebraicinterpreter.{PrintExpAlg, PrintMinusAlg}

trait Printer[A] {
  def print: String
}

object Printer {
  implicit val prettyPrintLang: ExpAlg[Printer] = PrintExpAlg
  implicit val printMinusAlg: MinusAlg[Printer] = PrintMinusAlg
}
