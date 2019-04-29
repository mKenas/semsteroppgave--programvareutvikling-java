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


        String value = strings[0];

        boolean result = !"".equals(value);
        return result;
        //return true;
      }
    };

    this.kundeliste = this.mapToCSV( filstil, Kunde.class, filter);
    //System.out.println(list);

  }

  public List<Kunde> getKundeliste() {
    return kundeliste;
  }

}
