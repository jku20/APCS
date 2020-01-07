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
    private static String setLength(String str, int len) {
        String out = "";
        if(str.length() < len) {
            out = str;
            for(int j = 0; j < len; j++) {
                out = out + " ";
            }
        } else
            out = str.substring(0,len);
        return out;
    }

    public void printTable() {
        for(int i = 0; i < columns.length; i++)
            System.out.print(setLength(columns[i], 8));
        System.out.println();
        for(int i = 0; i < rows.length; i++) {
            System.out.print(setLength(rows[i], 8));
            for(int j = 0; j < data[i].length; j++)
                System.out.print(setLength(data[i][j], 8));
            System.out.println();
        }
    }
    public static void main(String[] args) {

    }
}
