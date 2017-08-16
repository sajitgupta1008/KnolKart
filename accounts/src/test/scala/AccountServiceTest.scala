import main.scala.{AccountService, User}

class AccountServiceTest extends org.scalatest.FunSuite {

  val user = User("sajit123", "qwerty123", 8743922586L)

  val accountService = new AccountService()

  import accountService._

  test("should be able to add user") {
    assert(addUser(user))
  }

  test("fail to add duplicate user") {
    assert(!addUser(user))
  }

  test("authenticate user with success") {
    assert(!authenticate("sajit123", "qwerty123").equals("fail"))
  }

  test("fail to authenticate user ") {
    assert(!authenticate("sajit123", "qwerty123").equals("fail"))
  }
}
