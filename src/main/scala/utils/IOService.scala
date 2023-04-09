package utils

import scala.io.StdIn.readLine

object IOService {
  def read = readLine
  def write(content: String) = println(content: String)
}
