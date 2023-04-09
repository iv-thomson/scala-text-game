package commands

import state.State

abstract class Command(val input: String = "") {
  def exec(state: State, arguments: List[String] = List.empty): State
}

object Command {
  def get(state: State, name: String) = {
    CommandFactory.get(state, name)
  }
}
