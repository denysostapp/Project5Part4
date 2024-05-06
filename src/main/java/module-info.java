module com.example.project5part4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.project5part4 to javafx.fxml;
    exports com.example.project5part4;
}