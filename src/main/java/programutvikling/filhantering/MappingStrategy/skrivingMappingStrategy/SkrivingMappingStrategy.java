package programutvikling.filhantering.MappingStrategy.skrivingMappingStrategy;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.Writer;
import java.util.List;

public class SkrivingMappingStrategy {


  public static String[] HEADER = {"personNr", "navn", "etternavn", "epost", "mobil", "fakturaAdresse", "postNr",
          "poststed", "opprettelsesDato", "forsikringNrListe", "skadeMeldingNrListe", "forsikringsNr", "forsikringsbelop",
          "forsikringspremie", "forsikringsbetingelser", "forsikringsType", "boligAdresse", "byggeAr", "boligType"
          , "byggeMateriale", "standard", "storrelse", "bygningsForsikringsbelop", "innboForsikringsbelop",
          "forsikringsOmrade", "forsikringsSum", "eier", "registreringsNr", "batType", "batModell", "batLengde", "arsModell",
          "motorType", "motorStyrke", "skademeldingNr", "skadeDato", "klokkeSlett", "skadeType", "skadeBeskrivelse",
          "ovrigSkadeInformasjon", "takseringsbelop", "utbetaltErstatningsbelop", "opprettelsesDato", "status"};

  public static <T> void objektTilCSV(Class<T> klasse, Writer skriver, List<T> liste) {


    ColumnPositionMappingStrategy<T> strategy = new ColumnPositionMappingStrategy<T>();


    strategy.setType(klasse);

    strategy.setColumnMapping(SkrivingMappingStrategy.HEADER);


    StatefulBeanToCsv<T> objektTilCSV = new StatefulBeanToCsvBuilder(skriver)
            .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
            .withMappingStrategy(strategy)
            .withSeparator(';')
            .build();

    try {
      objektTilCSV.write(liste);
    } catch (CsvDataTypeMismatchException e) {
      e.printStackTrace();
    } catch (CsvRequiredFieldEmptyException e) {
      e.printStackTrace();
    }


  }
}
