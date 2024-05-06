package com.example.project5part4;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BinarySearchVisualizationApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // UI components
        TextField arraySizeInput = new TextField();
        TextField searchValueInput = new TextField();
        TextField delayInput = new TextField();
        Button startButton = new Button("Start Search");
        Label statusLabel = new Label();

        // Event handling
        startButton.setOnAction(event -> {
            int arraySize = Integer.parseInt(arraySizeInput.getText());
            int searchValue = Integer.parseInt(searchValueInput.getText());
            int delay = Integer.parseInt(delayInput.getText());
            int[] array = generateArray(arraySize);
            binarySearchWithVisualization(array, searchValue, delay, statusLabel);
        });

        // Layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(
                new Label("Array Size:"), arraySizeInput,
                new Label("Search Value:"), searchValueInput,
                new Label("Delay (ms):"), delayInput,
                startButton,
                statusLabel
        );

        // Scene
        Scene scene = new Scene(root, 1200, 800);

        // Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Binary Search Visualization");
        primaryStage.show();
    }

    private int[] generateArray(int size) {
        // Generate array with random values
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1; // Example: 1, 2, 3, ...
        }
        return array;
    }

    private void binarySearchWithVisualization(int[] array, int key, int delay, Label statusLabel) {
        // Implement binary search with visualization here
        // Use Timeline for animation
        // Update statusLabel with search progress
    }

    public static void main(String[] args) {
        launch(args);
    }
}
