package programutvikling.filhantering.MappingStrategy.innlesingMappingStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GyldigCSVFil {


  public static boolean sjekkCSVFilErGyldig(String filsti) {

    BufferedReader leser = null;

    try {
      leser = Files.newBufferedReader(Paths.get(filsti));

      String linje;
      while ((linje = leser.readLine()) != null) {
        String[] ordliste = linje.split(";");
        if (linje.contains(";") && ordliste.length > 1)
          return true;

      }


    } catch (IOException e) {
      e.printStackTrace();
    }


    return false;
  }


}
