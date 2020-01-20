interface Group {
    void startTimer(); //starts timer for itself and children
    void stopTimer(); //stops timer for itself and children
    int getDuration(); //returns the current sum of durations
    String getName();
    String getStringRep();
    //maybe a way to compare whether groups are equal with and equals method
    //but I think that may be unnessesary
}
