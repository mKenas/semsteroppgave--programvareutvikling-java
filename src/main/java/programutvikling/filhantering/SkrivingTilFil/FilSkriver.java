package programutvikling.filhantering.SkrivingTilFil;

import java.io.IOException;
import java.util.HashMap;

public abstract class FilSkriver {
  public abstract void skrivTilFil(HashMap<String, Object> liste, String filsti) throws IOException;
}
