module forsikringRegisteringSystem {
  requires javafx.controls;
  requires javafx.fxml;
  requires opencsv;
  requires java.validation;
  requires com.jfoenix;


  opens programutvikling to javafx.fxml;
  exports programutvikling;
}