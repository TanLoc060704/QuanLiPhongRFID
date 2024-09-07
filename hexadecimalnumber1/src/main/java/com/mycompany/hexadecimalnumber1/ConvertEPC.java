/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hexadecimalnumber1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author rfid
 */
public class ConvertEPC {
    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\rfid\\OneDrive - CTY CP SX TMDV MA VACH NAM VIET\\Desktop\\RF202401255027055 - 48000pcs.xlsx";
        String outputFilePath = "C:\\Users\\rfid\\OneDrive - CTY CP SX TMDV MA VACH NAM VIET\\Desktop\\output.xlsx";

        try {
            // Đọc file Excel
            FileInputStream inputStream = new FileInputStream(inputFilePath);
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0); // Lấy sheet đầu tiên

            // Thêm cột EPC Converted vào cuối cùng
            int lastColumnIndex = sheet.getRow(0).getLastCellNum();
            Row headerRow = sheet.getRow(0);
            Cell newHeaderCell = headerRow.createCell(lastColumnIndex);
            newHeaderCell.setCellValue("EPC Converted");

            // Duyệt qua từng dòng và chuyển đổi giá trị trong cột EPC
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next(); // Bỏ qua dòng tiêu đề
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Cell epcCell = row.getCell(2); // Giả sử cột EPC là cột thứ 3 (index = 2)
                String epcValue = epcCell.getStringCellValue();

                // Chuyển đổi EPC sang Hexadecimal
                String epcConverted = convertToHexadecimal(epcValue);

                // Thêm giá trị đã chuyển đổi vào cột EPC Converted
                Cell newCell = row.createCell(lastColumnIndex);
                newCell.setCellValue(epcConverted);
            }

            // Ghi file Excel đầu ra
            FileOutputStream outputStream = new FileOutputStream(outputFilePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            inputStream.close();

            System.out.println("Chuyển đổi thành công! File đã được lưu tại: " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hàm chuyển đổi EPC sang Hexadecimal
    private static String convertToHexadecimal(String epcValue) {
        StringBuilder sb = new StringBuilder();
        for (char ch : epcValue.toCharArray()) {
            sb.append(String.format("%02X", (int) ch));
        }
        return sb.toString();
    }
}
