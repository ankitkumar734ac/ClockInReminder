module com.ca.main {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.ca.main to javafx.fxml;
    exports com.ca.main;
}
