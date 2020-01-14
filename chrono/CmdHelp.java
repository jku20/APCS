class CmdHelp implements Command {
    private String[] cmdList;
    public CmdHelp(String[] cmdList) {
        this.cmdList = cmdList;
    }
    public void info() {
        System.out.println(
                "----help----\n" +
                "help prints out all current commands"
                );
    }
    public void run(){
        for(String cmd : cmdList)
            System.out.println(cmd);
    }
}
