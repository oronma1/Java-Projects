module com.example.myproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.myproject to javafx.fxml;
    exports com.example.myproject;
}