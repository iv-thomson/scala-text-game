package domain

object MapNavigationService {

  def getNeighbour(
      index: Int,
      currentLocation: Cell,
      adventureMap: AdventureMap
  ): Option[Cell] = {
    getNeighbours(currentLocation, adventureMap).lift(index)
  }

  private def getNeighbours(
      currentLocation: Cell,
      adventureMap: AdventureMap
  ): List[Cell] = {
    currentLocation.neighbours.flatMap((neighbourId) =>
      adventureMap.cells.find(_.id == neighbourId)
    )
  }

  def printAvailableLocations(
      currentLocation: Cell,
      adventureMap: AdventureMap
  ) = {
    val cells = getNeighbours(currentLocation: Cell, adventureMap: AdventureMap)

    (for (i <- cells.indices)
      yield s"${i + 1}) " + cells(i).location.name).mkString("\n" + " " * 8)

  }
}
