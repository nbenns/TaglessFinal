package algebra

import scala.language.higherKinds

trait ExpAlg[F[_]] {
  def Lit(x: Int): F[Int]
  def Add(a: F[Int], b: F[Int]): F[Int]
}

object ExpAlg {
  def apply[F[_]](implicit l: ExpAlg[F]): ExpAlg[F] = l

  def lit[F[_]: ExpAlg](v: Int): F[Int] = ExpAlg[F].Lit(v)

  implicit class ExprAlgOps[F[_]: ExpAlg](val w1: F[Int]) {
    def add(w2: F[Int]): F[Int] = ExpAlg[F].Add(w1, w2)
  }
}
