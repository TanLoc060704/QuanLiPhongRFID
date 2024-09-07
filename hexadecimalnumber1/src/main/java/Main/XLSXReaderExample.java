/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author rfid
 */
public class XLSXReaderExample {
    public static void readXLSX(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                Cell cell1 = row.getCell(0); // STT
                Cell cell2 = row.getCell(1); // Mã Qrcode
                Cell cell3 = row.getCell(2); // EPC
                Cell cell4 = row.getCell(3); // TID
                Cell cell5 = row.getCell(4); // Below QRCode
                
                String stt = (cell1 != null) ? cell1.toString() : "";
                String maQRCode = (cell2 != null) ? cell2.toString() : "";
                String epc = (cell3 != null) ? cell3.toString() : "";
                String tid = (cell4 != null) ? cell4.toString() : "";
                String belowQRCode = (cell5 != null) ? cell5.toString() : "";
                
                System.out.printf("STT: %s, Mã Qrcode: %s, EPC: %s, TID: %s, Below QRCode: %s%n",
                        stt, maQRCode, epc, tid, belowQRCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
