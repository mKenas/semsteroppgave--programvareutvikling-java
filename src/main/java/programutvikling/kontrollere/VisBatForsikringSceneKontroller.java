package programutvikling.kontrollere;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import programutvikling.base.*;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;

import java.util.ArrayList;

public class VisBatForsikringSceneKontroller implements KontrollerMedKundeInfo, KontrollerMedForsikringInfo {

  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dho = new DataHandlingObjekt();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();

  private ArrayList<Forsikring> forsikringer;
  private BaatForsikring forsikring;
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

    if (forsikring instanceof BaatForsikring) {
      BaatForsikring f = (BaatForsikring) forsikring;

      this.forsikring = f;

      //personNrLabel.setText(f);
      batEierLabel.setText(f.getEier());
      batensRegistreringsNummerLabel.setText(f.getRegistreringsnummer());
      batTypeLabel.setText(f.getBaatType());
      batModellLabel.setText(f.getBaatType());
      batLengdeLabel.setText(f.getBatLengde());
      batTypeLabel.setText(f.getBaatType());

      batMotortypeLabel.setText(f.getMotortype());
      batMotorStyrkeLabel.setText(f.getMotorstyrke());

      opprettelsesdatoLabel.setText(f.getOprettelsesDato());

      batForsikringsBelopLabel.setText(String.valueOf(f.getForsikringsbelop()));
      batForsikringsPremieLabel.setText(String.valueOf(f.getForsikringspremie()));
      //TODO navigator, diverse annet navigering, on action til knapper osv.



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

  protected void navigeringTilKunderScene() {

    Navigator.visScene(borderPane, Navigator.getKundeListeScene());
  }
}
