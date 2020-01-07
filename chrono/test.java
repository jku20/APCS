import java.util.Scanner;
class Test {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //ListSelection ls = new ListSelection(new String[]{"one", "two", "three"});
        //ls.printList();
        //ls.select(sc.nextInt());
        //ls.printSelection();
        System.out.println("command help lists commands");
        CmdLnCommand cmd = new CmdLnCommand();
        while(true) {
            cmd.nextCommand();
        }
    }
} 
