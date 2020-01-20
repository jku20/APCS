class Task {
    long start;
    long end;
    String desc;
    public Task(String desc) {
        this.desc = desc;
    }
    public Task() {
        this("Undescribable");
    }
    public void startTimer() {
        start = System.currentTimeMillis() / 1000L;
    }
    public void stopTimer() {
        end = System.currentTimeMillis() / 1000L;
    }
    public int getStart() {
        return toIntExact(start);
    }
    public int getEnd() {
        return toIntExact(end);
    }
    public int getDuration() {
        return getEnd() - getStart();
    }
}
