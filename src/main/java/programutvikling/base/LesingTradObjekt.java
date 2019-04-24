package programutvikling.base;

import javafx.concurrent.Task;
import javafx.scene.control.ProgressBar;
import programutvikling.database.DataLagringObjekt;
import programutvikling.kontrollere.feilmeldinger.FileExceptionHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LesingTradObjekt extends Task<HashMap<String,Object>> {


  private Runnable runMeWhenDone;
  private String filstil;
  private HashMap<String,Object> liste;


  public LesingTradObjekt(String filsti, Runnable doneFunc) {
    this.runMeWhenDone = doneFunc;
    this.filstil = filsti;
  }

  @Override
  protected HashMap<String,Object> call() throws Exception {
    System.out.println("running");
    FilLeser filLeser = new JOBJFormatLeser();
    this.liste = filLeser.lesFraFil(this.filstil);



    return liste;
  }

  // succeeded kjører i main-UI tråden, og UI elementer kan manipuleres her
  @Override
  protected void succeeded() {
    System.out.println("Done");
    runMeWhenDone.run();

  }




}



