package programutvikling.filhantering.SkrivingTilFil;

import com.opencsv.CSVWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import programutvikling.base.Forsikring;
import programutvikling.base.Kunde;
import programutvikling.base.Skademelding;
import programutvikling.database.DataLagringObjekt;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class CSVFormatSkriver extends FilSkriver {


  @Override
  public void skrivTilFil(HashMap<String, Object> dataliste, String filsti) throws IOException {
    DataLagringObjekt dlo = DataLagringObjekt.getInstance();
     HashMap<Kunde, ArrayList<Forsikring>> kundeMedForsikringListe = new HashMap<>();
     ObservableList<Forsikring> forsikringListe = FXCollections.observableArrayList();
     ObservableList<Kunde> kundeListe = dlo.getKundeListe();

     ObservableList<Skademelding> skademeldingListe = FXCollections.observableArrayList();
     HashMap<Kunde, ArrayList<Skademelding>> kundeMedSkadeMeldingListe = new HashMap<>();
    List<String[]> liste = toStringArray(kundeListe);
    try (
            Writer writer = Files.newBufferedWriter(Paths.get(filsti));

            CSVWriter csvWriter = new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
    ) {
      String[] headerRecord = {"PersonNr", "Navn", "Etternavn", "Address","ForsikringsNr"};
    csvWriter.writeNext(headerRecord);

     /* for (Kunde k : kundeListe){
        csvWriter.writeNext(new String[]{k.getPersonNr(),k.getNavn(),k.getEtternavn(),k.getFakturaAdresse()});

      }*/
     csvWriter.writeAll(liste);


    }


   /* try (
            Writer writer = Files.newBufferedWriter(Paths.get(filsti));
    ) {
      StatefulBeanToCsv<Kunde> beanToCsv = new StatefulBeanToCsvBuilder(writer)
              .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
              .build();


      try {
        for (Kunde k : kundeListe) {

          beanToCsv.write(k);
        }
      } catch (CsvDataTypeMismatchException e) {
        e.printStackTrace();
      } catch (CsvRequiredFieldEmptyException e) {
        e.printStackTrace();
      }
    }*/

  }

  private static List<String[]> toStringArray(ObservableList<Kunde> kundeliste) {
    List<String[]> liste = new ArrayList<String[]>();


    // adding header record
   // liste.add(new String[] { "PersonNr", "Navn", "Etternavn", "Address","ForsikringsNr" });

   for (Kunde k : kundeliste){
     List<String > forsikringer = new ArrayList<>();
     for (Forsikring f: k.getForsikringer()){

       forsikringer.add(f.getForsikringsNr());

     }
     String[] kunde = new String[] {k.getPersonNr(),k.getNavn(),k.getEtternavn(),k.getFakturaAdresse(), String.join("|", forsikringer) };
     liste.add(kunde);
     System.out.println(Arrays.deepToString(kunde));
   }


    return liste;
  }
}
