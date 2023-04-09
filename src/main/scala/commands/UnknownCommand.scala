package commands
import state.State

class UnknownCommand extends Command {
  def exec(state: State, arguments: List[String]): State = {
    state.sendMessage("Unknown command!")
  }
}
