import algebra.ExpAlg._
import algebra.MinusAlg._
import algebra._
import scala.language.higherKinds

object Expressions {
  def exp1[F[_]: ExpAlg]: F[Int] = lit(3) add lit(4)
  def exp2[F[_]: ExpAlg: MinusAlg]: F[Int] = exp1 minus lit(5)
}
