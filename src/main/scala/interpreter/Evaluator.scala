package interpreter

import algebra.{ExpAlg, MinusAlg}
import algebraicinterpreter.{EvalExpAlg, EvalMinusAlg}

trait Evaluator[A] {
  def eval: Int
}

object Evaluator {
  implicit val evalExprAlg: ExpAlg[Evaluator] = EvalExpAlg
  implicit val evalMinusAlg: MinusAlg[Evaluator] = EvalMinusAlg
}
