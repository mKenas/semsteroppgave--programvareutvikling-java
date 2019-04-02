package programutvikling.base;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class KundeObjektSkriver {

  public static void write(Kunde k, String path) throws IOException {
    try (
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fos);
    ) {
      out.writeObject(k);
    }
  }

}
