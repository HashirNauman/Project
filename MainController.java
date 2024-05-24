import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {


    @FXML
    private Button updateStatsButton;

    @FXML
    private void initialize() {


        updateStatsButton.setOnAction(event -> handleUpdateStats());
    }


    private void handleUpdateStats() {
        openUpdateStatsWindow();
    }

    private void openUpdateStatsWindow() {
        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("update_stats_selection.fxml"));
            Parent root = loader.load();


            Stage updateStatsSelectionStage = new Stage();
            updateStatsSelectionStage.initModality(
                    Modality.APPLICATION_MODAL); // To prevent interaction with other windows
            updateStatsSelectionStage.setTitle("Update Player Stats");


            Scene scene = new Scene(root);
            updateStatsSelectionStage.setScene(scene);

            // Show the update stats selection window
            updateStatsSelectionStage.showAndWait();
        }
        catch (Exception e) {
            e.printStackTrace();

        }
    }
}
