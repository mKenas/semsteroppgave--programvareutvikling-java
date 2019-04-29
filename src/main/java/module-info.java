module forsikringRegisteringSystem {
  requires javafx.controls;
  requires javafx.fxml;
  requires opencsv;

  //requires org.hibernate.validator;
  //requires org.hibernate.validator.annotationprocessor;
  //requires java.validation;


  //requires javax.el;



  requires java.validation;
  requires com.jfoenix;


  opens programutvikling to javafx.fxml;
  exports programutvikling;
}