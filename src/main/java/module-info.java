module forsikringRegisteringSystem {
  requires javafx.controls;
  requires javafx.fxml;
  requires opencsv;
  //requires javax.el;
  //requires org.hibernate.validator;
  //requires org.hibernate.validator.annotationprocessor;
  //requires java.validation;






  requires java.validation;
  requires com.jfoenix;


  opens programutvikling to javafx.fxml;
  exports programutvikling;
}