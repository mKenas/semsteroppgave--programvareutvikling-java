package programutvikling.filhantering.MappingStrategy.innlesingMappingStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GyldigCSVFil {


  public static boolean sjekkCSVFilErGyldig(String filsti){
    //CSVReader reader = new CSVReader(new StringReader(csvContent));
    BufferedReader reader = null;
    //CSVReader reader = null;
    try {
      reader = Files.newBufferedReader(Paths.get(filsti));
      //reader = new CSVReader(new FileReader(filsti));
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.contains(";"))
          return false;

      }


    } catch (IOException e) {
      e.printStackTrace();
    }


    return true;
  }



}
