interface Group {
    public void startTimer(); //starts timer for itself and children
    public void stopTimer(); //stops timer for itself and children
    public int getDuration(); //returns the current sum of durations
}
