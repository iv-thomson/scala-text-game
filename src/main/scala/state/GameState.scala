package state

import domain.Creature

class GameState(val player: Creature = Creature.empty) {
  def getStatus(): String = {
    s"""
        - name: ${player.name}
        - health: ${player.health}
    """
  }
}
object GameState {
  def empty = new GameState()
}
