lazy val commonSettings = Seq(
  organization := "mattsu6",
  version := "0.0.1",
  scalaVersion := "2.12.6",
  scalacOptions in Compile ++= Seq(
    "-feature",
    "-deprecation",
    "-unchecked",
    "-encoding", "UTF-8",
    "-Xfatal-warnings",
    "-Xlint",
    "-Xfuture",
    "-language:existentials",
    "-language:implicitConversions",
    "-language:postfixOps",
    "-language:higherKinds",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Ywarn-unused",
    "-Ywarn-unused-import",
    "-Ywarn-value-discard",
  ),
  scalacOptions in console -= "-Ywarn-unused-import",
  scalacOptions in Test ++= Seq("-Yrangepos"),
  test in assembly :={},
  scalafmtOnCompile in ThisBuild := true
)

lazy val sub1 = (project in file("sub1"))
  .settings(
    commonSettings,
    name := "sub1",
    assemblyJarName := { s"${name.value}.jar" },
    libraryDependencies ++= Seq(
      "org.specs2" %% "specs2-core" % "4.0.0" % Test,
      "org.specs2" %% "specs2-mock" % "4.0.0" % Test
    )
  )

lazy val sub2 = (project in file("sub2"))
  .settings(
    commonSettings,
    name := "sub2",
    assemblyJarName := { s"${name.value}.jar" },
    libraryDependencies ++= Seq(
      "org.specs2" %% "specs2-core" % "4.0.0" % Test,
      "org.specs2" %% "specs2-mock" % "4.0.0" % Test
    )
  )