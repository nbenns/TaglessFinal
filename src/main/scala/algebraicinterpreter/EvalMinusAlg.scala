package algebraicinterpreter

import algebra.MinusAlg
import interpreter.Evaluator

object EvalMinusAlg extends MinusAlg[Evaluator] {
  override def Minus(a: Evaluator[Int], b: Evaluator[Int]): Evaluator[Int] = new Evaluator[Int] {
    override def eval: Int = a.eval - b.eval
  }
}
