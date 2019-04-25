module forsikringRegisteringSystem {
  requires javafx.controls;
  requires javafx.fxml;
  requires opencsv;

  opens programutvikling to javafx.fxml;
  exports programutvikling;
}