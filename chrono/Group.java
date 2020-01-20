interface Group {
    public void startTimer(); //starts timer for itself and children
    public void stopTimer(); //stops timer for itself and children
    public int getDuration(); //returns the current sum of durations
    public String getName();
    //maybe a way to compare whether groups are equal with and equals method
    //but I think that may be unnessesary
}
