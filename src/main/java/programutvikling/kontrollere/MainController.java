package programutvikling.kontrollere;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import programutvikling.base.Person;
import programutvikling.base.PersonObjectReader;
import programutvikling.base.PersonObjectWriter;
import programutvikling.kontrollere.uihelpers.FileExceptionHandler;

import java.io.IOException;

public class MainController {
  private static final String PERSON_FILE_PATH = "person.jobj";

  @FXML
  private Label lblName;

  @FXML
  private Label lblAge;

  private Person myPerson;

  public void initialize() {
    try {
      myPerson = PersonObjectReader.read(PERSON_FILE_PATH);
    } catch (Exception e) {
      // create "default" person
      myPerson = new Person("Ola", 19);
      // merk: her fanger jeg Exception fordi jeg håndterer alle
      // typer unntak likt. Man bør allikevel påse at det ikke er noen bug her
      System.out.println("[Read Fail] " + e.getMessage());
    }

    myPerson.observe(this::personChanged);
    personChanged();
  }

  private void personChanged() {
    lblName.setText(myPerson.getName());
    lblAge.setText(String.valueOf(myPerson.getAge()));
  }

  @FXML
  private void editPersonBtnClicked() {
    launchEditPersonScene();
  }

  private void launchEditPersonScene() {
    Parent root = null;
    try {
      FXMLLoader fxmlLoader = new FXMLLoader();
      root = fxmlLoader.load(getClass().getResource("editPersonScene.fxml").openStream());

      // Får tak i controlleren og overfører referanse til person-objektet
      EditPersonController controller = fxmlLoader.getController();
      controller.setPerson(myPerson);
    } catch (IOException e) {
      e.printStackTrace(); // FXML document should be available
      return;
    }
    Scene scene = new Scene(root);
    // add CSS etc. should be here
    Stage editPersonStage = new Stage();
    editPersonStage.setTitle("Endre person");
    editPersonStage.setScene(scene);

    // set modality - låser "parent" winduet mens dette vinduet er åpent
    editPersonStage.initOwner(lblName.getScene().getWindow());
    editPersonStage.initModality(Modality.WINDOW_MODAL);
    editPersonStage.show();
  }

  @FXML
  private void savePersonBtnClicked() {
    try {
      PersonObjectWriter.write(myPerson, PERSON_FILE_PATH);
    } catch (IOException e) {
      FileExceptionHandler.generateIOExceptionMsg(e);
    }
  }
}
