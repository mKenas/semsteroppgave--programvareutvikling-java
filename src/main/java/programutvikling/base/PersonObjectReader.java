package programutvikling.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class PersonObjectReader {

  public static Person read(String path) throws IOException, ClassNotFoundException {
    try (FileInputStream fin = new FileInputStream(path);
         ObjectInputStream oin = new ObjectInputStream(fin)) {
      return (Person) oin.readObject();
    }
  }

}
