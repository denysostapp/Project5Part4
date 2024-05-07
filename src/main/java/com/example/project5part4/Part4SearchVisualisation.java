package com.example.project5part4;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Part4SearchVisualisation extends Application {

    private TextField sizeInput;
    private TextField searchInput;
    private TextField delayInput;
    private Label statusLabel;
    private int[] array;

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        sizeInput = new TextField();
        sizeInput.setPromptText("Array Size");
        searchInput = new TextField();
        searchInput.setPromptText("Search Value");
        delayInput = new TextField("500");
        delayInput.setPromptText("Visualization Delay (ms)");
        statusLabel = new Label();

        Button visualizeButton = new Button("Visualize Binary Search");
        visualizeButton.setOnAction(event -> visualizeBinarySearch());

        HBox inputBox = new HBox(10, sizeInput, searchInput, delayInput);
        root.getChildren().addAll(inputBox, visualizeButton, statusLabel);

        Scene scene = new Scene(root, 400, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Binary Search Visualization");
        primaryStage.show();
    }

    private void visualizeBinarySearch() {
        int size = Integer.parseInt(sizeInput.getText());
        int searchValue = Integer.parseInt(searchInput.getText());
        array = generateSortedArray(size);

        final int[] low = {0};
        final int[] high = {array.length - 1};
        final int[] iterCount = {0};
        Timeline timeline = new Timeline();
        int duration = Integer.parseInt(delayInput.getText());
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(duration), event -> {
            int mid = (low[0] + high[0]) / 2;
            iterCount[0]++;
            statusLabel.setText("Iteration count: " + iterCount[0] + ". Range: " + low[0] + " - " + high[0] + ". Mid: " + mid);
            if (low[0] <= high[0]) {
                highlightArrayPositions(low[0], mid, high[0]);
                if (array[mid] < searchValue) {
                    low[0] = mid + 1;
                } else if (array[mid] > searchValue) {
                    high[0] = mid - 1;
                } else {
                    statusLabel.setText("Value found at index: " + mid + " in " + iterCount[0] + " iterations");
                    timeline.stop();
                }
            } else {
                statusLabel.setText("Value not found" + " in " + iterCount[0] + " iterations");
                timeline.stop();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void highlightArrayPositions(int low, int mid, int high) {
    }

    private int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i * 2;
        }
        return array;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
