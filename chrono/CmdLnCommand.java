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
        switch(command) {
            case "help":
                System.out.println(
                        "help" + "\n" + 
                        "tasks" + "\n" +
                        "quit" + "\n"
                        );
                break;
            case "tasks":
                System.out.println("implement tasks function");
                break;
            case "quit":
                System.exit(0);
                break;
            case "save":
                System.out.println("implement save function in CSV writer class thing");
                break;
        }
    }

    public static void main(String[] args) {

    }
}
