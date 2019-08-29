package programutvikling.kontrollere.uihjelpere;


import javafx.scene.layout.BorderPane;


public class HovedSceneKontainer {

  private static HovedSceneKontainer hsk = null;
  BorderPane borderPane;

  private HovedSceneKontainer() {
  }

  public static HovedSceneKontainer getInstance() {
    if (hsk == null) {
      hsk = new HovedSceneKontainer();
    }
    return hsk;
  }

  public BorderPane getBorderPane() {
    return borderPane;
  }

  public void setBorderPane(BorderPane borderPane) {
    this.borderPane = borderPane;
  }
}
