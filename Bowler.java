import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Bowler extends Player {
    private int runsConceded;
    private int ballsBowled;
    private int numOfWickets;
    private float bowlingAverage;
    private float bowlingStrikeRate;
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

    void setRunsConceded(int runsConceded) {
        this.runsConceded = runsConceded;
    }

    void setBallsBowled(int ballsBowled) {
        this.ballsBowled = ballsBowled;
    }

    void setNumOfWickets(int numOfWickets) {
        this.numOfWickets = numOfWickets;
    }
    //Calculate Average
    @Override
    float calculateAverage() {
        this.setBowlingAverage(
                getNumOfWickets() != 0 ? (float) getRunsConceded() / getNumOfWickets() : 0);
        return getBowlingAverage();
    }
    //Calculate Strike Rate
    @Override
    float calculateStrikeRate() {
        this.setBowlingStrikeRate(
                getNumOfWickets() != 0 ? (float) getBallsBowled() / getNumOfWickets() : 0);
        return getBowlingStrikeRate();
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

    int getRunsConceded() {
        return runsConceded;
    }

    int getBallsBowled() {
        return ballsBowled;
    }

    int getNumOfWickets() {
        return numOfWickets;
    }

    float getBowlingAverage() {
        return bowlingAverage;
    }

    float getBowlingStrikeRate() {
        return bowlingStrikeRate;
    }
    //Save Bowler Stats to csv
    public void saveToCSV(String format, float bowlingAverage, float bowlingStrikeRate) {
        String filePath = format + "/Bowler.csv";
        try (FileWriter fw = new FileWriter(filePath, true); PrintWriter pw = new PrintWriter(fw)) {
            pw.println(
                    getName() + "," + getAge() + "," + getNumOfMatches() + "," + getRunsConceded()
                            + "," + getBallsBowled() + "," + getNumOfWickets() + ","
                            + bowlingAverage + "," + bowlingStrikeRate);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setBowlingAverage(float bowlingAverage) {
        this.bowlingAverage = bowlingAverage;
    }

    private void setBowlingStrikeRate(float bowlingStrikeRate) {
        this.bowlingStrikeRate = bowlingStrikeRate;
    }
}

