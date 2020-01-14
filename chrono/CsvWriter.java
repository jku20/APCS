//This may be deleted, or more likely massively reworked
import java.io.*;
class CsvWriter {
    private String[] columns;
    private String[] rows;
    private String[][] data;
    private String name;
    public CsvWriter(String name, String[] columns, String[] rows, String[][] data) {
        this.columns = columns;
        this.rows = rows;
        this.data = data;
        this.name = name;
    }
    public void write() throws FileNotFoundException { 
        PrintWriter pw = new PrintWriter(this.name);
    }
    public static void main(String[] args) {

    }
}
