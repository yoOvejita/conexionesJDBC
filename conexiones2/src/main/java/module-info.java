module com.ejemplo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
	requires javafx.graphics;
	requires java.sql;
    opens com.ejemplo.conexiones2 to javafx.fxml;
    exports com.ejemplo.conexiones2;
}