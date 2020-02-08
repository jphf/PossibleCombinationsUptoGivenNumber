package services

import play.api.Logger
import javax.inject.{Inject, Singleton}
import utils.Quiz1

@Singleton
class QuizService {
  private val logger: Logger = Logger(this.getClass)

  def get(Z: Int, L: List[Int]) = {
    Quiz1.getCombination(Z, L)
  }
}
