class Task implements Group{
    private int start;
    private int end;
    private String desc;
    private String name;
    public Task(String name, String desc) { //note the "_" character is not alloud in descriptions
        this.desc = desc;
        this.name = name;
        start = 0;
        end = 0;
    }
    public String getName() {
        return name;
    }
    public Task() {
        this("Unameable", "Undescribable");
    }
    public Task(String name) {
        this(name, "Undescribable");
    }
    public void startTimer() {
        start = (int) (System.currentTimeMillis() / 1000L);
    }
    public void stopTimer() {
        end = (int) (System.currentTimeMillis() / 1000L);
    }
    public int getStart() {
        return start;
    }
    public int getEnd() {
        return end;
    }
    public int getDuration() {
        return getEnd() - getStart() > 0 ? getEnd() - getStart() : 0;
    }
    public void setStart(int time) {
        this.start = time;
    }
    public void setEnd(int time) {
        this.end = time;
    }
    public String getStringRep() {
        return start + "__,__" + end + "__,__" + name + "__,__" + desc;
    }
    public static Task fromStringRep(String str) {
        String[] rep = str.split("__,__");
        Task out = new Task(rep[2], rep[3]);
        out.setStart(Integer.parseInt(rep[0]));
        out.setEnd(Integer.parseInt(rep[1]));
        return out;
    }
}
