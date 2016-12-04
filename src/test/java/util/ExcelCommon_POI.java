package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCommon_POI {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	//private static XSSFRow Row;
	
	public static XSSFSheet setExcelFile(String Path, String SheetName) throws Exception {
		try {
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e) {
			throw (e);
		}
		return ExcelWSheet;
	}
	public static String getCellData(int RowNum, int ColNum, XSSFSheet excelWSheet) throws Exception {
		try {

			Cell = excelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}
	public static void writeDataToExcel(int rowcount, int columncount, String filepath, String Sheetname, String value) {
		try {
			FileInputStream input = new FileInputStream(filepath);
			XSSFWorkbook wb = new XSSFWorkbook(input);
			XSSFSheet sh = wb.getSheet(Sheetname);
			XSSFRow row = sh.getRow(rowcount);
			FileOutputStream webdata = new FileOutputStream(filepath);
			row.createCell(columncount).setCellValue(value);
			wb.write(webdata);
		} catch (Exception e) {
			
		}
	    
	}

}
