package programutvikling.filhantering.SkrivingTilFil;

import com.opencsv.CSVWriter;
import programutvikling.base.*;
import programutvikling.filhantering.MappingStrategy.skrivingMappingStrategy.SkrivingMappingStrategy;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CSVFormatSkriver extends FilSkriver {


  @Override
  public void skrivTilFil(HashMap<String, Object> dataliste, String filsti) throws IOException {


    final char SEPERATOR = ';';
    List<Kunde> kundeListe = (ArrayList<Kunde>) dataliste.get("kundeListe");
    List<HusOgInnboForsikring> husOgInnboForsikringListe = (ArrayList<HusOgInnboForsikring>) dataliste.get("husOgInnboForsikringListe");
    List<FritidsboligForsikring> fritidsboligForsikringListe = (ArrayList<FritidsboligForsikring>) dataliste.get("fritidsboligForsikringListe");
    List<ReiseForsikring> reiseForsikringListe = (ArrayList<ReiseForsikring>) dataliste.get("reiseForsikringListe");
    List<BatForsikring> batorsikringListe = (ArrayList<BatForsikring>) dataliste.get("batorsikringListe");
    List<Skademelding> skademeldingListe = (ArrayList<Skademelding>) dataliste.get("skademeldingListe");

    try {
      try (
              Writer skriver = Files.newBufferedWriter(Paths.get(filsti));

              CSVWriter csvSkriver = new CSVWriter(skriver,
                      SEPERATOR,
                      CSVWriter.NO_QUOTE_CHARACTER,
                      CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                      CSVWriter.DEFAULT_LINE_END);
      ) {
        csvSkriver.writeNext(SkrivingMappingStrategy.HEADER);
        SkrivingMappingStrategy.objektTilCSV(Kunde.class, skriver, kundeListe);

        SkrivingMappingStrategy.objektTilCSV(HusOgInnboForsikring.class, skriver, husOgInnboForsikringListe);
        SkrivingMappingStrategy.objektTilCSV(ReiseForsikring.class, skriver, reiseForsikringListe);
        SkrivingMappingStrategy.objektTilCSV(FritidsboligForsikring.class, skriver, fritidsboligForsikringListe);
        SkrivingMappingStrategy.objektTilCSV(BatForsikring.class, skriver, batorsikringListe);
        SkrivingMappingStrategy.objektTilCSV(Skademelding.class, skriver, skademeldingListe);


      }
    } catch (IOException e) {
      e.printStackTrace();
    }


  }



}
