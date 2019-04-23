package programutvikling.kontrollere;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import programutvikling.base.*;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;

import java.util.ArrayList;

public class VisHusOgInnboForsikringSceneKontroller implements KontrollerMedKundeInfo, KontrollerMedForsikringInfo {

  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dho = new DataHandlingObjekt();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();

  private ArrayList<Forsikring> forsikringer;
  private HusOgInnboForsikring forsikring;
  private Kunde kunde;

  @FXML
  private Label personNrLabel;
  @FXML
  private Label adresseLabel;
  @FXML
  private Label byggearLabel;
  @FXML
  private Label boligTypeLabel;
  @FXML
  private Label byggeMaterialeLabel;
  @FXML
  private Label standardLabel;
  @FXML
  private Label antallKvadratmeterLabel;
  @FXML
  private Label opprettelsesdatoLabel;
  @FXML
  private Label forsikringsBelopLabel;
  @FXML
  private Label forsikringsPremieLabel;
  @FXML
  private Label bygningForsikringsbelopLabel;


  public void initialize() {


  }


  public void setForsikring(Forsikring forsikring) {

    if (forsikring instanceof HusOgInnboForsikring) {
      HusOgInnboForsikring f = (HusOgInnboForsikring) forsikring;

      this.forsikring = f;
      //personNrLabel.setText(f);
      adresseLabel.setText(f.getBoligAdresse());
      byggearLabel.setText(f.getByggeAr());
      boligTypeLabel.setText(f.getBoligType());
      byggeMaterialeLabel.setText(f.getByggeMateriale());
      standardLabel.setText(f.getStandard());
      antallKvadratmeterLabel.setText(f.getStorrelse());
      forsikringsBelopLabel.setText(String.valueOf(f.getForsikringsbelop()));
      forsikringsPremieLabel.setText(String.valueOf(f.getForsikringspremie()));
      bygningForsikringsbelopLabel.setText(String.valueOf(f.getBygningsForsikringsbelop()));
      opprettelsesdatoLabel.setText(f.getOprettelsesDato().toString());

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
