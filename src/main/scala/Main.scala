import cats.Monad
import cats.effect.{ConcurrentEffect, ExitCode, IO, IOApp}
import cats.implicits._
import interpreter._
import org.http4s.client.blaze.BlazeClientBuilder
import service.MathService
import scala.concurrent.ExecutionContext.global
import scala.language.higherKinds

object Main extends IOApp {
  def prg[F[_]: Monad: ConcurrentEffect]: F[ExitCode] =
    BlazeClientBuilder[F](global)
      .resource
      .use { implicit client =>
        implicit val mathsvc = MathService[F]

        val exp = Expressions.exp2[MathAPI[F, ?]]
        val res = exp.api

        res.map(r => println(s"interpreted full: $r")) *> Monad[F].pure(ExitCode.Success)
        //println(s"interpreted full (as pretty print): ${Expressions.exp2[Printer].print}")
      }

  override def run(args: List[String]): IO[ExitCode] = prg[IO]
}
