package programutvikling.filhantering.MappingStrategy.innlesingMappingStrategy;

import com.opencsv.bean.CsvToBeanFilter;
import programutvikling.base.Kunde;

import java.util.List;

public class MappingCSVTilKunde extends InnlesingMappingStrategy<Kunde> {


  List<Kunde> kundeliste;

  public MappingCSVTilKunde(String filstil) {


    CsvToBeanFilter filter = new CsvToBeanFilter() {
      @Override
      public boolean allowLine(String[] strings) {


        String personNr = strings[0];

        boolean erKunde = !"".equals(personNr);
        return erKunde;
      }
    };

    this.kundeliste = this.objektTilCSV( filstil, Kunde.class, filter);

  }

  public List<Kunde> getKundeliste() {
    return kundeliste;
  }

}
