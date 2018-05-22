package pl.rpieja.automata.gameOfLife

import scalafx.animation.{KeyFrame, Timeline}
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.event.ActionEvent
import scalafx.scene.{Group, Scene}
import scalafx.scene.control.{Button, Separator, ToggleButton, ToolBar}
import scalafx.scene.layout.BorderPane
import scalafx.util.Duration

object App extends JFXApp {

  val canvas = new CellCanvas()
  canvas.enablePlotting()

  stage = new PrimaryStage {
    title = "Automaton"
    width = 800
    height = 600

    scene = new Scene {
      root = new BorderPane() {
        top = new ToolBar {

          val game = new GoL()

//          val timeline = new Timeline{
//            keyFrames = KeyFrame(Duration(100), onFinished = (e: ActionEvent) => {
//              ???
//            })
//          }

          val runToggle = new ToggleButton("Run") {

          }

          val resetButton = new Button("Reset") {

          }

          content = List(
            runToggle,
            resetButton,
            new Separator
          )
        }
        center = new Group {
          canvas.width <== width
          canvas.height <== height
          children = canvas
        }
      }
    }
  }

}
