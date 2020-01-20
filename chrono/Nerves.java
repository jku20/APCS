class Nerves { //bassically connects everything and implements it
    private Manager man;
    public Nerves() {
        // loading function here
        man = new Manager();
    }
    public void addGroup(String name, String desc) {
        man.addGroup(new GroupFolder(name, desc));
    }
    public void removeGroup(String name) {
        man.removeGroup(name);
    }

}
