package programutvikling.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class KundeObjektLeser {

  public static Kunde read(String path) throws IOException, ClassNotFoundException {
    try (FileInputStream fin = new FileInputStream(path);
         ObjectInputStream oin = new ObjectInputStream(fin)) {
      return (Kunde) oin.readObject();
    }
  }

}
