package com.mycompany.hexadecimalnumber1;

import com.mycompany.hexadecimalnumber1.TaiLieu;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelExample {
    public static final int COLUMN_INDEX_ID = 0;
    public static final int COLUMN_INDEX_MAQRCODEL = 1;
    public static final int COLUMN_INDEX_EPC = 2;
    public static final int COLUMN_INDEX_TID = 3;
    public static final int COLUMN_INDEX_CHUOISAUMAQR = 4;
    public static final int COLUMN_INDEX_EPCCONVERT = 5;
 
    public static void main(String[] args) throws IOException {
        final String excelFilePath = "C:\\Users\\rfid\\OneDrive - CTY CP SX TMDV MA VACH NAM VIET\\Desktop\\tesstappxlsx.xlsx";
        final List<TaiLieu> taiLieus = readExcel(excelFilePath);
        for (TaiLieu taiLieu : taiLieus) {
            System.out.println(taiLieu);
        }
    }
 
    public static List<TaiLieu> readExcel(String excelFilePath) throws IOException {
        List<TaiLieu> listTaiLieus = new ArrayList<>();
 
        // Get file
        InputStream inputStream = new FileInputStream(new File(excelFilePath));
 
        // Get workbook
        Workbook workbook = getWorkbook(inputStream, excelFilePath);
 
        // Get sheet
        Sheet sheet = workbook.getSheetAt(0);
 
        // Get all rows
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            if (nextRow.getRowNum() == 0) {
                // Ignore header
                continue;
            }
 
            // Get all cells
            Iterator<Cell> cellIterator = nextRow.cellIterator();
 
            // Read cells and set value for TaiLieu object
            TaiLieu taiLieu = new TaiLieu();
            while (cellIterator.hasNext()) {
                //Read cell
                Cell cell = cellIterator.next();
                Object cellValue = getCellValue(cell);
                if (cellValue == null || cellValue.toString().isEmpty()) {
                    continue;
                }
                // Set value for TaiLieu object
                int columnIndex = cell.getColumnIndex();
                switch (columnIndex) {
                    case COLUMN_INDEX_ID:
                        if (cellValue instanceof Number) {
                            taiLieu.setId(((Number) cellValue).intValue());
                        } else {
                            taiLieu.setId(Integer.parseInt(cellValue.toString()));
                        }
                        break;
                    case COLUMN_INDEX_MAQRCODEL:
                        taiLieu.setMaqrcodel(cellValue.toString());
                        break;
                    case COLUMN_INDEX_EPC:
                        taiLieu.setEPC(cellValue.toString());
                        break;
                    case COLUMN_INDEX_TID:
                        taiLieu.setTID(cellValue.toString());
                        break;
                    case COLUMN_INDEX_CHUOISAUMAQR:
                        taiLieu.setChuoisaumaqr(cellValue.toString());
                        break;
                    case COLUMN_INDEX_EPCCONVERT:
                        taiLieu.setEPCconvert(cellValue.toString());
                        break;
                    default:
                        break;
                }
            }
            listTaiLieus.add(taiLieu);
        }
 
        workbook.close();
        inputStream.close();
 
        return listTaiLieus;
    }
 
    // Get Workbook
    private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
 
        return workbook;
    }
 
    // Get cell value
    private static Object getCellValue(Cell cell) {
        CellType cellType = cell.getCellType();
        Object cellValue = null;
        switch (cellType) {
            case BOOLEAN:
                cellValue = cell.getBooleanCellValue();
                break;
            case FORMULA:
                Workbook workbook = cell.getSheet().getWorkbook();
                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                cellValue = evaluator.evaluate(cell).getNumberValue();
                break;
            case NUMERIC:
                cellValue = cell.getNumericCellValue();
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case _NONE:
            case BLANK:
            case ERROR:
                break;
            default:
                break;
        }
        return cellValue;
    }
}
