package utils

object Quiz1 {
  def getCombination(Z: Int, L: List[Int]): List[List[Int]] = {

    var result = List[List[Int]]()

    def cal(Z: Int, L: List[Int], list: List[Int]): Unit = {

      list.sum match {
        case x if x == Z => {
          result = result :+ list
        }
        case x if x > Z => {}
        case x if x < Z => {
          for (i <- 0 until L.size) {
            val num = L(i)
            cal(Z, L.drop(i), list :+ num)
          }
        }
        case _ => println("what?")
      }
    }

    val l = L.distinct

    cal(Z, l, List[Int]())

    result

  }
}
