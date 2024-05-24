import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WicketKeeper extends Player {
    private int stumpings;
    private int catchesTaken;
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

    void setStumpings(int stumpings) {
        this.stumpings = stumpings;
    }

    void setCatchesTaken(int catchesTaken) {
        this.catchesTaken = catchesTaken;
    }
    //Calculate Average
    @Override
    float calculateAverage() {
        return 0; // As wicketKeeper dont have average .
    }
    //Calculate Strike Rate
    @Override
    float calculateStrikeRate() {
        return 0; // As wicketKeeper dont have Strike rate
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

    int getStumpings() {
        return stumpings;
    }

    int getCatchesTaken() {
        return catchesTaken;
    }
    //Saving the wicketKeeper Stats to CSV files
    public void saveToCSV(String format) {
        String filePath = format + "/WicketKeeper.csv";
        try (FileWriter fw = new FileWriter(filePath, true);
             PrintWriter pw = new PrintWriter(fw)) {
                pw.println(
                    getName() + "," + getAge() + "," + getNumOfMatches() + "," + getStumpings() + "," + getCatchesTaken()
                );
             }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
