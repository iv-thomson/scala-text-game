package domain

case class Location(
    creatureIds: List[String],
    description: String,
    id: String,
    name: String
)
case class Cell(
    description: String,
    encounterThreshold: Int,
    encounters: List[String],
    id: String,
    location: Location,
    neighbours: List[String]
)
case class AdventureMap(cells: List[Cell], id: String) {

  override def toString = {
    val content =
      for (i <- cells.indices)
        yield " " * 8 + s"$i) ${cells(i).location.name}\n"

    "Available locations:\n" + content.mkString("")
  }
}
