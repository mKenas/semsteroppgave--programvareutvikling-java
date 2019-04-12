package programutvikling.kontrollere;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import programutvikling.base.HovedSceneKontainer;
import programutvikling.base.Navigator;
import programutvikling.database.DataSourceObject;

import java.io.IOException;

public class OpprettForsikringSceneKontroller {
  private HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();
  private DataSourceObject dso = DataSourceObject.getInstance();
  private ObservableList kunderListe;


  public void initialize() {


  }

  @FXML
  public void NavigeringTilHusOGInnboForsikringScene() {

    try {
      Navigator.visScene(borderPane, new Navigator().getOPPRETT_HUS_OG_INNBO_FORSIKRING_SCENE());
    } catch (IOException e) {
      e.printStackTrace();
    }

  }


}
