import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Batsman extends Player {
    private int numOfInnings;
    private int runsScored;
    private int numOfTimesDismissed;
    private int ballsFaced;
    private float battingAverage;
    private float battingStrikeRate;
    //Setters
    @Override
    void setName(String name) {
        this.name = name;
    }

    @Override
    void setAge(int age) {
        this.age = age;
    }

    @Override
    void setNumOfMatches(int numOfMatches) {
        this.numOfMatches = numOfMatches;
    }

    void setNumOfInnings(int numOfInnings) {
        this.numOfInnings = numOfInnings;
    }

    void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    void setNumOfTimesDismissed(int numOfTimesDismissed) {
        this.numOfTimesDismissed = numOfTimesDismissed;
    }

    void setBallsFaced(int ballsFaced) {
        this.ballsFaced = ballsFaced;
    }
    //Calculate Average
    @Override
    float calculateAverage() {
        this.setBattingAverage(
                getNumOfTimesDismissed() != 0 ? (float) getRunsScored() / getNumOfTimesDismissed() :
                0);
        return getBattingAverage();
    }
    //Calculate Strike Rate
    @Override
    float calculateStrikeRate() {
        this.setBattingStrikeRate(
                getBallsFaced() != 0 ? (float) getRunsScored() * 100 / getBallsFaced() : 0);
        return getBattingStrikeRate();
    }
    //Getters
    @Override
    String getName() {
        return name;
    }

    @Override
    int getAge() {
        return age;
    }

    @Override
    int getNumOfMatches() {
        return numOfMatches;
    }

    int getNumOfInnings() {
        return numOfInnings;
    }

    int getRunsScored() {
        return runsScored;
    }

    int getNumOfTimesDismissed() {
        return numOfTimesDismissed;
    }

    int getBallsFaced() {
        return ballsFaced;
    }

    float getBattingAverage() {
        return battingAverage;
    }

    float getBattingStrikeRate() {
        return battingStrikeRate;
    }
    //method to save the batsman Stats to CSV file
    public void saveToCSV(String format, float battingAverage, float battingStrikeRate) {
        String filePath = format + "/Batsman.csv";
        try (FileWriter fw = new FileWriter(filePath, true); PrintWriter pw = new PrintWriter(fw)) {
            pw.println(
                    getName() + "," + getAge() + "," + getNumOfMatches() + "," + getNumOfInnings()
                            + "," + getRunsScored() + "," + getNumOfTimesDismissed() + ","
                            + getBallsFaced() + "," + battingAverage + "," + battingStrikeRate);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setBattingAverage(float battingAverage) {
        this.battingAverage = battingAverage;
    }

    private void setBattingStrikeRate(float battingStrikeRate) {
        this.battingStrikeRate = battingStrikeRate;
    }
}
