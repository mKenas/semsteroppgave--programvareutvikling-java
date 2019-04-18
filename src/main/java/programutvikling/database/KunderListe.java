package programutvikling.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import programutvikling.base.Forsikring;
import programutvikling.base.Kunde;
import programutvikling.kontrollere.feilmeldinger.KundeEksistererExceptionHandler;


public class KunderListe {

  private static KunderListe kl = null;
  private ObservableList<Kunde> kunderListe = FXCollections.observableArrayList();

  private KunderListe() {
  }

  public static KunderListe getInstance() {
    if (kl == null) {
      kl = new KunderListe();
    }
    return kl;
  }


  public ObservableList<Kunde> getKunder() {
    return kunderListe;
  }

  public void setKunder(ObservableList<Kunde> kunderliste) {

    this.kunderListe = kunderliste;
  }


  public void nullstillKunderListe() {
    this.kunderListe.clear();


  }

  public void leggTilKunder(ObservableList<Kunde> kunderliste) {
    for (int i = 0; i < kunderliste.size(); i++) {
      Kunde k = kunderliste.get(i);
      this.kunderListe.add(k);

    }
  }


  public void leggTilKunde(Kunde kunde) {

    if (!this.kunderListe.contains(kunde)) {
      this.kunderListe.add(kunde);
    } else KundeEksistererExceptionHandler.genererKundeEksistererExceptionMsg();

  }

  public void slettlKunde(Kunde kunde) {
    this.kunderListe.remove(kunde);
  }

  public void slettlForsikring(Forsikring forsikring) {

    this.getKunder().forEach(kunde -> kunde.getForsikringer().remove(forsikring));

  }




}
