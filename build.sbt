name := "cellular-automata"

version := "0.1"
scalaVersion := "2.11.7"

// https://mvnrepository.com/artifact/org.processing/core
libraryDependencies += "org.processing" % "core" % "2.2.1"

scalacOptions ++= Seq("-feature")

libraryDependencies ++= Seq(
  "org.scalafx" %% "scalafx" % "8.0.40-R8",
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test")