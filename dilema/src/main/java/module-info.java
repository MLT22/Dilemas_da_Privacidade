module com.dilemadaprivacidade {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.dilema.telas to javafx.fxml;
    exports com.dilema.telas;
}
