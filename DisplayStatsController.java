import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DisplayStatsController {
//Fields for Primary Stats
    @FXML
    private Label nameLabel;
    @FXML
    private Label ageLabel;
    @FXML
    private Label matchesLabel;
    @FXML
    private Label additionalStatsLabel1;
    @FXML
    private Label additionalStatsLabel2;
    @FXML
    private Label additionalStatsLabel3;
    @FXML
    private Label additionalStatsLabel4;
    @FXML
    private Label additionalStatsLabel5;
    @FXML
    private Label additionalStatsLabel6;
    @FXML
    private Label additionalStatsLabel7;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    //Method that sets name, age and matches
    public void setStats(String name, int age, int matches, String[] additionalStats) {
        nameLabel.setText("Name: " + name);
        ageLabel.setText("Age: " + age);
        matchesLabel.setText("Matches: " + matches);
        //Labels that create space for secondary Stats
        Label[] labels = {
                additionalStatsLabel1, additionalStatsLabel2, additionalStatsLabel3,
                additionalStatsLabel4, additionalStatsLabel5, additionalStatsLabel6,
                additionalStatsLabel7
        };
        //For loop that assigns text at the space provided by labels
        for (int i = 0; i < labels.length; i++) {
            if (i < additionalStats.length) {
                labels[i].setText(additionalStats[i]);
            }
            else {
                labels[i].setVisible(false);  // Hide unused labels
            }
        }
    }
    @FXML
    private void handleClose() { //Closing Windows
        stage.close();
    }
}
