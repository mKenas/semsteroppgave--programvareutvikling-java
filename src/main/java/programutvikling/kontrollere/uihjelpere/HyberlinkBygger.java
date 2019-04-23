package programutvikling.kontrollere.uihjelpere;

import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;

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
        Hyperlink hyperlink = new Hyperlink(tittel + " " + teller.incrementAndGet());
        hyperlink.setOnAction((ActionEvent event) -> {
          funksjon.accept(f);
          //forsikring= (HusOgInnboForsikring) f;

          // navigeringTilVisHusOgInnboForsikringScene();
        });

        kontainer.getChildren().add(hyperlink);

      });

    }
  }

  public static <S> HyberlinkBygger<S> genererHyberlink(VBox kontainer, ArrayList<S> forsikringListe, String tittel, Consumer<S> funksjon) {


    return new HyberlinkBygger(kontainer, forsikringListe, tittel, funksjon);
  }


}
