package programutvikling.kontrollere;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Forsikring;
import programutvikling.base.FritidsboligForsikring;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.egenDefinertTyper.Handling;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;

import java.util.ArrayList;

public class VisFritidsboligForsikringSceneKontroller implements KontrollerMedKundeInfo, KontrollerMedForsikringInfo {

  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dho = new DataHandlingObjekt();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();

  private ArrayList<Forsikring> forsikringer;
  private FritidsboligForsikring forsikring;
  private Kunde kunde;

  @FXML
  private Label personNrLabel;
  @FXML
  private Label boligensAdresseLabel;
  @FXML
  private Label byggeArLabel;
  @FXML
  private Label boligTypeLabel;
  @FXML
  private Label byggeMaterialeLabel;
  @FXML
  public Label forsikringsBelopLabel;
  @FXML
  private Label standardLabel;
  @FXML
  private Label bygningForsikringsbelopLabel;
  @FXML
  private Label innboForsikringsbelopLabel;
  @FXML
  private Label forsikringspremieLabel;
  @FXML
  private Label antallKvadratmeterLabel;
  @FXML
  private Label opprettelsesdatoLabel;



  public void initialize() {


  }


  public void setForsikring(Forsikring forsikring) {

    if (forsikring instanceof FritidsboligForsikring) {
      FritidsboligForsikring f = (FritidsboligForsikring) forsikring;

      this.forsikring = f;
      //personNrLabel.setText(f);


      boligensAdresseLabel.setText(f.getBoligAdresse());
      byggeArLabel.setText(f.getByggeAr());
      boligTypeLabel.setText(f.getBoligType());
      byggeMaterialeLabel.setText(f.getByggeMateriale());
      forsikringsBelopLabel.setText(String.valueOf(f.getForsikringsbelop()));
      standardLabel.setText(f.getStandard());
      bygningForsikringsbelopLabel.setText(String.valueOf(f.getBygningsForsikringsbelop()));
      innboForsikringsbelopLabel.setText(String.valueOf(f.getInnboForsikringsbelop()));
      forsikringspremieLabel.setText(String.valueOf(f.getForsikringspremie()));
      antallKvadratmeterLabel.setText(f.getStorrelse());
      opprettelsesdatoLabel.setText(f.getOprettelsesDato());

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
  public void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }

  @FXML
  public void handleNavigerTilRedigerFritidsboligKnapp() {

    Navigator.visSceneMedForsikringInfo(borderPane, Handling.REDIGER,forsikring, kunde );

  }


}
