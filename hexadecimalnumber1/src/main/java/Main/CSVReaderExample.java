/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author rfid
 */
public class CSVReaderExample {
    public static void readCSV(String filePath) {
        try (FileReader reader = new FileReader(filePath);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
            
            for (CSVRecord record : csvParser) {
                String stt = record.get("STT");
                String maQRCode = record.get("Mã Qrcode");
                String epc = record.get("EPC");
                String tid = record.get("TID");
                String belowQRCode = record.get("Below QRCode");
                
                System.out.printf("STT: %s, Mã Qrcode: %s, EPC: %s, TID: %s, Below QRCode: %s%n",
                        stt, maQRCode, epc, tid, belowQRCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
