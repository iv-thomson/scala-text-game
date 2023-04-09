package state

import domain.Creature
import domain.AdventureMap
import utils.JsonMapRepository

class GameState(
    val player: Creature = Creature.empty,
    val adventureMap: AdventureMap,
    val currentLocation: String
) {
  def createCharacter(character: Creature) =
    new GameState(character, adventureMap, currentLocation)

  def getStatus(): String = {
    s"""
        - name: ${player.name}
        - health: ${player.health}

        ${adventureMap.toString}
    """
  }
}
