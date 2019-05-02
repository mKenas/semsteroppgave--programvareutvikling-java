package programutvikling.kontrollere;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Forsikring;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.base.ReiseForsikring;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.egenDefinertTyper.Handling;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;

public class VisReiseforsikringKontroller implements KontrollerMedKundeInfo, KontrollerMedForsikringInfo {

  @FXML
  Label personNrLabel;
  @FXML
  Label reiseForsikringssumLabel;
  @FXML
  Label reiseForsikringsBelopLabel;
  @FXML
  Label reiseForsikringsomradeLabel;
  @FXML
  Label reiseArligForsikringspremieLabel;
  @FXML
  Label opprettelsesdatoLabel;




  private HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private DataHandlingObjekt dho = new DataHandlingObjekt();
  private BorderPane borderPane = hsk.getBorderPane();
  private DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  private ObservableList kunderListe;
  private Kunde kunde;
  private ReiseForsikring forsikring;

  @Override
  public void setKunde(Kunde kunde) {
    this.kunde = kunde;
    personNrLabel.setText(kunde.getPersonNr());

  }



  public void setForsikring(Forsikring forsikring) {

    if (forsikring instanceof ReiseForsikring) {
      ReiseForsikring f = (ReiseForsikring) forsikring;

      this.forsikring = f;

      reiseForsikringssumLabel.setText(String.valueOf(f.getForsikringsSum()));
      reiseForsikringsBelopLabel.setText(String.valueOf(f.getForsikringsbelop()));
      reiseForsikringsomradeLabel.setText(f.getForsikringsOmrade());
      opprettelsesdatoLabel.setText(f.getOprettelsesDato());
      reiseArligForsikringspremieLabel.setText(String.valueOf(f.getForsikringspremie()));


    }
  }


  @FXML
  public void handleTilbakeKnapp() {

    NavigeringTilVisKundeScene();

  }



  public void initialize() {


  }

  public void handleNavigerTilRedigerReiseforsikringKnapp() {

    Navigator.visSceneMedForsikringInfo(borderPane,Handling.REDIGER,forsikring, kunde);



  }


  @FXML
  public void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }

  @FXML
  public void handleSlettForsikringKnapp() {

    dho.getKundeMedForsikringListeHandling().slettForsikring(forsikring, kunde);
    NavigeringTilVisKundeScene();

  }

  }

