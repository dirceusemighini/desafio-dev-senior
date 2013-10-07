import ScalaxbKeys._
import de.johoop.jacoco4sbt._
import JacocoPlugin._
// other settings

name := "desafio-dev-senior"

version := "1.0-SNAPSHOT"

play.Project.playScalaSettings

jacoco.settings

scalaxbSettings

//sourceGenerators in Compile <+= scalaxb in Compile

sourceManaged in scalaxb in Compile := new java.io.File("src/main/scala")

libraryDependencies ++= Seq(
  "commons-httpclient" % "commons-httpclient" % "3.1",
  "org.slf4j" % "slf4j-api" % "1.7.2",
  "commons-lang" % "commons-lang" % "2.6",
  "com.typesafe" % "config" % "1.0.2",
  "joda-time" % "joda-time" % "2.3",
  "org.joda" % "joda-convert" % "1.2",
   "com.wordnik" % "swagger-play2_2.10" % "1.2.6-SNAPSHOT",
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.0",
  "org.specs2" %% "specs2" % "1.14" % "test" )