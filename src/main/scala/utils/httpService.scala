package utils

import akka.http.scaladsl.client.RequestBuilding.Get
import akka.http.scaladsl.unmarshalling.Unmarshal

import domain.AdventureMap

import domain.Location
import domain.Cell
import domain.AdventureMap

import spray.json.DefaultJsonProtocol._
import spray.json.RootJsonFormat
import spray.json.RootJsonFormat

import scala.concurrent.Future
import akka.http.javadsl.model.HttpResponse
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.HttpRequest
import akka.http.scaladsl.model.HttpMethods
import akka.http.scaladsl.model.HttpEntity
import akka.http.scaladsl.model.ContentTypes
import java.net.URLEncoder

import scala.concurrent.duration._


object HttpService {
  import spray.json._
  import MyJsonProtocol._
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  import system.dispatcher

  
  def getAdventure: Future[AdventureMap] = {
    val request =
      HttpRequest(
        method = HttpMethods.GET,
        uri = "http://localhost:8080/adventure-map/6f356d57-5c09-4495-9fdb-8b3a403f3fd8"
        )
        
        val responseFuture = Http().singleRequest(request)
        
    val futureEntity: Future[HttpEntity.Strict] = responseFuture.flatMap(_.entity.toStrict(2.seconds))

    futureEntity.map(_.data.utf8String.parseJson.convertTo[AdventureMap])
  }
}
