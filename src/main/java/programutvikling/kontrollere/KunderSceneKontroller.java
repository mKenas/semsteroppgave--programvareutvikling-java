package programutvikling.kontrollere;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import programutvikling.base.Kunde;
import programutvikling.base.KundeObjektLeser;
import programutvikling.base.KundeObjektSkriver;
import programutvikling.database.DataSourceObject;
import programutvikling.kontrollere.uihelpers.FileExceptionHandler;

import java.io.IOException;

public class KunderSceneKontroller {

  private Kunde kunde, kunde2;
  DataSourceObject dso = DataSourceObject.getInstance();
  private static final String KUNDE_FIL_LOKASJON = "kunde.jobj";



  @FXML
  private TableView tableview;

  public void initialize() {

   /* try {
      kunde = KundeObjektLeser.read("kunde.jobj");

      System.out.println(kunde.getNavn());
    } catch (Exception e) {*/
      //System.out.println(e.getCause());
      // create "default" person
      kunde = new Kunde("Mohamad", "Syria");
      kunde2 = new Kunde("Emre", "Konia");
      // merk: her fanger jeg Exception fordi jeg håndterer alle
      // typer unntak likt. Man bør allikevel påse at det ikke er noen bug her
      //System.out.println("[Read Fail] " + e.getMessage());
    //}

    //kunde = new Kunde("Mohamad", "Oslo");

    dso.leggTilKunde(kunde);
    dso.leggTilKunde(kunde2);
    System.out.println(dso.getKunder());

    TableColumn navnKolonne = new TableColumn("Navn");
    navnKolonne.setCellValueFactory(new PropertyValueFactory<>("Navn"));

    TableColumn fakturaAdresseKollonne = new TableColumn("FakturaAdresse");
    fakturaAdresseKollonne.setCellValueFactory(new PropertyValueFactory<>("FakturaAdresse"));

    tableview.getColumns().addAll(navnKolonne, fakturaAdresseKollonne);
    tableview.getItems().addAll(dso.getKunder());





    kunde.observe(this::kundeEndret);
    kundeEndret();
    //kunde.setNavn("Emre");
  }

  private void kundeEndret() {

    tableview.getItems().set(0,kunde);
    tableview.getItems().set(1,kunde2);


  }


  protected void lagreKunde() {
    try {
      KundeObjektSkriver.write(kunde, KUNDE_FIL_LOKASJON);
      System.out.println("Kunde lagret");
    } catch (IOException e) {
      FileExceptionHandler.generateIOExceptionMsg(e);
    }
  }


  protected void lasteKunde() {
    try {
      KundeObjektLeser.read(KUNDE_FIL_LOKASJON);
      System.out.println("Kunde lastet");
    } catch (IOException e) {
      FileExceptionHandler.generateIOExceptionMsg(e);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

}
