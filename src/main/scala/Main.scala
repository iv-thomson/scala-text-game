import utils.CommandLoop
import utils.JsonMapRepository
import state.State
import commands.CommandMode
import state.GameState
import domain.Creature
import scala.concurrent.Future
import domain.AdventureMap
import scala.util.Success
import scala.util.Failure
import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Main extends App {
  implicit val ec: scala.concurrent.ExecutionContext =
    scala.concurrent.ExecutionContext.global
  val adventureFuture: Future[AdventureMap] = JsonMapRepository.readMap

  val completedAdventureFuture = Await.ready(adventureFuture, Duration.Inf)

  completedAdventureFuture.value.get match {
    case Success(adventure) =>
      CommandLoop.run(
        new State(
          "Welcome to the Text game. Please enter your name:",
          CommandMode.CharacterCreationMode,
          new GameState(Creature.empty, adventure, adventure.cells(0))
        )
      )
    case Failure(exception) =>
      println(s"Adventure wasn't loaded due to an exception: $exception")
  }
}
