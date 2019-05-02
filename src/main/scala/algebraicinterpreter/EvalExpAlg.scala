package algebraicinterpreter

import algebra.ExpAlg
import interpreter.Evaluator

object EvalExpAlg extends ExpAlg[Evaluator] {
  override def Lit(v: Int): Evaluator[Int] = new Evaluator[Int] {
    override def eval: Int = v
  }

  override def Add(a: Evaluator[Int], b: Evaluator[Int]): Evaluator[Int] = new Evaluator[Int] {
    override def eval: Int = a.eval + b.eval
  }
}
