package state

import domain.Creature

class GameState (hasPlayer: Boolean = false, player: Creature = Creature.empty){}
object GameState {
  def empty = new GameState()
}
