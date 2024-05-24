import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UpdateBowlerStatsController {
    // Fields
    @FXML
    private TextField nameField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField numOfMatchesField;
    @FXML
    private TextField runsConcededField;
    @FXML
    private TextField ballsBowledField;
    @FXML
    private TextField numOfWicketsField;
    @FXML
    private ComboBox<String> formatComboBox;
    @FXML
    private Button submitButton;

    @FXML
    private void initialize() {
        submitButton.setOnAction(e -> handleSubmit());
    }

    // Method to handle the submit Button
    private void handleSubmit() {
        try {
            Bowler bowler = new Bowler();
            bowler.setName(nameField.getText());
            bowler.setAge(Integer.parseInt(ageField.getText()));
            bowler.setNumOfMatches(Integer.parseInt(numOfMatchesField.getText()));
            bowler.setRunsConceded(Integer.parseInt(runsConcededField.getText()));
            bowler.setBallsBowled(Integer.parseInt(ballsBowledField.getText()));
            bowler.setNumOfWickets(Integer.parseInt(numOfWicketsField.getText()));

            float bowlingAverage = bowler.calculateAverage();
            float bowlingStrikeRate = bowler.calculateStrikeRate();
            // Saving Stats to csv files
            String format = formatComboBox.getValue();
            if (format != null && !format.isEmpty()) {
                bowler.saveToCSV(format, bowlingAverage, bowlingStrikeRate);

                displayStats(bowler.getName(), bowler.getAge(), bowler.getNumOfMatches(),
                             new String[] {
                                     "Runs Conceded: " + bowler.getRunsConceded(),
                                     "Balls Bowled: " + bowler.getBallsBowled(),
                                     "wickets: " + bowler.getNumOfWickets(),
                                     "Bowling Average: " + bowlingAverage,
                                     "Strike Rate: " + bowlingStrikeRate

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

    // Method To Display Stats
    private void displayStats(String name, int age, int matches, String[] additionalStats) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("display_stats.fxml")); // load a new GUI window
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
        // Handling exception
        catch (Exception e) {
            AlertClass.showAlert("Error", "An unexpected Error occured");
        }
    }
}
