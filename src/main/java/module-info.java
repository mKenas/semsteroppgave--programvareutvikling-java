module forsikringRegisteringSystem {
  requires javafx.controls;
  requires javafx.fxml;
  requires opencsv;
  requires java.validation;
  requires javax.el;



  opens programutvikling to javafx.fxml;
  exports programutvikling;
}