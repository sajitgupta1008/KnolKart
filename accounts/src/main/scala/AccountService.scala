package main.scala

import org.mindrot.jbcrypt.BCrypt

import scala.collection.mutable


class AccountService {

  var userMap: mutable.Map[Long, User] = mutable.Map[Long, User]()

  def addUser(user: User): Boolean = {


    val users = userMap.map(users => users._1 == user.mobileNo)
    if (users.isEmpty || userMap.isEmpty) {
      userMap += (user.mobileNo -> user)
      true
    } else {
      false
    }
  }

  def authenticate(userName: String, password: String): String = {

    val users = userMap.filter(x => x._2.userName == userName && x._2.password == password)
    if (users.isEmpty) {
      "fail"
    }
    else {
      val token = BCrypt.hashpw(password, BCrypt.gensalt())
      token
    }
  }


}
