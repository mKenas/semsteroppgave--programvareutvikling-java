package programutvikling.base;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import programutvikling.egenDefinertTyper.Handling;
import programutvikling.kontrollere.KontrollerMedForsikringInfo;
import programutvikling.kontrollere.KontrollerMedKundeInfo;
import programutvikling.kontrollere.KontrollerMedSkademeldingInfo;

import java.io.IOException;

public abstract class Navigator {


  private static final String DASHBORD_SCENE = "/programutvikling/views/dashbordScene.fxml";
  private static final String FORSIKRING_LISTE_SCENE = "/programutvikling/views/forsikringListeScene.fxml";
  private static final String KUNDE_LISTE_SCENE = "/programutvikling/views/kundeListeScene.fxml";
  private static final String REGISTRER_KUNDE_SCENE = "/programutvikling/views/registrerKundeScene.fxml";
  private static final String REDIGER_KUNDE_SCENE = "/programutvikling/views/redigerKundeScene.fxml";
  private static final String ERSTATNING_LISTE_SCENE = "/programutvikling/views/erstatningListeScene.fxml";
  private static final String SKADEMELDING_LISTE_SCENE = "/programutvikling/views/skademeldingListeScene.fxml";
  private static final String AVVIST_SKADEMELDING_LISTE_SCENE = "/programutvikling/views/avvistSkademeldingListeScene.fxml";
  private static final String VIS_KUNDE_SCENE = "/programutvikling/views/visKundeScene.fxml";
  private static final String OPPRETT_FORSIKRING_SCENE = "/programutvikling/views/opprettForsikringScene.fxml";

  private static final String OPPRETT_HUS_OG_INNBO_FORSIKRING_SCENE = "/programutvikling/views/opprettHusOgInnboForsikringScene.fxml";
  private static final String VIS_HUS_OG_INNBO_FORSIKRING_SCENE = "/programutvikling/views/visHusOgInnboForsikringScene.fxml";
  private static final String REDIGER_HUS_OG_INNBO_FORSIKRING_SCENE ="/programutvikling/views/redigerHusOgInnboForsikringScene.fxml";

  private static final String OPPRETT_FRITIDSBOLIG_FORSIKRING_SCENE = "/programutvikling/views/opprettFritidsboligForsikringScene.fxml";
  private static final String VIS_FRITIDSBOLIG_FORSIKRING_SCENE = "/programutvikling/views/visFritidsBoligScene.fxml";
  private static final String REDIGER_FRITIDSBOLIG_FORSIKRING_SCENE = "/programutvikling/views/redigerFritidsboligForsikringScene.fxml";

  private static final String OPPRETT_BAT_FORSIKRING_SCENE = "/programutvikling/views/opprettBaatForsikringScene.fxml";
  private static final String VIS_BAT_FORSIKRING_SCENE = "/programutvikling/views/visBatForsikringScene.fxml";

  private static final String OPPRETT_REISEFORSIKRING_SCENE = "/programutvikling/views/OpprettReiseforsikringScene.fxml";
  private static final String VIS_REISEFORSIKRING_SCENE = "/programutvikling/views/visReiseforsikringScene.fxml";
  private static final String REDIGER_BAT_FORSIKRING_SCENE = "/programutvikling/views/redigerBatForsikringScene.fxml";

  private static final String REGISTRER_SKADE_MELDING_SCENE = "/programutvikling/views/registrerSkademeldingScene.fxml";
  private static final String VIS_SKADE_MELDING_SCENE = "/programutvikling/views/visSkademeldingScene.fxml";
  private static final String REDIGER_SKADE_MELDING_SCENE = "/programutvikling/views/redigerSkademeldingScene.fxml";



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


  public static void visOpprettForsikringSceneMedKundeInfo(BorderPane borderPane, String forsikringsType, Kunde kunde) {

    Parent root = null;

    String fxml = "";
    switch (forsikringsType) {
      case "Hus Og Innbo Forsikring": {
        fxml = Navigator.getOPPRETT_HUS_OG_INNBO_FORSIKRING_SCENE();
        break;
      }
        case "Fritidsbolig Forsikring": {
          fxml = Navigator.getOPPRETT_FRITIDSBOLIG_FORSIKRING_SCENE();
          break;
        }
      case "Båt Forsikring": {
        fxml = Navigator.getOPPRETT_BAT_FORSIKRING_SCENE();
        break;
      }
      case "Reise Forsikring": {
        fxml = Navigator.getOPPRETT_REISEFORSIKRING_SCENE();
        break;
      }
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

  public static void visSceneMedForsikringInfo(BorderPane borderPane, Handling handling,Forsikring forsikring, Kunde kunde) {

    Parent root = null;

    String fxml = "";
    switch (forsikring.getForsikringsType()) {
      case "Hus Og Innbo Forsikring": {
        switch (handling){
          case VIS:{
            fxml = Navigator.getVIS_HUS_OG_INNBO_FORSIKRING_SCENE();
            break;
          }

          case REDIGER: {
            fxml = Navigator.getREDIGER_HUS_OG_INNBO_FORSIKRING_SCENE();
            break;
          }
        }

        break;
      }
      case "Fritidsbolig Forsikring": {
        switch (handling){
          case VIS:{
            fxml = Navigator.getVIS_FRITIDSBOLIG_FORSIKRING_SCENE();
            break;
          }


          case REDIGER: {
            fxml = Navigator.getREDIGER_FRITIDSBOLIG_FORSIKRING_SCENE();
            break;
          }
        }

        break;
      }
      case "Båt Forsikring": {
        switch (handling){
          case VIS:{
            fxml = Navigator.getVisBatForsikringScene();
            break;
          }



          case REDIGER: {
            fxml = Navigator.getREDIGER_BAT_FORSIKRING_SCENE();
            break;
          }
        }

        break;
      }
      case "Reise Forsikring": {
        switch (handling){
          case VIS:{
            fxml = Navigator.getVIS_REISEFORSIKRING_SCENE();
            break;
          }



          case REDIGER: {

            break;
          }
        }

        break;
      }
    }

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


  public static void visSceneMedSkademeldingInfo(BorderPane borderPane, String fxml, Kunde kunde, Skademelding skademelding) {

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

/*  public static void visSceneMedForsikringVillkar(Kunde kunde, Skademelding skademelding) {

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
  }*/

  public static String getDashbordScene() {
    return DASHBORD_SCENE;
  }

  public static String getForsikringListeScene() {
    return FORSIKRING_LISTE_SCENE;
  }

  public static String getKundeListeScene() {
    return KUNDE_LISTE_SCENE;
  }

  public static String getRegistrerKundeScene() {
    return REGISTRER_KUNDE_SCENE;
  }

  public static String getREDIGER_KUNDE_SCENE() {
    return REDIGER_KUNDE_SCENE;
  }

  public static String getERSTATNINGER_SCENE() {
    return ERSTATNING_LISTE_SCENE;
  }

  public static String getSkademeldingerScene() {
    return SKADEMELDING_LISTE_SCENE;
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

  public static String getREDIGER_HUS_OG_INNBO_FORSIKRING_SCENE() {return REDIGER_HUS_OG_INNBO_FORSIKRING_SCENE;}


  public static String getOPPRETT_FRITIDSBOLIG_FORSIKRING_SCENE() {
    return OPPRETT_FRITIDSBOLIG_FORSIKRING_SCENE;
  }

  public static String getVIS_FRITIDSBOLIG_FORSIKRING_SCENE() {return VIS_FRITIDSBOLIG_FORSIKRING_SCENE;}

  public static String getREDIGER_FRITIDSBOLIG_FORSIKRING_SCENE() {return REDIGER_FRITIDSBOLIG_FORSIKRING_SCENE; }



  public static String getOPPRETT_BAT_FORSIKRING_SCENE() {
    return OPPRETT_BAT_FORSIKRING_SCENE;
  }

  public static String getVisBatForsikringScene() {return VIS_BAT_FORSIKRING_SCENE;}



  public static String getOPPRETT_REISEFORSIKRING_SCENE() {return OPPRETT_REISEFORSIKRING_SCENE;}

  public static String getVIS_REISEFORSIKRING_SCENE() {return VIS_REISEFORSIKRING_SCENE;}

  public static String getREDIGER_BAT_FORSIKRING_SCENE() {return REDIGER_BAT_FORSIKRING_SCENE;}




  public static String getRegistrerSkadeMeldingScene() {
    return REGISTRER_SKADE_MELDING_SCENE;
  }

  public static String getVisSkadeMeldingScene() {
    return VIS_SKADE_MELDING_SCENE;
  }

  public static String getRedigerSkadeMeldingScene() {
    return REDIGER_SKADE_MELDING_SCENE;
  }

  public static String getAvvistSkademeldingListeScene() {
    return AVVIST_SKADEMELDING_LISTE_SCENE;
  }
}


