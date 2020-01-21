class Manager {
    private GroupFolder[] tracks;
    public Manager() {
        this.tracks = new GroupFolder[] {};
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
    public GroupFolder getGroup(String name) {
        GroupFolder out = null;
        for(GroupFolder i : tracks)
            if(i.getName().equals(name))
                out = i;
        return out;
    }
    public void printTasks() {
        for(GroupFolder i : tracks)
            i.printRep();
    }
}
