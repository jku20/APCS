class Manager {
    private Group[] tracks;
    public Manager() {
        this.tracks = new Group[] {};
    }
    public void addGroup(Group grp) {
        Group[] out = new Group[tracks.length + 1];
        for(int i = 0; i < tracks.length; i++)
            out[i] = tracks[i];
        out[out.length - 1] = grp;
        tracks = out;
    }
    public void removeGroup(String name) {
        Group[] out = new Group[tracks.length - 1];
        int count = 0;
        for(int i = 0; i < out.length; i++)
            if(!tracks[i].getName().equals(name))
                out[count++] = tracks[i];
        tracks = out;
    }
    public void printGroups() {
        for(Group i : tracks)
            System.out.println(i.getName() + "\n" + "---" + i.getDesc());
    }
    public Group[] getTracks() {
        return tracks;
    }
    public Group getGroup(int index) {
        return tracks[index];
    }
    public void printTasks() {
        for(Group i : tracks)
            i.printRep();
    }
}
