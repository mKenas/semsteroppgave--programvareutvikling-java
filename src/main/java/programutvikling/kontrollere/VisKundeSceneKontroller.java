package programutvikling.kontrollere;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import programutvikling.base.Forsikring;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.base.Skademelding;
import programutvikling.database.DataHandlingObjekt;
import programutvikling.database.DataLagringObjekt;
import programutvikling.egenDefinertTyper.Handling;
import programutvikling.kontrollere.uihjelpere.HovedSceneKontainer;
import programutvikling.kontrollere.uihjelpere.HyberlinkBygger;
import programutvikling.status.InnlesingOgSkrivingStatus;

public class VisKundeSceneKontroller implements KontrollerMedKundeInfo {

  DataLagringObjekt dlo = DataLagringObjekt.getInstance();
  DataHandlingObjekt dhl = new DataHandlingObjekt();
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
  @FXML
  private JFXButton leggTilForsikringKnapp;
  @FXML
  private JFXButton leggTilSkademeldingKnapp;
  @FXML
  private JFXButton redigerKundeKnapp;
  @FXML
  private Hyperlink slettKundeLink;


  private Forsikring forsikring;
  private Skademelding skademelding;

  public void initialize() {

    leggTilForsikringKnapp.disableProperty().bind(InnlesingOgSkrivingStatus.erInnlesingEllerSkrivingAktiv());
    leggTilSkademeldingKnapp.disableProperty().bind(InnlesingOgSkrivingStatus.erInnlesingEllerSkrivingAktiv());
    redigerKundeKnapp.disableProperty().bind(InnlesingOgSkrivingStatus.erInnlesingEllerSkrivingAktiv());
    slettKundeLink.disableProperty().bind(InnlesingOgSkrivingStatus.erInnlesingEllerSkrivingAktiv());

  }

  public void setKunde(Kunde k) {

    this.kunde = k;
    personNrLabel.setText(k.getPersonNr());
    navnLabel.setText(k.getNavn());
    etternavnLabel.setText(k.getEtternavn());
    epostLabel.setText(k.getEpost());
    mobilLabel.setText(k.getMobil());
    fakturaadresseLabel.setText(k.getFakturaAdresse());
    postnummerLabel.setText(k.getPostNr());
    poststedLabel.setText(k.getPoststed());
    opprettelsesdatoLabel.setText(k.getOpprettelsesDato());


    HyberlinkBygger kundesForsikringHyberlinkBygger = HyberlinkBygger.genererHyberlink(kundesForsikringerKontainer,
            kunde.getForsikringer(), (Forsikring forsikring) -> {

              this.forsikring = forsikring;
              navigeringTilVisHusOgInnboForsikringScene();
            });

    HyberlinkBygger kundeSkademeldingHyberlinkBygger = HyberlinkBygger.genererHyberlink(kundesSkademeldingerKontainer,
            dhl.getKundeMedSkademeldingListeHandling().getSkademeldingListeTilKunde(kunde),
            "Skademelding", (Skademelding skademelding) -> {
              this.skademelding = skademelding;
              navigeringTilSkademeldingScene();
            });

    HyberlinkBygger kundesErstatningerHyberlinkBygger = HyberlinkBygger.genererHyberlink(kundesErstatningerKontainer,
            dhl.getKundeMedSkademeldingListeHandling().getErstatningListeTilKunde(kunde),
            "Erstatning", (Skademelding erstatning) -> {
              this.skademelding = erstatning;
              navigeringTilSkademeldingScene();
            });


    HyberlinkBygger kundesAvvisteErstatningerHyberlinkBygger = HyberlinkBygger.genererHyberlink(kundesAvvisteErstatningerKontainer,
            dhl.getKundeMedSkademeldingListeHandling().getAvvistSkademeldingListeTilKunde(kunde),
            "Avviste erstatningskrav", (Skademelding avvisteErstatningskrav) -> {
              this.skademelding = avvisteErstatningskrav;
              navigeringTilSkademeldingScene();
            });


  }

  @FXML
  public void handleTilbakeKnapp() {


    NavigeringTilKunderScene();
  }

  protected void NavigeringTilKunderScene() {
    Navigator.visScene(borderPane, Navigator.getKundeListeScene());

  }

  protected void navigeringTilVisHusOgInnboForsikringScene() {


    Navigator.visSceneMedForsikringInfo(borderPane, Handling.VIS, forsikring, kunde);
  }

  protected void navigeringTilSkademeldingScene() {


    Navigator.visSceneMedSkademeldingInfo(borderPane, Navigator.getVisSkadeMeldingScene(), kunde, skademelding);
  }

  protected void navigeringTilKunderScene() {


    Navigator.visScene(borderPane, Navigator.getKundeListeScene());
  }


  @FXML
  protected void leggTilNyForsikring() {

    String forsikringsType = forsikringsTypeKomboBoks.getSelectionModel().getSelectedItem().toString();
    Navigator.visOpprettForsikringSceneMedKundeInfo(borderPane, forsikringsType, kunde);

  }

  @FXML
  protected void leggTilSkadeMelding() {

    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getRegistrerSkadeMeldingScene(), kunde);


  }

  @FXML
  public void handleRedigerKundeInfoKnapp() {
    Navigator.visSceneMedKundeInfo(borderPane, Navigator.getREDIGER_KUNDE_SCENE(), kunde);
  }

  @FXML
  public void handleSlettKundeKnapp() {


    dhl.getKundeMedForsikringListeHandling().slettAlleForsikringTilKunde(kunde);
    dhl.getKundeMedSkademeldingListeHandling().slettAlleSkademeldingTilKunde(kunde);
    dhl.getKundeListeHandling().slettKunde(kunde);
    navigeringTilKunderScene();
  }


}
