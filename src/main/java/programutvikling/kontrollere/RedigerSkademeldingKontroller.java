package programutvikling.kontrollere;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import programutvikling.base.HovedSceneKontainer;
import programutvikling.base.Kunde;
import programutvikling.base.Navigator;
import programutvikling.base.Skademelding;

import java.time.LocalDate;

public class RedigerSkademeldingKontroller implements KontrollerMedSkademeldingInfo, KontrollerMedKundeInfo {
    private HovedSceneKontainer hsk = HovedSceneKontainer.getInstance();
    private BorderPane borderPane = hsk.getBorderPane();

    private Skademelding skademelding;

    private Kunde kunde;


    @FXML
    private TextField personNrTekstfelt;
    @FXML
    private ComboBox forsikringsTypeKomboboks;
    @FXML
    private DatePicker skadeDatoVelger;
    @FXML
    private TextField klokkeslettTekstfelt;
    @FXML
    private TextField skadeTypeTekstfelt;
    @FXML
    private TextArea skadeBeskrivelseTekstfelt;
    @FXML
    private TextArea ovrigSkadeInformasjonTekstfelt;
    @FXML
    private Hyperlink slettSkademeldingKnapp;


    @Override
    public void setSkademelding(Skademelding skademelding) {

        this.skademelding = skademelding;


        forsikringsTypeKomboboks.getSelectionModel().select(skademelding.getForsikringsType());
        skadeDatoVelger.setValue(LocalDate.parse(skademelding.getSkadeDato()));
        klokkeslettTekstfelt.setText(skademelding.getKlokkeSlett());
        skadeTypeTekstfelt.setText(skademelding.getSkadeType());
        skadeBeskrivelseTekstfelt.setText(skademelding.getSkadeBeskrivelse());
        ovrigSkadeInformasjonTekstfelt.setText(skademelding.getOvrigSkadeInformasjon());

    }

    @Override
    public void setKunde(Kunde kunde) {

        this.kunde = kunde;
        personNrTekstfelt.setText(kunde.getPersonNr());

    }

    @FXML
    public void handleRedigerSkademeldingKnapp() {

        String forikringsType = forsikringsTypeKomboboks.getValue().toString();
        String skadeDato = skadeDatoVelger.getValue().toString();
        String klokkeslett = klokkeslettTekstfelt.getText();
        String skadeType = skadeTypeTekstfelt.getText();
        String skadeBeskrivelse = skadeBeskrivelseTekstfelt.getText();
        String ovrigSkadeInformasjon = ovrigSkadeInformasjonTekstfelt.getText();


        skademelding.setForsikringsType(forikringsType);
        skademelding.setSkadeDato(skadeDato);
        skademelding.setKlokkeSlett(klokkeslett);
        skademelding.setSkadeType(skadeType);
        skademelding.setSkadeBeskrivelse(skadeBeskrivelse);
        skademelding.setOvrigSkadeInformasjon(ovrigSkadeInformasjon);

        navigeringTilSkademeldingScene();

    }


    protected void navigeringTilSkademeldingScene() {


        Navigator.visSceneMedSkademeldingInfo(borderPane, Navigator.getVisSkadeMeldingScene(),kunde ,skademelding);
    }

    public void slettSkademeldingKnapp() {




    }

}
