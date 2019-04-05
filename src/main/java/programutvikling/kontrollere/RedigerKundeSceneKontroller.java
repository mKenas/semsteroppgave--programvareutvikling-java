package programutvikling.kontrollere;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import programutvikling.base.HovedSceneKontainer;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataSourceObject;

import java.io.IOException;

public class RedigerKundeSceneKontroller {

  DataSourceObject dso = DataSourceObject.getInstance();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();

  private Kunde kunde = null;

  @FXML
  private TextField navn;
  @FXML
  private TextField fakturaadresse;


  public void initialize() {


  }

  public void setNavn(String navn) {

    this.navn.setText(navn);
  }

  public void setFakturaadresse(String fakturaadresse) {

    this.fakturaadresse.setText(fakturaadresse);
  }

  public void setKunde(Kunde k) {
    this.kunde = k;
    setNavn(kunde.getNavn());
    setFakturaadresse(kunde.getFakturaAdresse());
  }

  @FXML
  public void handleRedigerKundeKnapp() {

    NavigeringTilRegistrerKundeScene();
  }


  protected void NavigeringTilRegistrerKundeScene() {
    kunde.setNavn(navn.getText());
    kunde.setFakturaAdresse(fakturaadresse.getText());


    try {
      Navigator.visScene(borderPane, new Navigator().getKunderScene());
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
