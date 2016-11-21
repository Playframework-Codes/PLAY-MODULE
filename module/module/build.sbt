name := """module"""
version := "1.0-SNAPSHOT"
description := "PlayFramework 2.x module to testing with scala and java"
organization := "com.2ntkh"
organizationName := "NanitaTech, Col."
organizationHomepage := Some(new URL("http://2ntkh.com"))


scalaVersion := "2.11.7"
lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"
crossScalaVersions := Seq("2.10.4", "2.11.7")

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
  "org.reactivemongo" %% "play2-reactivemongo" % "0.12.0",
  "com.google.code.gson" % "gson" % "2.7",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test"
)


