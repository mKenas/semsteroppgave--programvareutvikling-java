package programutvikling.kontrollere;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import programutvikling.base.HovedSceneKontainer;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataSourceObject;

import java.io.IOException;


public class RegistrerKundeSceneKontroller {

  DataSourceObject dso = DataSourceObject.getInstance();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();

  @FXML
  private TextField navn;
  @FXML
  private TextField fakturaadresse;


  @FXML
  private void handleRegistrerKundeKnapp() {
    Kunde kunde = new Kunde(navn.getText(), fakturaadresse.getText());
    dso.leggTilKunde(kunde);
    navigeringTilKunederScene();
  }

  protected void navigeringTilKunederScene() {

    try {
      Navigator.visScene(borderPane, new Navigator().getKunderScene());
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
