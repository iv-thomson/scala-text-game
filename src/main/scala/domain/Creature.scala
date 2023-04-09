package domain

case class Creature(val name: String, val health: Int = 10) {}

object Creature {
  def empty = {
    new Creature("null")
  }
}
