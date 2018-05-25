name := "cellular-automata"

version := "0.1"
scalaVersion := "2.11.7"

scalacOptions ++= Seq("-feature")

libraryDependencies ++= Seq(
  "org.scalafx" %% "scalafx" % "8.0.40-R8",
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
  "org.processing" % "core" % "2.2.1",
  "org.scalafx" %% "scalafxml-core-sfx8" % "0.3"
)

resolvers += Resolver.sonatypeRepo("releases")
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)