package programutvikling.filhantering.innlesingFraFil;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import programutvikling.base.Forsikring;
import programutvikling.base.HusOgInnboForsikring;
import programutvikling.base.Kunde;
import programutvikling.base.Skademelding;
import programutvikling.filhantering.MappingStrategy.innlesingMappingStrategy.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CSVFormatLeser extends FilLeser {
  @Override
  public HashMap<String, Object> lesFraFil(String filsti) throws IOException, ClassNotFoundException {


    MappingCSVTilKunde mappingCSVTilKundeliste = new MappingCSVTilKunde(filsti);
    //System.out.println("Kundeliste");
    //System.out.println(mappingCSVTilKundeliste.getKundeliste());



    MappingCSVTilReiseForsikring mappingCSVTilReiseForsikring  = new MappingCSVTilReiseForsikring(filsti);
    //System.out.println("ReiseForsikringliste");
    //System.out.println(mappingCSVTilReiseForsikring.getReiseForsikringliste());


    MappingCSVTilHusOgInnboForsikring mappingCSVTilHusOgInnboForsikring  = new MappingCSVTilHusOgInnboForsikring(filsti);
    //System.out.println("HusOgInnboForsikringliste");
    //System.out.println(mappingCSVTilHusOgInnboForsikring.getHusOgInnboForsikringliste());

    MappingCSVTiBatForsikring mappingCSVTiBatForsikring  = new MappingCSVTiBatForsikring(filsti);
    //System.out.println("BatForsikringliste");
    //System.out.println(mappingCSVTiBatForsikring.getBatForsikringliste());

    MappingCSVTiFritidsboligForsikring mappingCSVTiFritidsboligForsikring = new MappingCSVTiFritidsboligForsikring(filsti);
    //System.out.println("FritidsboligForsikringliste");
    //System.out.println(mappingCSVTiFritidsboligForsikring.getFritidsboligForsikringliste());



    MappingCSVTilSkademelding mappingCSVTilSkademelding  = new MappingCSVTilSkademelding(filsti);
    //System.out.println("Skademelding");
    //System.out.println(mappingCSVTilSkademelding.getSkademeldingListe());


    HashMap<String, Object> dataliste = new HashMap<>();
    ArrayList<Kunde> kundeliste = new ArrayList<>();
    ArrayList<Forsikring> forsikringliste = new ArrayList<>();
    ArrayList<Skademelding> skademeldingListe = new ArrayList<>();

    HashMap<Kunde,Forsikring> kundeMedForsikringListe = new HashMap<>();
    HashMap<Kunde,Skademelding> kundeMedSkadeMeldingListe = new HashMap<>();

    kundeliste.addAll(mappingCSVTilKundeliste.getKundeliste());
    forsikringliste.addAll(mappingCSVTilHusOgInnboForsikring.getHusOgInnboForsikringliste());
    forsikringliste.addAll(mappingCSVTilReiseForsikring.getReiseForsikringliste());
    forsikringliste.addAll(mappingCSVTiBatForsikring.getBatForsikringliste());
    forsikringliste.addAll(mappingCSVTiFritidsboligForsikring.getFritidsboligForsikringliste());
    skademeldingListe.addAll(mappingCSVTilSkademelding.getSkademeldingListe());




    for (Forsikring f: forsikringliste) {

      for (Kunde k : kundeliste) {
        if (k.getForsikringNrListe().contains(f.getForsikringsNr())) {

          k.leggTilForsikring(f);
          kundeMedForsikringListe.put(k,f);

        }
      }
    }

    for (Skademelding s: skademeldingListe) {

      for (Kunde k : kundeliste) {
        if (k.getSkadeMeldingNrListe().contains(s.getSkademeldingNr())) {

          k.leggTilSkadeMelding(s);
          kundeMedSkadeMeldingListe.put(k,s);

        }
      }
    }


    dataliste.put("kundeListe", kundeliste);
    dataliste.put("forsikringListe", forsikringliste);
    dataliste.put("skademeldingListe", skademeldingListe);

    dataliste.put("kundeMedForsikringListe", kundeMedForsikringListe);
    dataliste.put("kundeMedSkadeMeldingListe", kundeMedSkadeMeldingListe);


    return dataliste;

  }

}
