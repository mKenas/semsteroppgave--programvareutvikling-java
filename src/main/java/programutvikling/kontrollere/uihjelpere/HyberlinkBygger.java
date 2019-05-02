package programutvikling.kontrollere.uihjelpere;

import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import programutvikling.base.Forsikring;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class HyberlinkBygger<S> {
  private Hyperlink hyperlink;
  private AtomicInteger teller;


  public HyberlinkBygger(VBox kontainer, ArrayList<S> liste, String tittel, Consumer<S> funksjon) {


    if (liste.size() > 0) {
      this.teller = new AtomicInteger();

    }
    if (liste.size() > 0) {

      liste.forEach(f -> {

        Hyperlink hyperlink = new Hyperlink(teller.incrementAndGet() + ". "  + tittel );
        hyperlink.setOnAction((ActionEvent event) -> {
          funksjon.accept(f);

        });

        kontainer.getChildren().add(hyperlink);

      });

    }
  }

  public HyberlinkBygger(VBox kontainer, ArrayList<Forsikring> liste , Consumer<Forsikring> funksjon) {


    if (liste.size() > 0) {
      this.teller = new AtomicInteger();

    }
    if (liste.size() > 0) {

      liste.forEach(f -> {

        Hyperlink hyperlink = new Hyperlink(teller.incrementAndGet() + ". " + f.getForsikringsType());
        hyperlink.setOnAction((ActionEvent event) -> {
          funksjon.accept(f);

        });

        kontainer.getChildren().add(hyperlink);

      });

    }
  }

  public static <S> HyberlinkBygger<S> genererHyberlink(VBox kontainer, ArrayList<S> forsikringListe, String tittel, Consumer<S> funksjon) {


    return new HyberlinkBygger(kontainer, forsikringListe, tittel, funksjon);
  }

  public static <S> HyberlinkBygger<S> genererHyberlink(VBox kontainer, ArrayList<S> forsikringListe, Consumer<S> funksjon) {


    return new HyberlinkBygger(kontainer, forsikringListe, funksjon);
  }


}
