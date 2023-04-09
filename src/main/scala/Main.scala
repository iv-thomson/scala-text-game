import utils.CommandLoop
import utils.JsonMapRepository
import state.State
import commands.CommandMode
import state.GameState
import domain.Creature

object Main extends App {
  val map = JsonMapRepository.readMap

  CommandLoop.run(
    new State(
      "Welcome to the Text game. Please enter your name:",
      CommandMode.CharacterCreationMode,
      new GameState(Creature.empty, map, map.cells(0))
    )
  )
}
