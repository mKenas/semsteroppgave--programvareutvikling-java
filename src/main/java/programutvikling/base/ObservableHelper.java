package programutvikling.base;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

class ObservableHelper implements Serializable {

  // ikke inkluderer denne listen i serialiseringen
  transient ArrayList<Observer> listeners = new ArrayList<>();

  void update() {
    for (Observer o : listeners) {
      o.update();
    }
  }

  void add(Observer o) {
    listeners.add(o);
  }

  // denne brukes i deserialisering (lesing fra jobj fil)
  // bare påser at ArrayListen blir initialisert her
  private void readObject(java.io.ObjectInputStream in)
          throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    listeners = new ArrayList<>();
  }

}
