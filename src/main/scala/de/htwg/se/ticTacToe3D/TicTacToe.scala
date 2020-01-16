package de.htwg.se.ticTacToe3D

import de.htwg.se.ticTacToe3D.aview.Tui
import de.htwg.se.ticTacToe3D.controller.ControllerInterface
import de.htwg.se.ticTacToe3D.controller.controllerComponent.Controller
import de.htwg.se.ticTacToe3D.model.gameComponent.gameImpl.Game
import de.htwg.se.ticTacToe3D.view.gui.TicTacToeGUI

import scala.io.StdIn.readLine

object TicTacToe {
  var controller: ControllerInterface = new Controller(new Game())

  val tui = new Tui(controller)
  val gui = new TicTacToeGUI(controller)
  controller.notifyObservers

  def main(args: Array[String]): Unit = {
    var input: String = if (args == null || args.isEmpty) "" else args(0)
    if (!input.isEmpty) tui.processInputLine(input)
    else do {
      input = readLine()
      tui.processInputLine(input)
    } while (input != "q")
  }
}
