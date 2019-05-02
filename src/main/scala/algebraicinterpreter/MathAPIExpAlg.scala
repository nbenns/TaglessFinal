package algebraicinterpreter

import algebra.ExpAlg
import cats.Monad
import cats.implicits._
import interpreter.MathAPI
import service.MathService

import scala.language.higherKinds

class MathAPIExpAlg[F[_]: Monad] extends ExpAlg[MathAPI[F, ?]] {
  override def Lit(x: Int): MathAPI[F, Int] = new MathAPI[F, Int] {
    def api(implicit svc: MathService[F]): F[Int] = Monad[F].pure(x)
  }

  override def Add(e1: MathAPI[F, Int], e2: MathAPI[F, Int]): MathAPI[F, Int] = new MathAPI[F, Int] {
    override def api(implicit svc: MathService[F]): F[Int] =
      (e1.api, e2.api)
        .mapN(svc.div)
        .flatten
  }
}
