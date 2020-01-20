//import java.io.PrintWriter;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.File;
import java.io.*;
import java.util.Arrays;
class Table {
    private String[] columns; //column names
    private String[] rows; //row names
    private String[][] data; //data in 2d array
    public Table(String[] columns, String[] rows, String[][] data) { 
        //note, make sure length of columns and rows match up with size of data
        this.columns = columns;
        this.rows = rows;
        this.data = data;
    }
    private static String setLength(String str, int len) { //helper for size
        String out = "";
        if(str.length() < len) {
            out = str;
            while(out.length() < len) {
                out = out + " ";
            }
        } else
            out = str.substring(0,len);
        return out;
    }
    public String[] getColumns() {
        return columns;
    }
    public String[] getRows() {
        return rows;
    }
    public String[][] getData() {
        return data;
    }
    public String[] getColumn(int column) {
        String[] out = new String[rows.length + 1];
        columns[column] = out[0];
        for(int i = 0; i < data.length)
            out[i + 1] = data[i][column];
        return out;
    }
    public void printTable(int size) { //prints table to console
        for(int i = 0; i < size; i++) 
            System.out.print(" ");
        for(int i = 0; i < columns.length; i++)
            System.out.print(setLength(columns[i], size));
        System.out.println();
        for(int i = 0; i < rows.length; i++) {
            System.out.print(setLength(rows[i], size));
            for(int j = 0; j < data[i].length; j++)
                System.out.print(setLength(data[i][j], size));
            System.out.println();
        }
    }
    public String[][] csvRepresentation() {
        String[][] out = new String[data.length + 1][data[0].length + 1];
        out[0] = columns;
        for(int i = 1; i - 1 < rows.length; i++) {
            out[i][0] = rows[i - 1];
            for(int j = 1; j - 1 < columns.length; j++) {
                out[i][j] = data[i - 1][j - 1];
            }
        }
        return out;
    }
    public static Table readCSV(String fileIn) throws FileNotFoundException, IOException { //note requires the amount of rows as first line in file
        BufferedReader br = new BufferedReader(new FileReader(fileIn));
        int numRows = Integer.parseInt(br.readLine());
        String[] columns = br.readLine().split(",");
        String[] rows = new String[numRows];
        String[][] data = new String[numRows][columns.length];
        for(int i = 0; i < numRows; i++) {
            String[] tmp = br.readLine().split(",");
            rows[i] = tmp[0];
            for(int j = 1; j < tmp.length; j++) {
                data[i][j - 1] = tmp[j];
            }
        }
        br.close();
        return new Table(columns, rows, data);
    }
    public void writeCSVFile(String fileName) throws FileNotFoundException {
        File outFile = new File(fileName);
        PrintWriter pw = new PrintWriter(fileName);
        pw.println(rows.length);
        String[][] out = this.csvRepresentation();
        for(String[] i : out) {
            for(String j : i)
                pw.print(j + ",");
            pw.println();
        }
        pw.close();
    }
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Table t = new Table(
                new String[] {"num 1", "num 2", "nums 3"},
                new String[] {"a", "b", "c", "d"},
                new String[][] {
                    {"1", "2", "3"},
                    {"4", "5", "6"},
                    {"7", "8", "9"},
                    {"10","11","12"}
                });
        t.printTable(6);
        String[][] rep = t.csvRepresentation();
        for(String[] i : rep) {
            for(String j : i)
                System.out.print(j + " ");
            System.out.println();
        }
        t.writeCSVFile("toTwelve.csv");
        Table f = readCSV("toTwelve.csv");
        f.printTable(6);
    }
}
