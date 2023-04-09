package utils

case class Input(val value: String, val arguments: List[String]) {}
object Input {
  def parse(raw: String): Input = {
    val stream = raw.split(" ")
    val input = stream(0)

    val arguments = stream.slice(1, stream.length)

    new Input(input, arguments.toList)
  }
}
