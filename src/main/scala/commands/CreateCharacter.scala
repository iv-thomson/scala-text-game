package commands

import state.State
import domain.Creature
import utils.Input
import utils.IOService
import state.GameState

class CreateCharacter(input: String) extends Command {
  def exec(state: State, arguments: List[String]): State = {
    new State(
      s"Greetings ${input}. Type 'help' to see list of commands!",
      CommandMode.ExploreMode,
      state.gameState.createCharacter(new Creature(input))
    )
  }
}
