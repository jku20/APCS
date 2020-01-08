import java.util.Scanner;
class CmdLnCommand { 
   //bassically serves as a hub, all other functions will be called from here.
   //this just bassically takes the commands
    private Scanner sc;
    public CmdLnCommand() {
        this.sc = new Scanner(System.in);
    }
    //this returns the code which the command will be. It is just and integer which will count up for more command names as needed.
    public void nextCommand() {
        String command = this.sc.nextLine();
        //two cases, keyword help which gets description of command
        //and just regualar command runnin
        if(!command.split(" ")[0].equals("help") || command.split(" ").length == 1) {
            switch(command) {
                case "help":
                    Command help = new CmdHelp(new String[] {"tasks", "help", "quit"});
                    help.run();
                    break;
                case "tasks":
                    System.out.println("implement tasks function");
                    break;
                case "quit":
                    Command quit = new CmdQuit();
                    quit.run();
                    break;
                case "save":
                    System.out.println("implement save function CSV writer class thing");
                    break;
            }
        } else {
            switch(command.split(" ")[1]) {
                case "help":
                    Command help = new CmdHelp(new String[] {"tasks", "help", "quit"});
                    help.info();
                    break;
                case "tasks":
                    System.out.println("implement tasks funciton");
                    break;
                case "quit":
                    Command quit = new CmdQuit();
                    quit.info();
                    break;
                case "save":
                    System.out.println("implement save fuction CSV writer class thing");
                    break;
            }
        }
    }

    public static void main(String[] args) {

    }
}
