lazy val commonSettings = Seq(
  version := "1.0",
  scalaVersion := "2.12.1",
  scapegoatVersion := "1.3.2",

  libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.3" % "test"
)

lazy val inventory = (project in file("inventory"))
  .settings(
    commonSettings
  ).enablePlugins(CopyPasteDetector)

lazy val accounts = (project in file("accounts"))
  .settings(
    commonSettings,
    // https://mvnrepository.com/artifact/org.mindrot/jbcrypt
    libraryDependencies += "org.mindrot" % "jbcrypt" % "0.3m"
  ).enablePlugins(CopyPasteDetector)

lazy val checkout = (project in file("checkout")).dependsOn(accounts, inventory).settings(
  commonSettings
).enablePlugins(CopyPasteDetector)

lazy val dashboard = (project in file("dashboard"))
  .settings(
    commonSettings
  ).enablePlugins(CopyPasteDetector)

lazy val notification = (project in file("notification"))
  .settings(
    commonSettings
  ).enablePlugins(CopyPasteDetector)

lazy val api = (project in file("api"))
  .settings(
    commonSettings
  ).dependsOn(inventory,accounts,checkout, dashboard,notification).
  enablePlugins(CopyPasteDetector)

lazy val root = (project in file("."))
  .aggregate(inventory, checkout, dashboard, notification, accounts, api)
  .settings(
    commonSettings
  ).dependsOn(inventory, checkout, dashboard, notification, accounts, api).
  enablePlugins(CopyPasteDetector)

