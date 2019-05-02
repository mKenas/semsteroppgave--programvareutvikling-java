package programutvikling.kontrollere.uihjelpere;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import programutvikling.base.Forsikring;
import programutvikling.base.Kunde;
import programutvikling.base.Skademelding;

import java.util.function.Predicate;

public class SokeFelt {


  FilteredList filtrertListe;
  TextField tekstfelt;

  public SokeFelt() {

  }

  ;

  public SokeFelt(TableView tabell, TextField tekstfelt, ObservableList liste, Predicate betingelse) {
    this.filtrertListe = new FilteredList(liste);
    this.tekstfelt = tekstfelt;


    this.tekstfelt.textProperty().addListener((observable, oldValue, newValue) -> {

      System.out.println("søk endret");
      this.filtrertListe = new FilteredList<>(liste);
      filtrertListe.setPredicate(betingelse);

      tabell.setItems(FXCollections.observableList(filtrertListe));


    });
  }


  public static Predicate getKundeFilteringLogikk(TextField tekstfelt) {
    return (Predicate<Kunde>) kunde -> {
      String sokeTekst = tekstfelt.getText().toLowerCase().toLowerCase();
      if (kunde.getPersonNr().toLowerCase().contains(sokeTekst)
              || kunde.getNavn().toLowerCase().contains(sokeTekst)
              || kunde.getEtternavn().toLowerCase().contains(sokeTekst)
              || kunde.getFakturaAdresse().toLowerCase().contains(sokeTekst)

              ) {
        return true;
      }
      return false;
    };
  }


  public static Predicate getForsikringFilteringLogikk(TextField tekstfelt) {
    return (Predicate<Forsikring>) forsikring -> {
      String sokeTekst = tekstfelt.getText().toLowerCase();
      if (forsikring.getForsikringsNr().toLowerCase().contains(sokeTekst)
              || forsikring.getForsikringsType().toLowerCase().contains(sokeTekst)
              || String.valueOf(forsikring.getForsikringsbelop()).toLowerCase().contains(sokeTekst)
              || String.valueOf(forsikring.getForsikringspremie()).toLowerCase().contains(sokeTekst)

              ) {

        return true;
      }
      return false;
    };
  }



  public static Predicate getSkademeldingFilteringLogikk(TextField tekstfelt) {
    return (Predicate<Skademelding>) skademelding -> {
      String sokeTekst = tekstfelt.getText().toLowerCase();
      if (skademelding.getSkademeldingNr().toLowerCase().contains(sokeTekst)
              || skademelding.getSkadeType().toLowerCase().contains(sokeTekst)
              || String.valueOf(skademelding.getTakseringsbelop()).toLowerCase().contains(sokeTekst)
              ) {

        return true;
      }
      return false;
    };
  }


  public static Predicate getErstatningFilteringLogikk(TextField tekstfelt) {
    return (Predicate<Skademelding>) skademelding -> {
      String sokeTekst = tekstfelt.getText().toLowerCase();
      if (skademelding.getSkademeldingNr().toLowerCase().contains(sokeTekst)
              || skademelding.getSkadeType().toLowerCase().contains(sokeTekst)
              || String.valueOf(skademelding.getTakseringsbelop()).toLowerCase().contains(sokeTekst)
              || String.valueOf(skademelding.getUtbetaltErstatningsbelop()).toLowerCase().contains(sokeTekst)
              ) {

        return true;
      }
      return false;
    };
  }

}