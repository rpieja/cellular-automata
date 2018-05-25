package pl.rpieja.automata.gameOfLife

import scalafx.Includes._
import scalafx.animation.KeyFrame
import scalafx.animation.Timeline
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.event.ActionEvent
import scalafx.scene.control._
import scalafx.scene.layout.{AnchorPane, BorderPane, VBox}
import scalafx.scene.text.Text
import scalafx.scene.{Group, Scene}
import scalafx.util.Duration
import pl.rpieja.automata.gameOfLife.Cell

object App extends JFXApp {

  val cellCanvas = new CellCanvas
  cellCanvas.enablePlotting()

  stage = new PrimaryStage {

    title = "Game of Life"
    width = 800
    height = 600
    resizable = false

    scene = new Scene {
      root = new BorderPane {

        top = new ToolBar {
          val life = new GoL

          val timeline = new Timeline {
            cycleCount = Timeline.Indefinite
            keyFrames = KeyFrame(Duration(100), onFinished = (e: ActionEvent) => {
              val seed = cellCanvas.cellCoords.map(c => new Cell(c._1, c._2))
              cellCanvas.clear()
              val evolved = life.evolve(seed)
              evolved.foreach(cell => cellCanvas.plotCell(cell.x, cell.y))
            })
          }

          val playButton = new ToggleButton("Run") {
            handleEvent(ActionEvent.Action) {
              e: ActionEvent =>
                if (!selected.value) {
                  timeline.pause()
                } else {
                  cellCanvas.disablePlotting()
                  if (cellCanvas.cellCoords.nonEmpty) {
                    timeline.play()
                  }
                }
            }
          }

          val resetButton = new Button("Reset") {
            handleEvent(ActionEvent.Any) {
              e: ActionEvent =>
                if (playButton.selected.value)
                  playButton.fire()

                cellCanvas.clear()
                cellCanvas.enablePlotting()
                timeline.stop()
            }
          }

          content = List(
            playButton,
            resetButton
          )
        }

        center = new Group {
          cellCanvas.width <== width
          cellCanvas.height <== height
          children = cellCanvas
        }
      }
    }
  }
}