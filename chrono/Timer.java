class Timer extends GroupFolder {
    private int count;
    private boolean started;
    private int initDur;
    public Timer(String name, String desc,int initDur) {
        super(name, desc);
        this.initDur = initDur;
    }
    public Timer(String name) {
        this(name, "Undescribable", 0);
    }
    public String getStringRep() {
        return super.getStringRep() + "&&,&&" + getDuration();
    }
    public static Timer getFromString(String rep) {
        String[] lrep = rep.split("&&,&&");
        return new Timer(lrep[0],lrep[1],Integer.parseInt(lrep[2]));
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
    public int getDuration() {
        return super.getDuration() + initDur;
    }
    public void printRep() {
        System.out.println("-" + getName() + "\n" + getDesc() + "\n" + Integer.toString(this.getDuration() / 60) + "m");
    }
}
