import sbt.Keys.{homepage, organizationName, startYear}

lazy val thisBuildSettings = inThisBuild(List(
  scalaVersion := "2.12.3"
))

lazy val commonSettings = Seq(
  scalacOptions in(Compile, doc) ++= Seq("-no-link-warnings"),
  scalacOptions ++= Seq(
    "-encoding", "UTF-8",
    "-feature",
    "-unchecked",
    "-deprecation",
    "-Xfatal-warnings",
    "-Xlint",
    "-Yno-adapted-args",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Xfuture",
    "-Xlint:-unused,_"
  ),
  crossScalaVersions := Seq("2.12.3", "2.11.11"),
  resolvers += Resolver.bintrayRepo("evolutiongaming", "maven")
)

lazy val publishSettings = Seq(
  homepage := Some(new URL("http://github.com/evolution-gaming/akka-tools")),
  startYear := Some(2017),
  organizationName := "Evolution Gaming",
  organizationHomepage := Some(url("http://evolutiongaming.com")),
  bintrayOrganization := Some("evolutiongaming"),
  releaseCrossBuild := true,
  organization := "com.evolutiongaming",
  licenses := Seq("MIT" -> url("http://www.opensource.org/licenses/mit-license.html"))
)

lazy val allSettings = thisBuildSettings ++ commonSettings ++ publishSettings

lazy val akkaTools = (project
  in file(".")
  settings (name := "test-util")
  settings allSettings
  settings(libraryDependencies ++= Seq("org.mockito" % "mockito-core" % "2.11.0")))