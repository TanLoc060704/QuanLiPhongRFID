package com.mycompany.hexadecimalnumber1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelExample {
    public static final int COLUMN_INDEX_ID         = 0;
    public static final int COLUMN_INDEX_MAQR       = 1;
    public static final int COLUMN_INDEX_EPC        = 2;
    public static final int COLUMN_INDEX_TID        = 3;
    public static final int COLUMN_INDEX_SAUMAQR    = 4;
    public static final int COLUMN_INDEX_EPCCONVERT = 5;
    private static CellStyle cellStyleFormatNumber = null;
     
    public static void main(String[] args) throws IOException {
        final List<TaiLieu> tailieus = getTaiLieus();
        final String excelFilePath = "C:/demo/tailieu.xlsx";
        writeExcel(tailieus, excelFilePath);
    }
 
    public static void writeExcel(List<TaiLieu> tailieus, String excelFilePath) throws IOException {
        Workbook workbook = getWorkbook(excelFilePath);
        
        Sheet sheet = workbook.createSheet("TaiLieu"); // Create sheet with sheet name
 
        int rowIndex = 0;
         
        // Write header
        writeHeader(sheet, rowIndex);
 
        // Write data
        rowIndex++;
        for (TaiLieu tailieu : tailieus) {
            Row row = sheet.createRow(rowIndex);
            writeTaiLieu(tailieu, row);
            rowIndex++;
        }
         
        // Auto resize column width
        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);
 
        // Create file excel
        createOutputFile(workbook, excelFilePath);
        System.out.println("Done!!!");
    }
 
    // Create dummy data
    private static List<TaiLieu> getTaiLieus() {
        List<TaiLieu> listTaiLieu = new ArrayList<>();
        TaiLieu tailieu;
        for (int i = 1; i <= 5; i++) {
            tailieu = new TaiLieu(i, "QR" + i, "EPC" + i, "TID" + i, "Chuoisaumaqr" + i, "EPCconvert" + i);
            listTaiLieu.add(tailieu);
        }
        return listTaiLieu;
    }
 
    // Create workbook
    private static Workbook getWorkbook(String excelFilePath) throws IOException {
        Workbook workbook = null;
 
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
 
        return workbook;
    }
 
    // Write header with format
    private static void writeHeader(Sheet sheet, int rowIndex) {
        CellStyle cellStyle = createStyleForHeader(sheet);
         
        Row row = sheet.createRow(rowIndex);
         
        Cell cell = row.createCell(COLUMN_INDEX_ID);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("ID");
 
        cell = row.createCell(COLUMN_INDEX_MAQR);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Mã QR");
 
        cell = row.createCell(COLUMN_INDEX_EPC);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("EPC");
 
        cell = row.createCell(COLUMN_INDEX_TID);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("TID");
 
        cell = row.createCell(COLUMN_INDEX_SAUMAQR);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Chuỗi sau mã QR");

        cell = row.createCell(COLUMN_INDEX_EPCCONVERT);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("EPC Convert");
    }
 
    // Write data
    private static void writeTaiLieu(TaiLieu tailieu, Row row) {
        Cell cell = row.createCell(COLUMN_INDEX_ID);
        cell.setCellValue(tailieu.getId());
 
        cell = row.createCell(COLUMN_INDEX_MAQR);
        cell.setCellValue(tailieu.getMaqrcodel());
 
        cell = row.createCell(COLUMN_INDEX_EPC);
        cell.setCellValue(tailieu.getEPC());
 
        cell = row.createCell(COLUMN_INDEX_TID);
        cell.setCellValue(tailieu.getTID());
 
        cell = row.createCell(COLUMN_INDEX_SAUMAQR);
        cell.setCellValue(tailieu.getChuoisaumaqr());
        
        cell = row.createCell(COLUMN_INDEX_EPCCONVERT);
        cell.setCellValue(tailieu.getEPCconvert());
    }
 
    // Create CellStyle for header
    private static CellStyle createStyleForHeader(Sheet sheet) {
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman"); 
        font.setBold(true);
        font.setFontHeightInPoints((short) 14);
        font.setColor(IndexedColors.WHITE.getIndex());
 
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }
     
    // Auto resize column width
    private static void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }
     
    // Create output file
    private static void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
        try (OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
        }
    }
}
