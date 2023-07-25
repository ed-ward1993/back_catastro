lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  .settings(
    name := """backend-prueba-tecnica""",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.13.0",
    libraryDependencies ++= Seq(
      guice,
      javaJpa,
      "org.hibernate" % "hibernate-core" % "5.4.33.Final",
      "org.postgresql" % "postgresql" % "42.5.1",
    ),
    PlayKeys.externalizeResourcesExcludes += baseDirectory.value / "conf" / "META-INF" / "persistence.xml"
  )
