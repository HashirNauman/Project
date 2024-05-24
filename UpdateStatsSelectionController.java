import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateStatsSelectionController {

    // Radio Button and Toggle Button Fields
    @FXML
    private RadioButton batsmanRadioButton;
    @FXML
    private RadioButton bowlerRadioButton;
    @FXML
    private RadioButton wicketKeeperRadioButton;
    @FXML
    private ToggleGroup playerTypeToggleGroup;

    // Method to handle the next button
    @FXML
    private void handleNextButton() {
        try {
            RadioButton selectedRadioButton
                    = (RadioButton) playerTypeToggleGroup.getSelectedToggle(); // To deteermine which radiobutton is selected
            String playerType = selectedRadioButton.getText();

            // Open the window that update states for Batsman, Bowler and WicketKeeper
            if ("Batsman".equals(playerType)) {
                openUpdateBatsmanStatsWindow();
            }
            else if ("Bowler".equals(playerType)) {
                openUpdateBowlerStatsWindow();
            }
            else if ("WicketKeeper".equals(playerType)) {
                openUpdateWicketKeeperStatsWindow();
            }

            // Closing the window
            Stage stage = (Stage) batsmanRadioButton.getScene().getWindow();
            stage.close();
        }
        catch (Exception e) {
            AlertClass.showAlert("Error", "Please select the radio button");
        }
    }

    // Method that open the window that updates Batsman's Stats
    private void openUpdateBatsmanStatsWindow() {
        openWindow("update_batsman_stats.fxml", "Update Batsman Stats");
    }

    // Method that open the window that updates Wicket Keeper's Stats
    @FXML
    private void openUpdateBowlerStatsWindow() {
        openWindow("update_bowler_stats.fxml", "Update Bowler Stats");
    }

    @FXML
    private void openUpdateWicketKeeperStatsWindow() {
        openWindow("update_wicketkeeper_stats.fxml", "Update Wicketkeeper Stats");
    }

    private void openWindow(String fxmlFile, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
