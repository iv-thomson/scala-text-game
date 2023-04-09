package state

import domain.Creature
import commands.CommandMode

class State(
    val message: String = "",
    val mode: CommandMode.CommandMode = CommandMode.CharacterCreationMode,
    val gameState: GameState
) {

  def sendMessage(msg: String) = new State(msg, mode, gameState)
}
