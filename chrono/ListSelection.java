class ListSelection {
    private String[] list;
    private int currentSelection;
    public ListSelection(String[] list) {
        this.list = list;
        this.currentSelection = -1; //-1 represents no selection
    }
    public void appendSelection(String selection) {
        String[] newList = new String[this.list.length + 1];
        for(int i = 0; i < this.list.length;i++)
            newList[i] = this.list[i];
        newList[this.list.length] = selection;
        this.list = newList;
    }
    public void select(int sel) {
        if(sel < this.list.length) {
            System.out.println("selected");
            this.currentSelection = sel;
        } else
            System.out.println("invalid number to select");
    }
    public void deleteSelection(int selection) {
        String[] newList = new String[this.list.length - 1];
        int count = 0;
        for(int i = 0; i < this.list.length - 1;i++)
            if(i != selection) {
                newList[count] = this.list[i];
                count++;
            };
    }
    public void printList() {
        for(int i = 0; i < this.list.length; i++)
            System.out.print("(" + i + ") " + this.list[i] + " ");
        System.out.println();
    }
    public void printSelection() {
        if(this.currentSelection == -1)
            System.out.println("None Selected");
        else
            System.out.println("(" + currentSelection + ") " + this.list[currentSelection]);
    }
    public String[] getList() {
        return this.list;
    }
    public int getSelection() {
        return this.currentSelection;
    }
    public static void main(String[] args) {
        ListSelection ls = new ListSelection(new String[]{"hello", "no", "yes"});
        ls.printList();
        ls.printSelection();
        ls.appendSelection("ok person");
        ls.printList();
        ls.select(4);
        ls.select(2);
        ls.printSelection();
    }
}
