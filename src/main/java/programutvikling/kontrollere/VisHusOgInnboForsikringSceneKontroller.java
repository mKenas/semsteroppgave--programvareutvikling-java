package programutvikling.kontrollere;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Forsikring;
import programutvikling.base.HusOgInnboForsikring;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.egenDefinertTyper.Handling;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;

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
  private JFXButton redigerHusOgInnboForsikringKnapp;
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
  @FXML
  private Label innboForsikringsbelopLabel;




  public void initialize() {


  }


  public void setForsikring(Forsikring forsikring) {

    if (forsikring instanceof HusOgInnboForsikring) {
      HusOgInnboForsikring f = (HusOgInnboForsikring) forsikring;

      this.forsikring = f;

      adresseLabel.setText(f.getBoligAdresse());
      byggearLabel.setText(f.getByggeAr());
      boligTypeLabel.setText(f.getBoligType());
      byggeMaterialeLabel.setText(f.getByggeMateriale());
      standardLabel.setText(f.getStandard());
      antallKvadratmeterLabel.setText(f.getStorrelse());
      forsikringsBelopLabel.setText(String.valueOf(f.getForsikringsbelop()));
      forsikringsPremieLabel.setText(String.valueOf(f.getForsikringspremie()));
      bygningForsikringsbelopLabel.setText(String.valueOf(f.getBygningsForsikringsbelop()));
      opprettelsesdatoLabel.setText(f.getOprettelsesDato());
      innboForsikringsbelopLabel.setText(String.valueOf(f.getInnboForsikringsbelop()));

    }

  }

  @FXML
  public void handleTilbakeKnapp() {


    NavigeringTilVisKundeScene();
  }


  @Override
  public void setKunde(Kunde kunde) {
    this.kunde = kunde;
    personNrLabel.setText(kunde.toString());

  }

  @FXML
  public void handleSlettForsikringKnapp() {

    dho.getKundeMedForsikringListeHandling().slettForsikring(forsikring, kunde);
    NavigeringTilVisKundeScene();

  }

  @FXML
  public void handleNavigerTilRedigerHusOgInnboKnapp() {

    Navigator.visSceneMedForsikringInfo(borderPane, Handling.REDIGER,forsikring, kunde );



  }


  @FXML
  public void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }



}
