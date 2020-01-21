import java.io.*;
class Main {
    public static void main(String[] args) throws FileNotFoundException,IOException {
        System.out.println("Type help to list commands");
        CmdLnCommand cmd = new CmdLnCommand(new String[] {"help", "tasks", "quit", "add", "gadd", "load", "save", "groups", "rmGroup", "rmTask", "mvTask"});
        while(true) {
            cmd.nextCommand();
        }
    }
}
