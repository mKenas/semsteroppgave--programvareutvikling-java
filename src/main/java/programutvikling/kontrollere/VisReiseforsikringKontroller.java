package programutvikling.kontrollere;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import programutvikling.base.*;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;

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




  private HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private DataHandlingObjekt dho = new DataHandlingObjekt();
  private BorderPane borderPane = hsk.getBorderPane();
  private DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  private ObservableList kunderListe;
  private Kunde kunde;
  private ReiseForsikring forsikring;


  public void setKunde(Kunde k) {
    this.kunde = k;
    this.personNrLabel.setText(k.toString());

  }


  public void setForsikring(Forsikring forsikring) {

    if (forsikring instanceof ReiseForsikring) {
      ReiseForsikring f = (ReiseForsikring) forsikring;

      this.forsikring = f;

      reiseForsikringssumLabel.setText(String.valueOf(f.getForsikringssum()));
      reiseForsikringsBelopLabel.setText(String.valueOf(f.getForsikringsbelop()));
      reiseArligForsikringspremieLabel.setText(String.valueOf(f.getForsikringspremie()));
      reiseForsikringsomradeLabel.setText(f.getForsikringsområde());



    }
  }


  @FXML
  public void handleTilbakeKnapp() {

    NavigeringTilVisKundeScene();

  }



  public void initialize() {


  }




  @FXML
  public void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }
  }

