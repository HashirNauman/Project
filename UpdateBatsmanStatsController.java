import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UpdateBatsmanStatsController {
    // Fields
    @FXML
    private TextField nameField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField numOfMatchesField;
    @FXML
    private TextField numOfInningsField;
    @FXML
    private TextField runsScoredField;
    @FXML
    private TextField numOfTimesDismissedField;
    @FXML
    private TextField ballsFacedField;
    @FXML
    private ComboBox<String> formatComboBox;
    @FXML
    private Button submitButton;

    @FXML
    private void initialize() {
        submitButton.setOnAction(e -> handleSubmit());
    }

    // Method to handle' submit button
    private void handleSubmit() {
        try {
            Batsman batsman = new Batsman();
            batsman.setName(nameField.getText());
            batsman.setAge(Integer.parseInt(ageField.getText()));
            batsman.setNumOfMatches(Integer.parseInt(numOfMatchesField.getText()));
            batsman.setNumOfInnings(Integer.parseInt(numOfInningsField.getText()));
            batsman.setRunsScored(Integer.parseInt(runsScoredField.getText()));
            batsman.setNumOfTimesDismissed(Integer.parseInt(numOfTimesDismissedField.getText()));
            batsman.setBallsFaced(Integer.parseInt(ballsFacedField.getText()));

            float battingAverage = batsman.calculateAverage();
            float battingStrikeRate = batsman.calculateStrikeRate();
            // Saving Stats to csv Files
            String format = formatComboBox.getValue();
            if (format != null && !format.isEmpty()) {
                batsman.saveToCSV(format, battingAverage, battingStrikeRate);

                displayStats(batsman.getName(), batsman.getAge(), batsman.getNumOfMatches(),
                             new String[] {
                                     "Innings: " + batsman.getNumOfInnings(),
                                     "Runs Scored: " + batsman.getRunsScored(),
                                     "Times Dismissed: " + batsman.getNumOfTimesDismissed(),
                                     "Balls Faced: " + batsman.getBallsFaced(),
                                     "Batting Average: " + battingAverage,
                                     "Strike Rate: " + battingStrikeRate
                             });

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

    // Method to Display Stats in another windows
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
        // Handling Exception
        catch (Exception e) {
            AlertClass.showAlert("Error", "An unexpected Error occured");
        }
    }
}
