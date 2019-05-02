package algebra

import scala.language.higherKinds

trait MinusAlg[F[_]] {
  def Minus(a: F[Int], b: F[Int]): F[Int]
}

object MinusAlg {
  def apply[F[_]](implicit l: MinusAlg[F]): MinusAlg[F] = l

  implicit class MinusAlgOps[F[_]: MinusAlg](val w1: F[Int]) {
    def minus(w2: F[Int]): F[Int] = MinusAlg[F].Minus(w1, w2)
  }
}
