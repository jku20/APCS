import java.util.Scanner;
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
    //this returns the code which the command will be. It is just and integer which will count up for more command names as needed.
    public void nextCommand() {
        String command = this.sc.nextLine();
        String[] com = command.split(" ");
        //two cases, keyword help which gets description of command
        //and just regualar command runnin
        if(!command.split(" ")[0].equals("help") || command.split(" ").length == 1) {
            switch(com[0]) {
                case "gadd":
                    man.addGroup(new GroupFolder(com[1]));
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
                    System.out.println("implement save function CSV writer class thing");
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
                    System.out.println("implement save fuction CSV writer class thing");
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
