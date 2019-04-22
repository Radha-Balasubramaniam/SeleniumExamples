package readingfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {

	public static void main(String[] args) throws IOException {
		
		
		Logger log = Logger.getLogger("ExcelRead");
		
		FileInputStream fin = new FileInputStream(System.getProperty("user.dir")+"/src/config/ReadExcel.xlsx");
	
		XSSFWorkbook workbook = new XSSFWorkbook(fin);
		XSSFSheet sheet = workbook.getSheet("Sheet0");
		Row row = sheet.getRow(1);
		Cell c = row.getCell(1);
		System.out.println(c.getStringCellValue());
		log.debug("Excel Read completed");
	
	}

}
