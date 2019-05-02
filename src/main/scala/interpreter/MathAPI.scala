package interpreter

import algebra.{ExpAlg, MinusAlg}
import algebraicinterpreter.{MathAPIExpAlg, MathAPIMinusAlg}
import cats.Monad
import service.MathService
import scala.language.higherKinds

abstract class MathAPI[F[_]: Monad, A] {
  def api(implicit svc: MathService[F]): F[A]
}

object MathAPI {
  implicit def imathapiExpAlg[F[_]: Monad]: ExpAlg[MathAPI[F, ?]] = new MathAPIExpAlg[F]
  implicit def imathapiMinusAlg[F[_]: Monad]: MinusAlg[MathAPI[F, ?]] = new MathAPIMinusAlg[F]
}

