import java.util.ArrayList;
class Task implements Group{
    private int start;
    private int end;
    private String desc;
    public Task(String desc) { //note the "_" character is not alloud in descriptions
        this.desc = desc;
        start = 0;
        end = 0;
    }
    public Task() {
        this("Undescribable");
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
        return getEnd() - getStart();
    }
    public void setStart(int time) {
        this.start = time;
    }
    public void setEnd(int time) {
        this.end = time;
    }
    public String getStringRep() {
        return start + "_" + end + "_" + desc;
    }
    public static Task fromStringRep(String str) {
        String[] rep = str.split("_");
        Task out = new Task(rep[2]);
        out.setStart(Integer.parseInt(rep[0]));
        out.setEnd(Integer.parseInt(rep[1]));
        return out;
    }
}
