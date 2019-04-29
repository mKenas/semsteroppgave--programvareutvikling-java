package programutvikling.kontrollere;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import programutvikling.base.BatForsikring;
import programutvikling.base.Forsikring;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;

import java.util.ArrayList;

public class VisBatForsikringSceneKontroller implements KontrollerMedKundeInfo, KontrollerMedForsikringInfo {

  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dho = new DataHandlingObjekt();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();

  private ArrayList<Forsikring> forsikringer;
  private BatForsikring forsikring;
  private Kunde kunde;


  @FXML
  private Label personNrLabel;
  @FXML
  Label batForsikringsBelopLabel;
  @FXML
  Label batForsikringsPremieLabel;
  @FXML
  Label batEierLabel;
  @FXML
  Label batensRegistreringsNummerLabel;
  @FXML
  Label batTypeLabel;
  @FXML
  Label batModellLabel;
  @FXML
  Label batLengdeLabel;
  @FXML
  Label batensAarsModellLabel;
  @FXML
  Label batMotortypeLabel;
  @FXML
  Label batMotorStyrkeLabel;
  @FXML
  Label opprettelsesdatoLabel;



  public void initialize() {


  }


  public void setForsikring(Forsikring forsikring) {

    if (forsikring instanceof BatForsikring) {
      BatForsikring f = (BatForsikring) forsikring;

      this.forsikring = f;

      //personNrLabel.setText(f);
      batEierLabel.setText(f.getEier());
      batensRegistreringsNummerLabel.setText(f.getRegistreringsNr());
      batTypeLabel.setText(f.getBatType());
      batModellLabel.setText(f.getBatType());
      batLengdeLabel.setText(f.getBatLengde());
      batTypeLabel.setText(f.getBatType());

      batMotortypeLabel.setText(f.getMotorType());
      batMotorStyrkeLabel.setText(f.getMotorStyrke());

      opprettelsesdatoLabel.setText(f.getOprettelsesDato());

      batForsikringsBelopLabel.setText(String.valueOf(f.getForsikringsbelop()));
      batForsikringsPremieLabel.setText(String.valueOf(f.getForsikringspremie()));



    }

  }

  @FXML
  public void handleTilbakeKnapp() {

    NavigeringTilKunderScene();

  }

  protected void NavigeringTilKunderScene() {

    Navigator.visScene(borderPane, Navigator.getKundeListeScene());

  }


  @Override
  public void setKunde(Kunde kunde) {
    this.kunde = kunde;
    personNrLabel.setText(kunde.getPersonNr());

  }

  @FXML
  public void handleSlettForsikringKnapp() {

    dho.getKundeMedForsikringListeHandling().slettForsikring(forsikring, kunde);
    navigeringTilKunderScene();

  }

  @FXML
  protected void navigeringTilKunderScene() {

    Navigator.visScene(borderPane, Navigator.getKundeListeScene());
  }

  @FXML
  public void handleRedigerBatForsikringKnapp() {

    Navigator.visScene(borderPane, Navigator.getREDIGER_BAT_FORSIKRING_SCENE());

  }

}
