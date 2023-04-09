package state

import domain.Creature
import domain.AdventureMap
import utils.JsonMapRepository
import domain.Cell
import domain.Location

class GameState(
    val player: Creature = Creature.empty,
    val adventureMap: AdventureMap,
    val currentLocation: Cell
) {
  def createCharacter(character: Creature): GameState =
    new GameState(character, adventureMap, currentLocation)

  def go(locationIndex: Int): GameState = {
    getNeighbour(locationIndex) match {
      case Some(value) => new GameState(player, adventureMap, value)
      case None        => new GameState(player, adventureMap, currentLocation)
    }
  }

  def getStatus(): String = {

    s"""
        - name: ${player.name}
        - health: ${player.health}

        You are now in ${currentLocation.location.name}

        From here you can go to following places:
        ${printAvailableLocations}"""
  }

  def getNeighbour(index: Int): Option[Cell] = {
    getNeighbours.lift(index)
  }

  private def getNeighbours: List[Cell] = {
    currentLocation.neighbours.flatMap((neighbourId) =>
      adventureMap.cells.find(_.id == neighbourId)
    )
  }

  private def printAvailableLocations = {
    val cells = getNeighbours

    (for (i <- cells.indices)
      yield s"${i + 1}) " + cells(i).location.name).mkString("\n" + " " * 8)

  }
}
