module com.dilemadaprivacidade {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires javafx.base;

    opens com.dilema.telas to javafx.fxml;
    exports com.dilema.telas;

}