package service

import cats.Functor
import cats.implicits._
import org.http4s._
import org.http4s.client.Client
import scala.language.higherKinds

abstract class MathService[F[_]: Functor] {
  protected implicit val client: Client[F]
  protected implicit val decoder: EntityDecoder[F, String]

  private def call(endpoint: String, left: Int, right: Int): F[Int] =
    client.expect[String](
      (uri"https://autoeng-codechallenge-api.herokuapp.com" / endpoint)
        .withQueryParam("left", left)
        .withQueryParam("right", right)
    ).map(s => Math.floor(s.toDouble).toInt)

  def add(left: Int, right: Int): F[Int] = call("add", left, right)
  def subt(left: Int, right: Int): F[Int] = call("subt", left, right)
  def mul(left: Int, right: Int): F[Int] = call("mult", left, right)
  def div(left: Int, right: Int): F[Int] = call("div", left, right)
}

object MathService {
  def apply[F[_]: Functor](implicit clnt: Client[F], dec: EntityDecoder[F, String]): MathService[F] =
    new MathService[F] {
      val client = clnt
      val decoder = dec
    }
}
