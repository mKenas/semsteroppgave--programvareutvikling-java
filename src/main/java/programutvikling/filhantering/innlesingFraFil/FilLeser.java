package programutvikling.filhantering.innlesingFraFil;

import java.io.IOException;
import java.util.HashMap;

public abstract class FilLeser  {

  public  abstract HashMap<String,Object> lesFraFil(String filsti) throws IOException, ClassNotFoundException;

}
