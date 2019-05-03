package programutvikling.validering;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RegexValidator;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import programutvikling.status.InnlesingOgSkrivingStatus;

public class Validator {


    public static void valider(SimpleBooleanProperty validering, JFXTextField tekstfelt, String regex, String melding){


        RegexValidator regexSetter = new RegexValidator();
        regexSetter.setRegexPattern(regex);
        regexSetter.setMessage(melding);
        tekstfelt.getValidators().add(regexSetter);


        tekstfelt.focusedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {


                if (!newValue) {
                    tekstfelt.validate();
                    validering.set(tekstfelt.validate());
                }


            }
        });
    }


    public static void validerVedInnlasstingAvScene(SimpleBooleanProperty validering, JFXTextField tekstfelt, String regex, String melding){


        RegexValidator regexSetter = new RegexValidator();
        regexSetter.setRegexPattern(regex);
        regexSetter.setMessage(melding);
        tekstfelt.getValidators().add(regexSetter);
        tekstfelt.validate();
        validering.set(tekstfelt.validate());



    }


    public static void validerFraTekstfelt(JFXTextField tekstfelt, String regex, String melding){


        RegexValidator regexSetter = new RegexValidator();
        regexSetter.setRegexPattern(regex);
        regexSetter.setMessage(melding);
        tekstfelt.getValidators().add(regexSetter);


        tekstfelt.focusedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

                if (!newValue) {
                    tekstfelt.validate();
                }


            }
        });
    }


    public static void validerFraTekstArea(JFXTextArea tekstfelt, String regex, String melding){


        RegexValidator regexSetter = new RegexValidator();
        regexSetter.setRegexPattern(regex);
        regexSetter.setMessage(melding);
        tekstfelt.getValidators().add(regexSetter);


        tekstfelt.focusedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

                if (!newValue) {
                    tekstfelt.validate();
                }


            }
        });
    }






}
