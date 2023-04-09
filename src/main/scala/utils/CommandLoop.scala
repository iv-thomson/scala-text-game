package utils

import state.State
import commands.Command

object CommandLoop {
  def run(
      state: State = State.empty,
      exitKeyword: String = "exit"
  ): State = {
    val input = Input.parse(IOService.read)

    if (input.value == exitKeyword) {
      state
    } else {
      val newState = Command
        .getFromState(state, input.value)
        .exec(state, input.arguments)

      println(newState.message)
      run(
        newState
      )
    }
  }

}
