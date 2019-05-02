package algebraicinterpreter

import algebra.ExpAlg
import interpreter.Printer

object PrintExpAlg extends ExpAlg[Printer] {
  override def Lit(v: Int): Printer[Int] = new Printer[Int] {
    override def print: String = s"$v"
  }

  override def Add(a: Printer[Int], b: Printer[Int]): Printer[Int] = new Printer[Int] {
    override def print: String = s"${a.print} + ${b.print}"
  }
}
