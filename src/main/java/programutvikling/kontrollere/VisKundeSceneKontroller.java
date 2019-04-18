package programutvikling.kontrollere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import programutvikling.base.*;
import programutvikling.base.klassHjelpere.SkademeldingStatus;
import programutvikling.database.DataSourceObject;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class VisKundeSceneKontroller implements KontrollerMedKundeInfo {

  DataSourceObject dso = DataSourceObject.getInstance();
  HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
  private BorderPane borderPane = hsk.getBorderPane();

  private Kunde kunde;

  @FXML
  private Label personNrLabel;
  @FXML
  private Label navnLabel;
  @FXML
  private Label etternavnLabel;
  @FXML
  private Label epostLabel;
  @FXML
  private Label mobilLabel;
  @FXML
  private Label fakturaadresseLabel;
  @FXML
  private Label postnummerLabel;
  @FXML
  private Label poststedLabel;
  @FXML
  private Label opprettelsesdatoLabel;
  @FXML
  private ComboBox forsikringsTypeKomboBoks;

  @FXML
  private VBox kundesForsikringerKontainer;
  @FXML
  private VBox kundesSkademeldingerKontainer;
  @FXML
  private VBox kundesErstatningerKontainer;
  @FXML
  private VBox kundesAvvisteErstatningerKontainer;


  private Forsikring forsikring;
private Skademelding skademelding;

  public void initialize() {



  }

  public void setKunde(Kunde k) {
    this.kunde = k;
    //this.forsikring = (HusOgInnboForsikring) kunde.getForsikringer().get(0);
    personNrLabel.setText(k.getPersonNr());
    navnLabel.setText(k.getNavn());
    etternavnLabel.setText(k.getEtternavn());
    epostLabel.setText(k.getEpost());
    mobilLabel.setText(k.getMobil());
    fakturaadresseLabel.setText(k.getFakturaAdresse());
    postnummerLabel.setText(k.getPostnummer());
    poststedLabel.setText(k.getPoststed());
    opprettelsesdatoLabel.setText(k.getOpprettelsesDato());

    if(kunde.getForsikringer().size() >0) {
      AtomicInteger teller = new AtomicInteger();
      kunde.getForsikringer().forEach(forsikring -> {
        Hyperlink hyperlink = new Hyperlink(((HusOgInnboForsikring) forsikring).getForsikringsType() + " " + teller.incrementAndGet());
        hyperlink.setOnAction((ActionEvent event) -> {
          this.forsikring = (HusOgInnboForsikring) forsikring;

          navigeringTilVisHusOgInnboForsikringScene();
        });

        kundesForsikringerKontainer.getChildren().add(hyperlink);

      });

    }

    if(kunde.getSkadeMeldinger().size() >0) {
      AtomicInteger teller = new AtomicInteger();
      kunde.getSkadeMeldinger().forEach(skadeMelding -> {
        Hyperlink hyperlink = new Hyperlink();
        hyperlink.setText("Skademelding " + teller.incrementAndGet());
        hyperlink.setOnAction((ActionEvent event) -> {
          this.skademelding = skadeMelding;

          navigeringTilSkademeldingScene();
        });

        kundesSkademeldingerKontainer.getChildren().add(hyperlink);

      });


    }

    if(kunde.getErstatninger().size() >0) {
      AtomicInteger teller = new AtomicInteger();
      kunde.getErstatninger().forEach(erstatning -> {
        Hyperlink hyperlink = new Hyperlink();
        hyperlink.setText("Erstatning " + teller.incrementAndGet());
        hyperlink.setOnAction((ActionEvent event) -> {
          this.skademelding = erstatning;

         navigeringTilSkademeldingScene();
        });

          kundesErstatningerKontainer.getChildren().add(hyperlink);

      });

    }


    if(kunde.getAvvisteErstatninger().size() >0) {
      AtomicInteger teller = new AtomicInteger();
      kunde.getAvvisteErstatninger().forEach(erstatning -> {
        Hyperlink hyperlink = new Hyperlink();
        hyperlink.setText("Avvist erstatningskrav " + teller.incrementAndGet());
        hyperlink.setOnAction((ActionEvent event) -> {
          this.skademelding = erstatning;

          navigeringTilSkademeldingScene();
        });

        kundesAvvisteErstatningerKontainer.getChildren().add(hyperlink);





      });

    }

  }

  @FXML
  public void handleTilbakeKnapp() {


    NavigeringTilKunderScene();
  }

  protected void NavigeringTilKunderScene() {
    Navigator.visScene(borderPane, Navigator.getKunderScene());

  }

  protected void navigeringTilVisHusOgInnboForsikringScene() {


    Navigator.visSceneMedForsikringInfo(borderPane, Navigator.getVIS_HUS_OG_INNBO_FORSIKRING_SCENE(),kunde ,forsikring);
  }

  protected void navigeringTilSkademeldingScene() {


    Navigator.visSceneMedSkademeldingInfo(borderPane, Navigator.getVisSkadeMeldingScene(),kunde ,skademelding);
  }

  @FXML
  protected  void leggTilNyForsikring(){

    String forsikringsType = forsikringsTypeKomboBoks.getSelectionModel().getSelectedItem().toString();
    Navigator.visForsikringSceneMedKundeInfo(borderPane, forsikringsType,kunde);

  }

  @FXML
  protected void  leggTilSkadeMelding(){

    Navigator.visSceneMedKundeInfo(borderPane,Navigator.getRegistrerSkadeMeldingScene(),kunde);


  }
  @FXML public void handleRedigerKundeInfoKnapp(){
    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getREDIGER_KUNDE_SCENE(),kunde);
  }



}
