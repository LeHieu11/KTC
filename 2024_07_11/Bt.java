import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Bt
 */
public class Bt {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String FILE_B;

        // input file name
        System.out.print("File name: ");
        FILE_B = myScanner.next();
        System.out.println();

        myScanner.close();

        //init var
        BufferedWriter myWriter;
        BufferedReader myReader;
        String FILE_A = "StudentsList.txt";

        //if file exist?
        try {
            myWriter = new BufferedWriter(new FileWriter(FILE_B));
            myReader = new BufferedReader(new FileReader(FILE_A));
        } catch (Exception e) {
            System.err.println("File not found!");
            return;
        }

        //read the file
        StringBuffer content = new StringBuffer();
        try {
            String line;

            while ((line = myReader.readLine()) != null) {
                content.append(line + "\n");
            }
            
        } catch (Exception e) {
            System.err.println("Cannot read file!");
        }

        //delete the file
        try {
            File toDelete = new File(FILE_A);
            myReader.close();
            toDelete.delete();
        } catch (Exception e) {
            System.err.println("Cannot delete file!");
        }

        //write the content
        try {
            myWriter.write(content.toString());
            
        } catch (Exception e) {
            System.err.println("Cannot write file!");
        }

        //close the file
        try {
            myReader.close();
            myWriter.close();
        } catch (Exception e) {
            System.err.println("Cannot close file!");
            return;
        }
    }
}