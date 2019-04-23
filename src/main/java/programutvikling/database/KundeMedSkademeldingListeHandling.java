package programutvikling.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import programutvikling.base.Kunde;
import programutvikling.base.Skademelding;
import programutvikling.base.klassHjelpere.SkademeldingStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KundeMedSkademeldingListeHandling {

  //private  ObservableMap<Kunde,ArrayList<Forsikring>> kundeMedForsikringListe = FXCollections.observableHashMap();
  private HashMap<Kunde, ArrayList<Skademelding>> kundeMedSkademeldingListe = new HashMap<>();
  private ObservableList<Skademelding> skademeldingListe = FXCollections.observableArrayList();

  public KundeMedSkademeldingListeHandling(HashMap<Kunde, ArrayList<Skademelding>> kundeMedSkademeldingListe, ObservableList<Skademelding> skademeldingListe) {
    this.kundeMedSkademeldingListe = kundeMedSkademeldingListe;
    this.skademeldingListe = skademeldingListe;
  }


  public void leggTilSkademelding(Skademelding skademelding, Kunde kunde) {

    kunde.leggTilSkadeMelding(skademelding);
    this.kundeMedSkademeldingListe.put(kunde, kunde.getSkadeMeldinger());
    this.skademeldingListe.add(skademelding);


  }

  public void slettSkademelding(Skademelding skademelding, Kunde kunde) {
    if (this.kundeMedSkademeldingListe.containsKey(kunde)) {

      kunde.getSkadeMeldinger().remove(skademelding);
      this.kundeMedSkademeldingListe.put(kunde, kunde.getSkadeMeldinger());
      this.skademeldingListe.remove(skademelding);
      System.out.println("Skademelding slettet");
    } else {
      System.out.println("Skademelding ikke finnes");
    }
  }

  public void godkjennSkademelding(Skademelding skademelding) {

    skademelding.setStatus(SkademeldingStatus.GODKJENT);


  }

  public void avvisSkademelding(Skademelding skademelding) {
    skademelding.setStatus(SkademeldingStatus.AVVIST);


  }


  public Kunde finnSkademeldingsKunde(Skademelding skademelding) {

    ArrayList<ArrayList<Skademelding>> listeAvForsikringListe = new ArrayList<>(kundeMedSkademeldingListe.values());
    Kunde kunde;

   /* kundeMedForsikringListe.entrySet().stream()
            .flatMap(m -> m.getValue().stream())
            .forEach(System.out::println);*/


    for (Map.Entry<Kunde, ArrayList<Skademelding>> liste : this.kundeMedSkademeldingListe.entrySet()) {
      if (liste.getValue().contains(skademelding)) {
        kunde = liste.getKey();
        return kunde;

      }
    }

    return null;
  }

}
