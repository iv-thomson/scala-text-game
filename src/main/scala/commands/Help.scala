package commands

import state.State

class Help extends Command {
  def exec(state: State, arguments: List[String]): State = {
    state.sendMessage("""
        You're in exploration mode now. Here's list of available commands:
        - status - see your current status
    """)
  }
}
