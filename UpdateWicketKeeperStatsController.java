import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UpdateWicketKeeperStatsController {
    // Fields
    @FXML
    private TextField nameField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField numOfMatchesField;
    @FXML
    private TextField stumpingsField;
    @FXML
    private TextField catchesTakenField;
    @FXML
    private ComboBox<String> formatComboBox;
    @FXML
    private Button submitButton;

    @FXML
    private void initialize() {
        submitButton.setOnAction(e -> handleSubmit());
    }

    // Method that handles submit button
    private void handleSubmit() {
        try {
            WicketKeeper wicketKeeper = new WicketKeeper();
            wicketKeeper.setName(nameField.getText());
            wicketKeeper.setAge(Integer.parseInt(ageField.getText()));
            wicketKeeper.setNumOfMatches(Integer.parseInt(numOfMatchesField.getText()));
            wicketKeeper.setStumpings(Integer.parseInt(stumpingsField.getText()));
            wicketKeeper.setCatchesTaken(Integer.parseInt(catchesTakenField.getText()));
            // Saving stats to CSV files
            String format = formatComboBox.getValue();
            if (format != null && !format.isEmpty()) {
                wicketKeeper.saveToCSV(format);

                displayStats(wicketKeeper.getName(), wicketKeeper.getAge(),
                             wicketKeeper.getNumOfMatches(),
                             new String[] {
                                     "Stumpings: " + wicketKeeper.getStumpings(),
                                     "Catches Taken: " + wicketKeeper.getCatchesTaken()
                             }
                );

                Stage stage = (Stage) submitButton.getScene().getWindow();
                stage.close();
            }
            else {
                AlertClass.showAlert("Error", "Select the format Please");
            }
        }
        catch (NumberFormatException e) {
            AlertClass.showAlert("Error in input", "Please enter the valid stats");
        }
        catch (Exception e) {
            AlertClass.showAlert("Error", "An unexpected error occured");
        }
    }

    // Method that displays WicketKeeper stats in GUI window
    private void displayStats(String name, int age, int matches, String[] additionalStats) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("display_stats.fxml"));
            Parent root = loader.load();

            DisplayStatsController controller = loader.getController();
            Stage stage = new Stage();
            controller.setStage(stage);
            controller.setStats(name, age, matches, additionalStats);

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Player Stats");
            stage.setScene(new Scene(root));
            stage.showAndWait();
        }
        catch (Exception e) {
            AlertClass.showAlert("Error", "An unexpected Error occured");
        }
    }
}
