package state

import domain.Creature
import domain.AdventureMap
import utils.JsonMapRepository
import domain.Cell

class GameState(
    val player: Creature = Creature.empty,
    val adventureMap: AdventureMap,
    val currentLocation: String
) {
  def createCharacter(character: Creature): GameState =
    new GameState(character, adventureMap, currentLocation)

  def go(locationIndex: Int): GameState = {
    getNeighbour(locationIndex) match {
      case Some(value) => new GameState(player, adventureMap, value.id)
      case None        => new GameState(player, adventureMap, currentLocation)
    }
  }

  def getCurrentLocation = {
    val location = adventureMap.cells.find(_.id == currentLocation)
  }

  def getStatus(): String = {

    s"""
        - name: ${player.name}
        - health: ${player.health}

        ${printAvailableLocations}
    """
  }

  def getNeighbour(index: Int): Option[Cell] = {
    val neighbourCells = getNeighbours

    neighbourCells.lift(index)
  }

  def getNeighbours(): List[Cell] = {
    getAvailableLocations match {
      case Some(value) => value
      case None        => List.empty
    }
  }

  def getAvailableLocations: Option[List[Cell]] = {
    val location = adventureMap.cells.find(_.id == currentLocation)
    location.map(
      _.neighbours.flatMap((neighbourId) =>
        adventureMap.cells.find(_.id == neighbourId)
      )
    )
  }

  def printAvailableLocations = {
    getAvailableLocations match {
      case Some(value) => value.map(_.location.name).mkString("\n" + " " * 8)
      case None        => "Something went wrong. Couldn't get locations"
    }
  }
}
