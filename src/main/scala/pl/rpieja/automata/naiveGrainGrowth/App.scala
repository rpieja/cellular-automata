package pl.rpieja.automata.naiveGrainGrowth

import java.io.IOException
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafxml.core.{NoDependencyResolver, FXMLView}

object App extends JFXApp{

  val resource = getClass.getResource("naiveGrainGrowthWindow.fxml")
  if (resource == null) {
    throw new IOException("Cannot load fxml resource")
  }

  val root = FXMLView(resource, NoDependencyResolver)

  stage = new PrimaryStage() {
    width=1900
    height=1000
    title = "FXML GridPane Demo"
    scene = new Scene(root)
  }

}
