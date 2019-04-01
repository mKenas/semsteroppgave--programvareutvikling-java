package programutvikling.base;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PersonObjectWriter {

  public static void write(Person p, String path) throws IOException {
    try (
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fos);
    ) {
      out.writeObject(p);
    }
  }

}
