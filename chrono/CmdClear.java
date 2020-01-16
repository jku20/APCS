class CmdClear implements Command {
    public CmdClear() {
    }
    public void info() {
        System.out.println(
                "----Clear----\n" +
                "Clears current screen (through printing a 300 new lines)"
                );
    }
    public void run() {
        for(int i = 0; i < 300; i++)
            System.out.println();
    }
}
