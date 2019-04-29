package programutvikling.filhantering.SkrivingTilFil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class JOBJFormatSkriver extends FilSkriver{

  public void skrivTilFil(HashMap<String,Object> dataliste, String filsti) throws IOException{

    try (
            FileOutputStream fos = new FileOutputStream(filsti);
            ObjectOutputStream out = new ObjectOutputStream(fos);
    ) {
      out.writeObject(dataliste);
    }


  }
}
