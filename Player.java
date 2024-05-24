abstract class Player {
    String name;
    int age;
    int numOfMatches;

    abstract void setName(String name);

    abstract void setAge(int age);

    abstract void setNumOfMatches(int numOfMatches);

    abstract String getName();

    abstract int getAge();

    abstract int getNumOfMatches();

    abstract float calculateAverage();

    abstract float calculateStrikeRate();
}
