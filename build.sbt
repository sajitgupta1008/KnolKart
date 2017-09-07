lazy val commonSettings = Seq(
  version := "1.0",
  scalaVersion := "2.12.1",
  libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.3" % "test"
)

lazy val inventory = (project in file("inventory"))
  .settings(
    commonSettings
  )
lazy val accounts = (project in file("accounts"))
  .settings(
    commonSettings,
    // https://mvnrepository.com/artifact/org.mindrot/jbcrypt
    libraryDependencies += "org.mindrot" % "jbcrypt" % "0.3m"
  )

lazy val checkout = (project in file("checkout")).dependsOn(accounts, inventory).settings(
  commonSettings
)

lazy val dashboard = (project in file("dashboard"))
  .settings(
    commonSettings
  )
lazy val notification = (project in file("notification"))
  .settings(
    commonSettings
  )

lazy val api = (project in file("api"))
  .settings(
    commonSettings
  ).dependsOn(inventory,accounts,checkout, dashboard,notification)

lazy val root = (project in file("."))
  .aggregate(inventory, checkout, dashboard, notification, accounts, api)
  .settings(
    commonSettings
  ).dependsOn(inventory, checkout, dashboard, notification, accounts, api)
