package programutvikling.filhantering.MappingStrategy.innlesingMappingStrategy;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.CsvToBeanFilter;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InnlesingMappingStrategy<T> {




  protected static  <T> List<T> mapToCSV(String filsti, Class<T> mapToClass,CsvToBeanFilter filter)  {


    Map<String, String> columnMapping = new HashMap<>();
    Arrays.stream(mapToClass.getDeclaredFields()).forEach(field -> {
      columnMapping.put(field.getName(), field.getName());
    });

    ColumnPositionMappingStrategy<T> strategy = new  ColumnPositionMappingStrategy<T>();
    //HeaderColumnNameTranslateMappingStrategy<T> strategy = new HeaderColumnNameTranslateMappingStrategy<T>();

    strategy.setType(mapToClass);
    String[] memberFieldsToBindTo = {"personNr", "navn", "etternavn", "epost", "mobil", "fakturaAdresse", "postNr",
            "poststed", "opprettelsesDato", "forsikringNrListe","skadeMeldingNrListe","forsikringsNr","forsikringsbelop",
            "forsikringspremie","forsikringsbetingelser","forsikringsType","boligAdresse","byggeAr","boligType"
            ,"byggeMateriale","standard","storrelse","bygningsForsikringsbelop","innboForsikringsbelop",
            "forsikringsOmrade","forsikringsSum","eier","registreringsNr","batType","batModell","batLengde","arsModell",
            "motorType", "motorStyrke","skademeldingNr","skadeDato","klokkeSlett","skadeType","skadeBeskrivelse",
            "ovrigSkadeInformasjon","takseringsbelop","utbetaltErstatningsbelop","opprettelsesDato","status"};

    strategy.setColumnMapping(memberFieldsToBindTo);






    //CSVReader reader = new CSVReader(new StringReader(csvContent));
    BufferedReader reader = null;
    //CSVReader reader = null;
    try {
      reader = Files.newBufferedReader(Paths.get(filsti));
      //reader = new CSVReader(new FileReader(filsti));



    } catch (IOException e) {
      e.printStackTrace();
    }



    CsvToBean<T> csvToBean = new CsvToBeanBuilder(reader)
            .withMappingStrategy(strategy)
            .withSkipLines(1)
            .withIgnoreLeadingWhiteSpace(true)
            .withFilter(filter)
            .build();

    return csvToBean.parse();
  }





}
