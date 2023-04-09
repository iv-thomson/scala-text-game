package commands

import state.State

object CommandMode extends Enumeration {
  type CommandMode = Value
  val FightMode, ExploreMode, CharacterCreationMode = Value
}
import CommandMode._

abstract class CommandFactory {
  def get(name: String): Command
}

object CommandFactory {
  def get(state: State, name: String): Command = {
    getFactory(state.mode).get(name)
  }

  private def getFactory(mode: CommandMode): CommandFactory = {
    if (mode == CommandMode.FightMode) {
      new FightCommands()
    } else if (mode == CommandMode.CharacterCreationMode) {
      new CharacterCreationCommands()
    } else {
      new ExploreCommands()
    }
  }
}

class CharacterCreationCommands extends CommandFactory {
  def get(content: String): Command = {
    new CreateCharacter(content);
  }
}

class ExploreCommands extends CommandFactory {
  def get(name: String): Command = {
    if (name == "help") {
      new Help()
    } else if (name == "status") {
      new Status()
    } else {
      new UnknownCommand()
    }
  }
}

class FightCommands extends CommandFactory {
  def get(name: String): Command = {
    if (name == "attack") {
      new UnknownCommand()
    } else {
      new UnknownCommand()
    }
  }
}
