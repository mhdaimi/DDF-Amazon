package in.amazon.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import in.amazon.objectRepo.TestObjects;

public class Excel {
	
	public static ArrayList<String> getRowData(String sheetName, int rowNumber) throws Exception{
		
		ArrayList<String> rowData = new ArrayList<String>();
		File file = new File(TestObjects.testDataFile);
		FileInputStream io = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(io);
		HSSFSheet sheet = workbook.getSheet(sheetName);
		HSSFRow row = sheet.getRow(rowNumber);
		
		int lastCell = row.getLastCellNum();
		for(int i=0; i<lastCell; i++) {
			HSSFCell cell = row.getCell(i);
			rowData.add(cell.getStringCellValue());
		}
		return rowData;
	}
}
