module library {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens library to javafx.fxml;
    exports library;
}
