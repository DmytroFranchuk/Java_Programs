module com.example.hw_2023_10_26_gradle {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.hw_2023_10_26_gradle to javafx.fxml;
    exports com.example.hw_2023_10_26_gradle;
}