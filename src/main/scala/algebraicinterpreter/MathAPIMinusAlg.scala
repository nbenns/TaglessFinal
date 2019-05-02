package algebraicinterpreter

import algebra.MinusAlg
import cats.Monad
import cats.implicits._
import interpreter.MathAPI
import service.MathService

import scala.language.higherKinds

class MathAPIMinusAlg[F[_]: Monad] extends MinusAlg[MathAPI[F, ?]] {
  override def Minus(e1: MathAPI[F, Int], e2: MathAPI[F, Int]): MathAPI[F, Int] = new MathAPI[F, Int] {
    override def api(implicit svc: MathService[F]): F[Int] =
      (e1.api, e2.api)
        .mapN(svc.subt)
        .flatten
  }
}
