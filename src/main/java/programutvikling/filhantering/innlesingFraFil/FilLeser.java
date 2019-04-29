package programutvikling.filhantering.innlesingFraFil;

import programutvikling.feilmeldinger.CSVFormatAvvikHandler;

import java.io.IOException;
import java.util.HashMap;

public abstract class FilLeser  {

  public  abstract HashMap<String,Object> lesFraFil(String filsti) throws CSVFormatAvvikHandler, IOException, ClassNotFoundException;

}
