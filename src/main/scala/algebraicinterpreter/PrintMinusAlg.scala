package algebraicinterpreter

import algebra.MinusAlg
import interpreter.Printer

object PrintMinusAlg extends MinusAlg[Printer] {
  override def Minus(a: Printer[Int], b: Printer[Int]): Printer[Int] = new Printer[Int] {
    override def print: String = a.print + " - " + b.print
  }
}
