package commands

package commands

import state.State

class Go extends Command {
  def exec(state: State, arguments: List[String]): State = {
    val index = arguments(0).toInt

    state.gameState.getNeighbour(index) match {
      case Some(mapCell) =>
        new State(
          s"You went to ${mapCell.location.name}\n${mapCell.location.description}",
          state.mode,
          state.gameState.go(index)
        )
      case None => state.sendMessage("You didn't go anywhere.")
    }
  }
}
