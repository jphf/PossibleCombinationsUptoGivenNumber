package controllers

import javax.inject.{Inject, Singleton}
import play.api.Logger
import play.api.libs.functional.syntax._
import play.api.libs.json.{JsPath, Json, Reads}
import play.api.mvc.{BaseController, ControllerComponents}
import services.QuizService
import utils.pojo.QuizRequestData


@Singleton
class QuizController @Inject()(val controllerComponents: ControllerComponents, quizService: QuizService) extends BaseController {


  private val logger: Logger = Logger(this.getClass)

  def quiz1() = Action { implicit request =>
    val json = request.body.asJson.get
    val data = Json.fromJson[QuizRequestData](json).get
    logger.info(s"${data.Z}")
    logger.info(s"${data.L}")

    val r = quizService.get(data.Z, data.L)

    Ok(Json.toJson(r))
  }


  implicit val quizReads: Reads[QuizRequestData] = (
    (JsPath \ "Z").read[Int] and
      (JsPath \ "L").read[List[Int]]
    ) (QuizRequestData.apply _)
}
