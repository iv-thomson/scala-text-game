package state

import domain.Creature

class State(
    val message: String = "",
    val currentCommand: String = "",
    val gameState: GameState = GameState.empty
) {

  def sendMessage(msg: String) = new State(msg, currentCommand, gameState)
}

object State {
  def empty = new State()
}
