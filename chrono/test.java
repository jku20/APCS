import java.util.Scanner;
import java.io.*;
class Test {
    public static void main(String[] args) throws FileNotFoundException,IOException {
        //Scanner sc = new Scanner(System.in);
        //ListSelection ls = new ListSelection(new String[]{"one", "two", "three"});
        //ls.printList();
        //ls.select(sc.nextInt());
        //ls.printSelection();
        System.out.println("command help lists commands");
        CmdLnCommand cmd = new CmdLnCommand(new String[] {"help", "tasks", "quit", "save","load","gadd","add","groups"});
        while(true) {
            cmd.nextCommand();
        }
    }
} 
