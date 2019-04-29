package programutvikling.kontrollere.uihjelpere;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.function.Predicate;

public class SokeFelt <T>{


  FilteredList<T> filtrertListe;
  TextField tekstfelt;
  public SokeFelt(TableView tabell, TextField tekstfelt, ObservableList<T> liste, Predicate<T> betingelse) {
    this.filtrertListe = new FilteredList<>(liste);
    this.tekstfelt = tekstfelt;


    this.tekstfelt.textProperty().addListener((observable, oldValue, newValue) -> {

      System.out.println("søk endret");
      this.filtrertListe = new FilteredList<>(liste);
      filtrertListe.setPredicate(betingelse);

      tabell.setItems(FXCollections.observableList(filtrertListe));



    });
  }


}