package programutvikling.filhantering.SkrivingTilFil;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import programutvikling.base.Forsikring;
import programutvikling.base.Kunde;
import programutvikling.base.Skademelding;
import programutvikling.database.DataLagringObjekt;


public class CSVFormatSkriver extends FilSkriver {
  @Override
  public void skrivTilFil(HashMap<String, Object> dataliste, String filsti) throws IOException {
    DataLagringObjekt dlo = DataLagringObjekt.getInstance();
     HashMap<Kunde, ArrayList<Forsikring>> kundeMedForsikringListe = new HashMap<>();
     ObservableList<Forsikring> forsikringListe = FXCollections.observableArrayList();
     ObservableList<Kunde> kundeListe = dlo.getKundeListe();

     ObservableList<Skademelding> skademeldingListe = FXCollections.observableArrayList();
     HashMap<Kunde, ArrayList<Skademelding>> kundeMedSkadeMeldingListe = new HashMap<>();
 /*
    try (
            Writer writer = Files.newBufferedWriter(Paths.get(filsti));

            CSVWriter csvWriter = new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
    ) {
      String[] headerRecord = {"PersonNr", "Navn", "Etternavn", "Address"};
    csvWriter.writeNext(headerRecord);

      for (Kunde k : kundeListe){
        csvWriter.writeNext(new String[]{k.getPersonNr(),k.getNavn(),k.getEtternavn(),k.getFakturaAdresse()});

      }


    }*/
    try (
            Writer writer = Files.newBufferedWriter(Paths.get(filsti));
    ) {
      StatefulBeanToCsv<Forsikring> beanToCsv = new StatefulBeanToCsvBuilder(writer)
              .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
              .build();


      try {
        beanToCsv.write(kundeListe.get(0).getForsikringer());
      } catch (CsvDataTypeMismatchException e) {
        e.printStackTrace();
      } catch (CsvRequiredFieldEmptyException e) {
        e.printStackTrace();
      }
    }

  }
}
