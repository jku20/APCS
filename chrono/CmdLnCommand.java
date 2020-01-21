import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
class CmdLnCommand { 
   //bassically serves as a hub, all other functions will be called from here.
   //this just bassically takes the commands
    private Manager man;
    private Scanner sc;
    private String[] commands;
    public CmdLnCommand(String[] commands) {
        this.sc = new Scanner(System.in);
        this.commands = commands;
        this.man = new Manager();
    }
    public void setMan(Manager man) {
        this.man = man;
    }
    //this returns the code which the command will be. It is just and integer which will count up for more command names as needed.
    private boolean isLength(int l, int f) {
        if(l < f) {
            System.out.println("missing argument(s)");
            return false;
        } else
            return true;
    }
    public void nextCommand() throws FileNotFoundException, IOException {
        String command = this.sc.nextLine();
        String[] com = command.split(" ");
        //two cases, keyword help which gets description of command
        //and just regualar command runnin
        if(!command.split(" ")[0].equals("help") || command.split(" ").length == 1) {
            switch(com[0]) {
                case "gadd":
                    if(com.length > 1)
                        man.addGroup(new GroupFolder(com[1]));
                    else
                        System.out.println("missing argmument");
                    break;
                case "add":
                    if(com.length > 1) {
                        if(man.getGroup(com[1]) != null)
                            man.getGroup(com[1]).addChild(new Timer(com[2]));
                        else
                            System.out.println("Group does not exist");
                    } else
                        System.out.println("missing argmument");
                    break;
                case "start": 
                    if(com.length > 2)
                        if(man.getGroup(com[1]) != null)
                            man.getGroup(com[1]).startTimer(com[2]);
                        else
                            System.out.println("Group does not exist");
                    else
                        System.out.println("missing argument(s)");
                    break;
                case "stop":
                    if(isLength(com.length, 1)) {
                        if(com.length == 2)
                            man.getGroup(com[1]).stopTimer();
                        else
                            man.getGroup(com[1]).stopTimer(com[2]);
                    }
                    break;
                case "help":
                    Command help = new CmdHelp(commands);
                    help.run();
                    break;
                case "tasks":
                    man.printTasks();
                    break;
                case "groups":
                    man.printGroups();
                    break;
                case "quit":
                    Command quit = new CmdQuit();
                    quit.run();
                    break;
                case "save":
                    Table tab = man.tableRep();
                    tab.writeCSVFile("save.file");
                    break;
                case "load":
                    Table save = Table.readCSV("save.file");
                    setMan(Manager.fromTableRep(save));
                    break;
                case "clear":
                    Command clear = new CmdClear();
                    clear.run();
                    break;
                default:
                    System.out.println("----not a valid command---");
                    break;
            }
        } else {
            switch(command.split(" ")[1]) {
                case "gadd":
                    System.out.println("takes one arguement, creates a group with that name");
                    break;
                case "add":
                    System.out.println("takes one arguement, creates a timer with that name");
                    break;
                case "start":
                    System.out.println("starts a timer, given arguments, the first the group the timer is in and the seccond the timer. Note the timer must exists otherwise nothing will happen.");
                    break;
                case "help":
                    Command help = new CmdHelp(commands);
                    help.info();
                    break;
                case "groups":
                    System.out.println("Print all current groups");
                    break;
                case "tasks":
                    System.out.println("Print all current tasks");
                    break;
                case "quit":
                    Command quit = new CmdQuit();
                    quit.info();
                    break;
                case "save":
                    System.out.println("saves to file in running directory");
                    break;
                case "load":
                    System.out.println("loads saved file");
                    break;
                case "clear":
                    Command clear = new CmdClear();
                    clear.info();
                    break;
                default:
                    System.out.println("----not a valid command----");
                    break;
            }
        }
    }

    public static void main(String[] args) {

    }
}
