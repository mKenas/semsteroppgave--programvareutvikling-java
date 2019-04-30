package programutvikling.validering;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RegexValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Validator {


    public static void valider(JFXTextField tekstfelt,String regex, String melding){


        RegexValidator regexSetter = new RegexValidator();
        regexSetter.setRegexPattern(regex);
        regexSetter.setMessage(melding);
        tekstfelt.getValidators().add(regexSetter);


        tekstfelt.focusedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                {
                    tekstfelt.validate();
                    System.out.println(tekstfelt.validate());
                }
            }
        });
    }
}