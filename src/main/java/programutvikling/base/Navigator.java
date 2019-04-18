package programutvikling.base;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import programutvikling.kontrollere.KontrollerMedForsikringInfo;
import programutvikling.kontrollere.KontrollerMedKundeInfo;
import programutvikling.kontrollere.KontrollerMedSkademeldingInfo;

import java.io.IOException;

public abstract class Navigator {


  private static final String DASHBORD_SCENE ="/programutvikling/views/dashbordScene.fxml";
  private static final String FORSIKRING_SCENE ="/programutvikling/views/forsikringer.fxml";
  private static final String KUNDER_SCENE = "/programutvikling/views/kunderScene.fxml";
  private static final String REGISTRER_KUNDE_SCENE = "/programutvikling/views/registrerKundeScene.fxml";
  private static final String REDIGER_KUNDE_SCENE ="/programutvikling/views/redigerKundeScene.fxml";
  private static final String ERSTATNINGER_SCENE= "/programutvikling/views/erstatningerScene.fxml";
  private static final String SKADER_SCENE ="/programutvikling/views/skaderScene.fxml";
  private static final String VIS_KUNDE_SCENE = "/programutvikling/views/visKundeScene.fxml";
  private static final String OPPRETT_FORSIKRING_SCENE ="/programutvikling/views/opprettForsikringScene.fxml";
  private static final String OPPRETT_HUS_OG_INNBO_FORSIKRING_SCENE = "/programutvikling/views/opprettHusOgInnboForsikringScene.fxml";
  private static final String VIS_HUS_OG_INNBO_FORSIKRING_SCENE ="/programutvikling/views/visHusOgInnboForsikringScene.fxml";
  private static final String REGISTRER_SKADE_MELDING_SCENE = "/programutvikling/views/registrerSkademeldingScene.fxml";
  private static final String VIS_SKADE_MELDING_SCENE = "/programutvikling/views/visSkadeMeldingScene.fxml";



  public static void visScene(BorderPane borderPane, String fxml) {

    Parent root = null;

    try {
      root = FXMLLoader.load(Navigator.class.getResource(fxml));

    } catch (IOException e) {
      e.printStackTrace();
    }

    borderPane.setCenter(root);
  }


  public static void visSceneMedKundeInfo(BorderPane borderPane, String fxml, Kunde kunde) {

    Parent root = null;

    try {
      FXMLLoader loader = new FXMLLoader(Navigator.class.getResource(fxml));
      root = loader.load();
      KontrollerMedKundeInfo kontroller = loader.getController();
      kontroller.setKunde(kunde);

    } catch (IOException e) {
      e.printStackTrace();
    }

    borderPane.setCenter(root);
  }


  public static void visForsikringSceneMedKundeInfo(BorderPane borderPane, String forsikringsType, Kunde kunde) {

    Parent root = null;

    String fxml ="";
    switch (forsikringsType){
      case "Hus og innboforsikring":fxml = Navigator.getOPPRETT_HUS_OG_INNBO_FORSIKRING_SCENE();
      case "Fritidsboligforsikring":fxml =Navigator.getOPPRETT_HUS_OG_INNBO_FORSIKRING_SCENE();
      case "Båtforsikring":fxml =Navigator.getOPPRETT_HUS_OG_INNBO_FORSIKRING_SCENE();
      case "Reiseforsikring":fxml =Navigator.getOPPRETT_HUS_OG_INNBO_FORSIKRING_SCENE();

    }


      FXMLLoader loader = new FXMLLoader(Navigator.class.getResource(fxml));
    try {
      root = loader.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
    KontrollerMedKundeInfo kontroller = loader.getController();
      kontroller.setKunde(kunde);

     borderPane.setCenter(root);
  }

  public static void visSceneMedForsikringInfo(BorderPane borderPane, String fxml,Kunde kunde, Forsikring forsikring)  {

    Parent root = null;

    try {
      FXMLLoader loader = new FXMLLoader(Navigator.class.getResource(fxml));
      root = loader.load();
      KontrollerMedForsikringInfo forsikringKontroller = loader.getController();
      forsikringKontroller.setForsikring(forsikring);
      KontrollerMedKundeInfo kundeKontroller = loader.getController();
      kundeKontroller.setKunde(kunde);

    } catch (IOException e) {
      e.printStackTrace();
    }

    borderPane.setCenter(root);
  }


  public static void visSceneMedSkademeldingInfo(BorderPane borderPane, String fxml,Kunde kunde, Skademelding skademelding) {

    Parent root = null;

    try {
      FXMLLoader loader = new FXMLLoader(Navigator.class.getResource(fxml));
      root = loader.load();
      KontrollerMedSkademeldingInfo kontroller = loader.getController();
      kontroller.setSkademelding(skademelding);
      KontrollerMedKundeInfo kundeKontroller = loader.getController();
      kundeKontroller.setKunde(kunde);

    } catch (IOException e) {
      e.printStackTrace();
    }

    borderPane.setCenter(root);
  }
  public static String getDashbordScene() {
    return DASHBORD_SCENE;
  }

  public static String getForsikringScene() {
    return FORSIKRING_SCENE;
  }

  public static String getKunderScene() {
    return KUNDER_SCENE;
  }

  public static String getRegistrerKundeScene() {
    return REGISTRER_KUNDE_SCENE;
  }

  public static String getREDIGER_KUNDE_SCENE() {
    return REDIGER_KUNDE_SCENE;
  }

  public static String getERSTATNINGER_SCENE() {
    return ERSTATNINGER_SCENE;
  }

  public static String getSKADER_SCENE() {
    return SKADER_SCENE;
  }

  public static String getVIS_KUNDE_SCENE() {
    return VIS_KUNDE_SCENE;
  }

  public static String getOPPRETT_FORSIKRING_SCENE() {
    return OPPRETT_FORSIKRING_SCENE;
  }

  public static String getOPPRETT_HUS_OG_INNBO_FORSIKRING_SCENE() {
    return OPPRETT_HUS_OG_INNBO_FORSIKRING_SCENE;
  }

  public static String getVIS_HUS_OG_INNBO_FORSIKRING_SCENE() {
    return VIS_HUS_OG_INNBO_FORSIKRING_SCENE;
  }

  public static String getRegistrerSkadeMeldingScene() {
    return REGISTRER_SKADE_MELDING_SCENE;
  }

  public static String getVisSkadeMeldingScene() {
    return VIS_SKADE_MELDING_SCENE;
  }
}


