package programutvikling.base;

import java.io.Serializable;

public class Person implements Serializable, Observable {
  private static final long serialVersionUID = 1;

  private String name;
  private int age;

  private ObservableHelper observersHandler = new ObservableHelper();

  public Person(String name, int age) {
    if (age < 0 || age > 120) {
      throw new InvalidAgeException();
    }

    this.name = name;
    this.age = age;
  }

  @Override
  public void observe(Observer o) {
    observersHandler.add(o);
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public void setName(String name) {
    this.name = name;
    observersHandler.update();
  }

  public void setAge(int age) {
    if (age < 0 || age > 120) {
      throw new InvalidAgeException();
    }

    this.age = age;
    observersHandler.update();
  }

  @Override
  public String toString() {
    return String.format("Name: %s, age: %s", name, age);
  }

}
