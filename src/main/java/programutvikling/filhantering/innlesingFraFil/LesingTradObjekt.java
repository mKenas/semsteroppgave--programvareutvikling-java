package programutvikling.filhantering.innlesingFraFil;

import javafx.concurrent.Task;

import java.util.HashMap;

public class LesingTradObjekt extends Task<HashMap<String,Object>> {


  private Runnable runMeWhenDone;
  private Runnable kjorMegNarKjoringStarter;
  private String filstil;
  private HashMap<String,Object> dataliste;


  public LesingTradObjekt(String filsti, Runnable runFunc,Runnable doneFunc) {
    this.runMeWhenDone = doneFunc;
    this.filstil = filsti;
    this.kjorMegNarKjoringStarter = runFunc;
  }

  @Override
  protected HashMap<String,Object> call() throws Exception {
    System.out.println("starter lesing fra fil");
    FilLeser filLeser = new JOBJFormatLeser();
    this.dataliste = filLeser.lesFraFil(this.filstil);



    return dataliste;
  }

  @Override
  protected void running() {
    System.out.println("running");
    kjorMegNarKjoringStarter.run();
  }

  // succeeded kjører i main-UI tråden, og UI elementer kan manipuleres her
  @Override
  protected void succeeded() {
    System.out.println("Done");
    runMeWhenDone.run();

  }




}



