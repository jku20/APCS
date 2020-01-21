import java.util.ArrayList;
class Manager {
    private GroupFolder[] tracks;
    public Manager() {
        this.tracks = new GroupFolder[] {};
    }
    public Table tableRep() {
        String[] columns;
        ArrayList<String> rows = new ArrayList<>();
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        columns = this.StringArrRep();
        for(int i = 0; i < tracks.length; i++) {
            data.add(new ArrayList<String>());
            rows.add(Integer.toString(i));
            for(int j = 0; j < tracks[i].getChildren().length; j++)
                data.get(i).add(tracks[i].getChildren()[j].getStringRep());
        }
        String[][] outData = new String[data.size()][];
        for(int i = 0; i < data.size(); i++)
            outData[i] = data.get(i).toArray(new String[data.get(i).size()]);
        String[] outRows = rows.toArray(new String[rows.size()]);
        Table realOut = new Table(columns, outRows, outData);
        return realOut;
    }
    public static Manager fromTableRep(Table tab) {
        Manager out = new Manager();
        for(int i = 0; i < tab.getColumns().length; i++)
            out.addGroup(GroupFolder.getFromString(tab.getColumns()[i]));
        for(int i = 0; i < tab.getData().length; i++)
            for(int j = 0; j < tab.getData()[i].length; j++) 
                out.getGroup(i).addChild(Timer.getFromString(tab.getData()[i][j]));
        return out;
    }
    public void addGroup(GroupFolder grp) {
        GroupFolder[] out = new GroupFolder[tracks.length + 1];
        for(int i = 0; i < tracks.length; i++)
            out[i] = tracks[i];
        out[out.length - 1] = grp;
        tracks = out;
    }
    public void removeGroup(String name) {
        GroupFolder[] out = new GroupFolder[tracks.length - 1];
        int count = 0;
        for(int i = 0; i < out.length; i++)
            if(!tracks[i].getName().equals(name))
                out[count++] = tracks[i];
        tracks = out;
    }
    public void printGroups() {
        for(GroupFolder i : tracks)
            System.out.println(i.getName() + "\n" + "---" + i.getDesc());
    }
    public GroupFolder[] getTracks() {
        return tracks;
    }
    public String[] StringArrRep() {
        String[] out = new String[tracks.length];
        for(int i = 0; i < out.length; i++)
            out[i] = tracks[i].getStringRep();
        return out;
    }
    public GroupFolder getGroup(String name) {
        GroupFolder out = null;
        for(GroupFolder i : tracks)
            if(i.getName().equals(name))
                out = i;
        return out;
    }
    public GroupFolder getGroup(int index) {
        return tracks[index];
    }
    public void printTasks() {
        for(GroupFolder i : tracks)
            i.printRep();
    }
}
