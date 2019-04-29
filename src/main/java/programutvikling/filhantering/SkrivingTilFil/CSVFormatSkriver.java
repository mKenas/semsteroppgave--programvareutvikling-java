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



    List<Kunde> kundeListe = (ArrayList<Kunde>) dataliste.get("kundeListe");
    List<HusOgInnboForsikring> husOgInnboForsikringListe = (ArrayList<HusOgInnboForsikring>) dataliste.get("husOgInnboForsikringListe");
    List<FritidsboligForsikring> fritidsboligForsikringListe = (ArrayList<FritidsboligForsikring>) dataliste.get("fritidsboligForsikringListe");
    List<ReiseForsikring> reiseForsikringListe = (ArrayList<ReiseForsikring>) dataliste.get("reiseForsikringListe");
    List<BatForsikring> batorsikringListe = (ArrayList<BatForsikring>) dataliste.get("batorsikringListe");
    List<Skademelding> skademeldingListe = (ArrayList<Skademelding>) dataliste.get("skademeldingListe");

    try {
      try (
              Writer writer = Files.newBufferedWriter(Paths.get(filsti));

              CSVWriter csvWriter = new CSVWriter(writer,
                      CSVWriter.DEFAULT_SEPARATOR,
                      CSVWriter.NO_QUOTE_CHARACTER,
                      CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                      CSVWriter.DEFAULT_LINE_END);
      ) {
        csvWriter.writeNext(SkrivingMappingStrategy.HEADER);
        SkrivingMappingStrategy.csvToObject(Kunde.class, writer, kundeListe);

        SkrivingMappingStrategy.csvToObject(HusOgInnboForsikring.class, writer, husOgInnboForsikringListe);
        SkrivingMappingStrategy.csvToObject(ReiseForsikring.class, writer, reiseForsikringListe);
        SkrivingMappingStrategy.csvToObject(FritidsboligForsikring.class, writer, fritidsboligForsikringListe);
        SkrivingMappingStrategy.csvToObject(BatForsikring.class, writer, batorsikringListe);
        SkrivingMappingStrategy.csvToObject(Skademelding.class, writer, skademeldingListe);


      }
    } catch (IOException e) {
      e.printStackTrace();
    }


  }



}
