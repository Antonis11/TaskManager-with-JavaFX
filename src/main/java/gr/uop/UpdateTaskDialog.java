package gr.uop;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Window;

public class UpdateTaskDialog extends Dialog<ButtonType> {
    private TextField tf_title;
    private TextArea ta_description;
    private Task task;

    public UpdateTaskDialog(@SuppressWarnings("exports") Window owner) {
        GridPane taskForm = new GridPane();
        taskForm.setPadding(new Insets(10));

        Label title = new Label("Title:");
        Label description = new Label("Description: ");

        tf_title = new TextField();
        ta_description = new TextArea();
        ta_description.setPrefColumnCount(20);
        ta_description.setPrefRowCount(3);

        taskForm.setVgap(5);

        taskForm.add(title, 0, 0);
        taskForm.add(tf_title, 1, 0);
        taskForm.add(description, 0, 1);
        taskForm.add(ta_description, 1, 1);

        GridPane.setHalignment(title, HPos.CENTER);
        GridPane.setHalignment(description, HPos.CENTER);

        HBox mainPane = new HBox(5);
        mainPane.setPadding(new Insets(10));
        mainPane.getChildren().addAll(taskForm);

        getDialogPane().setContent(mainPane);
        getDialogPane().getButtonTypes().setAll(ButtonType.OK, ButtonType.CANCEL);

        initModality(Modality.WINDOW_MODAL);
        initOwner(owner);
        setTitle("Update Task");
    }

    public void setTask(Task task) {
        this.task = task;
        tf_title.setText(task.getTitle());
        ta_description.setText(task.getDescription());
    }

    public String getNewTitle() {
        return tf_title.getText();
    }

    public String getNewDescription() {
        return ta_description.getText();
    }
}
