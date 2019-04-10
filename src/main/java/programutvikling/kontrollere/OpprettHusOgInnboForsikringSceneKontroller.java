package programutvikling.kontrollere;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import programutvikling.base.AutoCompleteComboBoxListener;
import programutvikling.base.HovedSceneKontainer;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataSourceObject;

import java.io.IOException;

public class OpprettHusOgInnboForsikringSceneKontroller {
  private HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();
  private DataSourceObject dso = DataSourceObject.getInstance();
  private ObservableList kunderListe;

  @FXML
  private ComboBox kunderListeKomboboks;
  TextField textField;



public void initialize(){

  kunderListe = dso.getKunder();
  kunderListeKomboboks.setItems(kunderListe);
  kunderListeKomboboks.setEditable(true);
  //new AutoCompleteComboBoxListener<>(kunderListeKomboboks);







}



  @FXML
  public void NavigeringTilHusOGInnboForsikringScene(){

    try {
      Navigator.visScene(borderPane, new Navigator().getOPPRETT_HUS_OG_INNBO_FORSIKRING_SCENE());
    } catch (IOException e) {
      e.printStackTrace();
    }

  }



}
