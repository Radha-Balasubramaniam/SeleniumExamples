package readingfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingExcel {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet0 = workbook.createSheet();
	/*	Row row0 = sheet0.createRow(0);
		Cell cellA = row0.createCell(0);
		Cell cellB = row0.createCell(1);
		
		cellA.setCellValue("first cell");
		cellB.setCellValue("Second Cell");*/
		
		for(int rows=0;rows<10;rows++){
			Row row = sheet0.createRow(rows);
			for(int col=0;col<10;col++){
				Cell cell = row.createCell(col);
				cell.setCellValue((int)Math.random()*100);
			}
		}
		
		File f = new File("/Users/balra06/Documents/workspace/SeleniumAutomation/src/config/myExcelFile.xlsx");
		FileOutputStream fo = new FileOutputStream(f);
		
		workbook.write(fo);
		fo.close();
		
	}

}
