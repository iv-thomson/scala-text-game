package commands

import state.State

class Status extends Command {
  def exec(state: State, arguments: List[String]): State = {
    state.sendMessage(state.gameState.getStatus)
  }
}
