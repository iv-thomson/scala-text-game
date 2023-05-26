package utils

import domain.Location
import domain.Cell
import domain.AdventureMap

import spray.json._
import scala.io.Source
import scala.util.Success
import scala.util.Failure
import scala.concurrent.Future

object MyJsonProtocol extends DefaultJsonProtocol {
  implicit val locationFormat = jsonFormat4(Location)
  implicit val cellFormat = jsonFormat6(Cell)
  implicit val adventureMapFormat = jsonFormat2(AdventureMap)
}

import MyJsonProtocol._

object JsonMapRepository {
  def readMap: Future[AdventureMap] = {
    HttpService.getAdventure
  }
}
