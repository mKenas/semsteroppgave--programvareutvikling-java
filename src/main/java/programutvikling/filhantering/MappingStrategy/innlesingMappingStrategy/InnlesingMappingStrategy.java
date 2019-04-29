package programutvikling.filhantering.MappingStrategy.innlesingMappingStrategy;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.CsvToBeanFilter;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class InnlesingMappingStrategy<T> {



  protected static  <T> List<T> objektTilCSV(String filsti, Class<T> klasse, CsvToBeanFilter filter)  {


    ColumnPositionMappingStrategy<T> strategy = new  ColumnPositionMappingStrategy<T>();

    strategy.setType(klasse);
    String[] datafelt = {"personNr", "navn", "etternavn", "epost", "mobil", "fakturaAdresse", "postNr",
            "poststed", "opprettelsesDato", "forsikringNrListe","skadeMeldingNrListe","forsikringsNr","forsikringsbelop",
            "forsikringspremie","forsikringsbetingelser","forsikringsType","boligAdresse","byggeAr","boligType"
            ,"byggeMateriale","standard","storrelse","bygningsForsikringsbelop","innboForsikringsbelop",
            "forsikringsOmrade","forsikringsSum","eier","registreringsNr","batType","batModell","batLengde","arsModell",
            "motorType", "motorStyrke","skademeldingNr","skadeDato","klokkeSlett","skadeType","skadeBeskrivelse",
            "ovrigSkadeInformasjon","takseringsbelop","utbetaltErstatningsbelop","opprettelsesDato","status"};

    strategy.setColumnMapping(datafelt);



    //CSVReader reader = new CSVReader(new StringReader(csvContent));
    BufferedReader leser = null;
    //CSVReader reader = null;
    try {
      leser = Files.newBufferedReader(Paths.get(filsti));
      //reader = new CSVReader(new FileReader(filsti));



    } catch (IOException e) {
      e.printStackTrace();
    }



    CsvToBean<T> CSVTilObjekt = new CsvToBeanBuilder(leser)
            .withMappingStrategy(strategy)
            .withSeparator(';')
            .withSkipLines(1)
            .withIgnoreLeadingWhiteSpace(true)
            .withFilter(filter)
            .build();

    return CSVTilObjekt.parse();
  }





}
