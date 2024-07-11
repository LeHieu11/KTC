import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Bt
 */
public class Bt {
    static String FILE_A = "StudentsList.txt";
    static String FILE_B;
    static BufferedReader myReader;
    static BufferedWriter myWriter;
    static ArrayList<Character> content = new ArrayList<>();

    static Runnable deleteFileA = () -> {
        File toDelete = new File(FILE_A);
        toDelete.delete();
    };

    public static void main(String[] args) {    
        // input file A name
        Scanner myScanner = new Scanner(System.in);
        System.out.print("File name: ");
        FILE_B = myScanner.next();
        myScanner.close();    

        try {
            //get the file A, B
            myReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(FILE_A), "UTF-8")
            );
            myWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(FILE_B), "UTF-8")
            );
            
            //read file A to content
            int tmp;
            while ((tmp = myReader.read()) != -1) {
                content.add((char) tmp);
            }

            //close reader due to jop done
            myReader.close();

            //init a thread to delete file A
            Thread delThread = new Thread(deleteFileA);
            delThread.start();

            //write to file B
            for (Character c : content) {
                myWriter.write((char) c);
            }
            
            //close instance and thread
            delThread.join();
            myReader.close();
            myWriter.close();
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}