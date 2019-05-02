name := "TaglessFinal"

version := "0.1"

scalaVersion := "2.12.8"

addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.10.0")

val http4sVersion = "0.20.0"

libraryDependencies ++= Seq(
  "org.typelevel"     %% "cats-core"            % "1.5.0",
  "com.chuusai"       %% "shapeless"            % "2.3.3",
  "org.http4s"        %% "http4s-dsl"           % http4sVersion,
  "org.http4s"        %% "http4s-blaze-client"  % http4sVersion,
  "org.scalatest"     %% "scalatest"            % "3.0.5"           % Test
)
