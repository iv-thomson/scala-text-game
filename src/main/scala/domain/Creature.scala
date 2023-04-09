package domain

case class Creature (val name: String, val health: Int, val damage: Int) {}

object Creature {
    def empty = {
        new Creature ("null", 0, 0)
    }
}