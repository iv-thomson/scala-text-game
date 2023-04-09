package commands

package commands

import state.State

class Go extends Command {
  def exec(state: State, arguments: List[String]): State = {
    val index = arguments(0).toIntOption
    index match {
      case Some(value) => handleLocationChange(value, state)
      case None =>
        state.sendMessage(
          "Please provide a number matching a location. To see all locations type 'status'"
        )
    }
  }

  def handleLocationChange(index: Int, state: State): State = {
    state.gameState.getNeighbour(index) match {
      case Some(value) =>
        new State(
          s"You went to ${value.location.name}\n${value.location.description}",
          state.mode,
          state.gameState.go(index)
        )
      case None => state.sendMessage("You didn't go anywhere.")
    }
  }
}
