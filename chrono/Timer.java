class Timer extends GroupFolder {
    private int count;
    private boolean started;
    public Timer(String name, String desc) {
        super(name, desc);
    }
    public Timer(String name) {
        this(name, "Undescribable");
    }
    public void startTimer(String desc) {
        this.addChild(new Task(Integer.toString(count++), desc));
        this.startTimer();
        started = true;
    }
    public void startTimer() {
        this.addChild(new Task(Integer.toString(count++), ""));
        super.startTimer();
        started = true;
    }
    public void StopTimer() {
        this.stopTimer();
        started = false;
    }
    public void printRep() {
        System.out.println("-" + getName() + "\n" + getDesc() + "\n" + Integer.toString(this.getDuration() / 60) + "m");
    }
}
