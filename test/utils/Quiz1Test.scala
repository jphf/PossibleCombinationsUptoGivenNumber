package utils

import org.scalatest.FunSuite

class Quiz1Test extends FunSuite {
  test("test Quiz 1 case 1") {

    val Z = 5
    val L = List(1, 1, 2, 5, 7)
    val r = Quiz1.getCombination(Z, L)

    assert(r == List(
      List(1, 1, 1, 1, 1),
      List(1, 1, 1, 2),
      List(1, 2, 2),
      List(5)
    ))
  }

  test("test Quiz 1 case 2") {

    val Z = 1
    val L = List(2, 5, 7)
    val r = Quiz1.getCombination(Z, L)

    assert(r == List())
  }
}
