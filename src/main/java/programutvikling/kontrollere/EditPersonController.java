package programutvikling.kontrollere;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import programutvikling.base.InvalidAgeException;
import programutvikling.base.Person;
import programutvikling.kontrollere.uihelpers.InvalidInputHandler;

public class EditPersonController {
  private Person personToEdit;

  @FXML
  TextField txtName;

  @FXML
  TextField txtAge;

  public void setPerson(Person person) {
    personToEdit = person;
    updateFields();
  }

  private void updateFields() {
    txtName.setText(personToEdit.getName());
    txtAge.setText(String.valueOf(personToEdit.getAge()));
  }

  public void updateAndClose() {
    updatePerson();
    closeWindow();
  }

  private void updatePerson() {
    personToEdit.setName(txtName.getText());
    updateAge();
  }

  private void updateAge() {
    try {
      int inputInt = Integer.parseInt(txtAge.getText());
      personToEdit.setAge(inputInt);
    } catch (NumberFormatException e) {
      InvalidInputHandler.generateAlert("Alder må være et tall. Alderen ble ikke oppdatert!");
    } catch (InvalidAgeException e) {
      InvalidInputHandler.generateAlert("Alder må være mellom 0 og 120. Alderen ble ikke oppdatert!");
    }
  }

  private void closeWindow() {
    Stage myStage = (Stage) txtName.getScene().getWindow();
    myStage.close();
  }

}
