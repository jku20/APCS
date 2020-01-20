class GroupFolder implements Group {
    private String desc;
    private Group[] children;
    private String name;
    public GroupFolder(String name, String desc,Group[] children) {
        this.name = name;
        this.desc = desc;
        this.children = children;
    } 
    public GroupFolder(String name, Group[] children) {
        this(name, "Undescribable", children);
    }
    public GroupFolder(Group[] children) {
        this("Unnameable", "Undescribable", children);
    }
    public void addChild(Group child) {
        Group[] out = new Group[children.length + 1];
        for(int i = 0; i < children.length; i++) 
            out[i] = children[i];
        out[children.length] = child;
        children = out;
    }
    public String getName() {
        return name;
    }
    public void removeChild(String name) {
        Group[] out = new Group[children.length - 1];
        int count = 0;
        for(int i = 0; i < out.length; i++) 
            if(!children[i].getName().equals(name))
                out[count++] = children[i];
        children = out;
    }
    public int getDuration() {
        int sum = 0;
        for(Group task : children)
            sum += task.getDuration();
        return sum;
    }
    public void startTimer() {
        for(Group task : children)
            task.startTimer();
    }
    public void stopTimer() {
        for(Group task : children)
            task.stopTimer();
    }
}
