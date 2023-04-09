package utils

import state.State
import commands.Command

object CommandLoop {
  def run(
      state: State,
      exitKeyword: String = "exit"
  ): State = {
    println(state.message)
    val input = Input.parse(IOService.read)

    if (input.value == exitKeyword) {
      state
    } else {
      val newState = Command
        .get(state, input.value)
        .exec(state, input.arguments)

      run(
        newState
      )
    }
  }

}
