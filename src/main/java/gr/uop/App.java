package gr.uop;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    private TextField tf_title;
    private TextArea ta_description;

    @Override
    public void start(Stage stage) {

        // Panes and arrangement
        GridPane taskForm = new GridPane();
        taskForm.setPadding(new Insets(10));

        HBox buttons = new HBox();
        buttons.setPadding(new Insets(20));
        buttons.setSpacing(10);

        VBox mainPane = new VBox();
        mainPane.setPadding(new Insets(20));
        mainPane.setSpacing(10);

        ObservableList<Task> tasks = FXCollections.observableArrayList();
        ListView<Task> task = new ListView<>(tasks);
        task.setPrefSize(300, 150);

        Label title = new Label("Title:");
        Label description = new Label("Description: ");

        tf_title = new TextField();
        ta_description = new TextArea();
        ta_description.setPrefColumnCount(20);
        ta_description.setPrefRowCount(3);

        Button add = new Button("Add Task");
        Button update = new Button("Update Task");
        Button delete = new Button("Delete Task");
        Button sort = new Button("Sort Tasks");

        buttons.getChildren().addAll(add, update, delete, sort);

        taskForm.setVgap(5);

        taskForm.add(title, 0, 0);
        taskForm.add(tf_title, 1, 0);
        taskForm.add(description, 0, 1);
        taskForm.add(ta_description, 1, 1);
        taskForm.add(buttons, 1, 2);

        GridPane.setHalignment(title, HPos.CENTER);
        GridPane.setHalignment(description, HPos.CENTER);

        mainPane.getChildren().addAll(taskForm, task);

        var scene = new Scene(mainPane, 640, 480);
        stage.setScene(scene);
        stage.setTitle("TaskManager");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}