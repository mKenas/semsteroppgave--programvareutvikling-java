package programutvikling.kontrollere;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataLagringObjekt;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;

public class OpprettForsikringSceneKontroller implements KontrollerMedKundeInfo {
  private HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();
  private DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  private ObservableList kunderListe;
  private Kunde kunde;


  public void initialize() {


  }


  public void setKunde(Kunde k) {
    this.kunde = k;


  }

  @FXML
  public void NavigeringTilHusOGInnboForsikringScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getOPPRETT_HUS_OG_INNBO_FORSIKRING_SCENE(), kunde);

  }

  @FXML
  public void VisForsikringVillkar(ActionEvent actionEvent) {

  }

}
