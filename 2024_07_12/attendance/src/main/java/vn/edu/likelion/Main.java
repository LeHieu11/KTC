package vn.edu.likelion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Main {
    static String PATH_FILA_TXT = "src/main/resources/StudentsList.txt";
    static String PATH_FILE_EXCEL = "src/main/resources/output.xlsx";
    static String PATH_FILE_WORD = "src/main/resources/Absent_12072024.docx";

    private static String encode(String s) throws UnsupportedEncodingException {
        // return s;
        Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(s.getBytes("UTF-8"));
    }

    private static String decode(String s) throws UnsupportedEncodingException {
        // return s;
        Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(s.getBytes("UTF-8"));
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        //read txt and write docx, xlsx
        try {
            //txt reader
            BufferedReader textReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(PATH_FILA_TXT), "UTF-8")
            );

            //init excel instance
            FileInputStream excelFile = new FileInputStream(new File(PATH_FILE_EXCEL));
            Workbook excelWorkbook = new XSSFWorkbook(excelFile);

            //init word instance
            XWPFDocument document = new XWPFDocument();
            // XWPFParagraph par = document.createParagraph();
            // XWPFRun run = par.createRun();

            //looping
            String line;
            int wordSTT = 1; //keep track word document row for numbering
            int excelCurrentRow = 4; //keep track excel row
            int PENDING_COL = 1; //excel target append col
            while ((line = textReader.readLine()) != null) {
                String name = line.split("\t")[1];
                Boolean isAbsent = Integer.parseInt(line.split("\t")[2]) == 1;

                if (isAbsent) {
                    //write to word document
                    XWPFParagraph par = document.createParagraph();
                    XWPFRun run = par.createRun();
                    run.setText(String.valueOf(wordSTT));
                    run.addTab();
                    run.setText(encode(name));
                    
                    wordSTT++;
                }
                else {
                    //write to excel wordbook
                    Sheet sheet = excelWorkbook.getSheetAt(0);
                    Row row = sheet.getRow(excelCurrentRow);
                    Cell cell = row.getCell(PENDING_COL);

                    cell.setCellValue(encode(name));

                    excelCurrentRow++;
                }
            }

            //write to excel
            FileOutputStream outputStream = new FileOutputStream(PATH_FILE_EXCEL);
            excelWorkbook.write(outputStream);
            excelWorkbook.close();

            //write to word
            outputStream = new FileOutputStream(PATH_FILE_WORD);
            document.write(outputStream);
            document.close();

            textReader.close();
        } 
        catch (IOException e) {
            System.err.println(e.getMessage());
        }

        //read word print to console
        try {
            //init word instance
            FileInputStream wordFile = new FileInputStream(new File(PATH_FILE_WORD));
            XWPFDocument document = new XWPFDocument(wordFile);
            List<XWPFParagraph> paragraphs = document.getParagraphs();

            for (XWPFParagraph p : paragraphs) {
                String line = p.getText();
                String stt = line.split("\t")[0];
                String name = decode(line.split("\t")[1]);

                System.out.println(stt + "\t" + name);
            }

            document.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println("\n");
        //read excel print to console
        try {
            //init word instance
            FileInputStream excelFile = new FileInputStream(new File(PATH_FILE_EXCEL));
            Workbook excelWorkbook = new XSSFWorkbook(excelFile);
            Sheet sheet = excelWorkbook.getSheetAt(0);
            
            for (int i = 4; ; i++) {
                Row row = sheet.getRow(i);

                double stt = row.getCell(0).getNumericCellValue();
                String name = row.getCell(1).getStringCellValue();

                if (name.isEmpty()) {
                    break;
                }

                System.out.println((int)stt + "\t" + decode(name));
            }   

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}