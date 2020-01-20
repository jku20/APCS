interface Group {
    void startTimer(); //starts timer for itself and children
    void stopTimer(); //stops timer for itself and children
    int getDuration(); //returns the current sum of durations
    void printRep();
    String getName();
    String getStringRep();
    String getDesc();
    //maybe a way to compare whether groups are equal with and equals method
    //but I think that may be unnessesary
}
