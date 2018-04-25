package pl.rpieja.automata

import processing.core._

class PApp extends PApplet {


  override def setup: Unit = {
    size(1024, 768)
    background(255)
  }

  override def draw(): Unit = super.draw()

}

object Automata extends App {
  PApplet.main("pl.rpieja.automata.PApp")
}
