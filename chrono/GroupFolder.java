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
    public GroupFolder(String name, String desc) {
        this(name, desc, new Group[] {});
    }
    public GroupFolder(String name) {
        this(name, "Undescribable");
    }
    public GroupFolder(Group[] children) {
        this("Unnameable", "Undescribable", children);
    }
    public void printRep() {
        for(Group i : children)
            i.printRep();
    }
    public String getDesc() {
        return desc;
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
    public void startTimer(String name) {
        for(Group task : children)
            if(task.getName().equals(name))
                task.startTimer();
    }
    public void stopTimer(String name) {
        for(Group task : children)
            if(task.getName().equals(name))
                task.stopTimer();
    }
    public void stopTimer() {
        for(Group task : children)
            task.stopTimer();
    }
    public String getStringRep() { //should not need to keep track of children here that should be done by a table
        return name + "&&,&&" + desc;
    }
    public static GroupFolder fromStringRep(String str) {
        String[] rep = str.split("&&,&&");
        return new GroupFolder(rep[0], rep[1]);
    }
}
