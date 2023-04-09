package commands

import state.State
import domain.Creature
import utils.Input
import utils.IOService
import state.GameState

case class CreatePlayerState(val player: Creature = Creature.empty) {
  def hasName = player.name != ""
  def hasHealth = player.health != 0
  def hasDamage = player.damage != 0
}

class CreatePlayer extends Command {
  def exec(state: State, arguments: List[String]): State = {
    state.sendMessage("enter a name")
  }
}
