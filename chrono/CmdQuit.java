class CmdQuit implements Command {
    public CmdQuit() {
    }
    public void info() {
        System.out.println(
                "----quit----\n" +
                "quits the current session"
                );
    }
    public void run() {
        System.exit(0);
    }
}
