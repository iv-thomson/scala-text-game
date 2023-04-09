package utils

import domain.Location
import domain.Cell
import domain.AdventureMap

import spray.json._
import scala.io.Source

object MyJsonProtocol extends DefaultJsonProtocol {
  implicit val locationFormat = jsonFormat4(Location)
  implicit val cellFormat = jsonFormat6(Cell)
  implicit val adventureMapFormat = jsonFormat2(AdventureMap)
}

import MyJsonProtocol._

object JsonMapRepository {
  def readMap: AdventureMap = {

    val fileContents =
      Source.fromFile("./output/adventureMap.json").getLines.mkString

    fileContents.parseJson.convertTo[AdventureMap]
  }
}
