package commands

import state.State

abstract class Command {
  def exec(state: State, arguments: List[String] = List.empty): State
}

object Command {
  def getFromState(state: State, name: String) = {
    if (state.currentCommand != "") {
      Command.get(state.currentCommand)
    } else {
      Command.get(name)
    }
  }
  def get(name: String): Command = {
    if (name == "create") {
      new CreatePlayer();
    } else {
      new UnknownCommand()
    }
  }
}
