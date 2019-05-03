package programutvikling.kontrollere;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import programutvikling.base.Forsikring;
import programutvikling.base.FritidsboligForsikring;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
import programutvikling.status.InnboOgfritidValideringStatus;
import programutvikling.validering.InnboOgFritidValidator;
import programutvikling.validering.Validator;

public class OpprettFritidsboligSceneKontroller implements KontrollerMedKundeInfo {

  @FXML
  JFXTextField boligensAdresseTekstfelt;
  @FXML
  JFXTextField byggeArTekstfelt;
  @FXML
  JFXTextField boligTypeTekstfelt;
  @FXML
  JFXTextField byggeMaterialeTekstfelt;
  @FXML
  JFXTextField standardTekstfelt;
  @FXML
  JFXTextField antallkvadratmeterTekstfelt;
  @FXML
  JFXTextField bygningForsikringsbelopTekstfelt;
  @FXML
  JFXTextField innboForsikringsbelopTekstfelt;
  @FXML
  JFXTextField forsikringsbelopTekstfelt;
  @FXML
  JFXTextField forsikringspremieTekstfelt;
  @FXML
  private JFXTextField personNrTekstfelt;



  DataHandlingObjekt dho = new DataHandlingObjekt();
  private HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();
  private DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  private Kunde kunde;
  private Forsikring forsikring;

  @FXML
  private JFXButton opprettForsikringKnapp;


  public void initialize() {





  }

  public void setKunde(Kunde k) {
    this.kunde = k;
    this.personNrTekstfelt.setText(k.toString());


  }


  public void handleOpprettFritidsboligForsikringKnapp() {

    String boligensAdresse = boligensAdresseTekstfelt.getText();
    String byggeAr = byggeArTekstfelt.getText();
    String boligType = boligTypeTekstfelt.getText();
    String byggeMateriale = byggeMaterialeTekstfelt.getText();
    String standard = standardTekstfelt.getText();
    String antallkvadratmeter = antallkvadratmeterTekstfelt.getText();
    Double bygningForsikringsbelop = Double.valueOf(bygningForsikringsbelopTekstfelt.getText());
    Double innboForsikringsbelop = Double.valueOf(innboForsikringsbelopTekstfelt.getText());
    Double forsikringsbelop = Double.valueOf(forsikringsbelopTekstfelt.getText());
    Double forsikringspremie = Double.valueOf(forsikringspremieTekstfelt.getText());



    forsikring = new FritidsboligForsikring(forsikringsbelop, forsikringspremie, "",
            boligensAdresse, byggeAr, boligType, byggeMateriale, standard, antallkvadratmeter, bygningForsikringsbelop, innboForsikringsbelop);


      dho.getKundeMedForsikringListeHandling().leggTilForsikring(forsikring, kunde);
      NavigeringTilVisKundeScene();

  }







  @FXML
  public void NavigeringTilVisKundeScene() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getVIS_KUNDE_SCENE(), kunde);

  }
  @FXML
  public void VisForsikringVillkar(ActionEvent actionEvent) {

  }


}
