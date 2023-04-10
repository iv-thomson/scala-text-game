package state

import domain.Creature
import domain.AdventureMap
import utils.JsonMapRepository
import domain.Cell
import domain.Location
import domain.MapNavigationService

class GameState(
    val player: Creature = Creature.empty,
    val adventureMap: AdventureMap,
    val currentLocation: Cell
) {
  def createCharacter(character: Creature): GameState =
    new GameState(character, adventureMap, currentLocation)

  def go(locationIndex: Int): Option[GameState] = {
    MapNavigationService
      .getNeighbour(
        locationIndex,
        currentLocation,
        adventureMap
      )
      .map(new GameState(player, adventureMap, _))

  }

  def getStatus(): String = {

    s"""
        - name: ${player.name}
        - health: ${player.health}

        You are now in ${currentLocation.location.name}

        From here you can go to following places:
        ${MapNavigationService.printAvailableLocations(
        currentLocation,
        adventureMap
      )}"""
  }

}
