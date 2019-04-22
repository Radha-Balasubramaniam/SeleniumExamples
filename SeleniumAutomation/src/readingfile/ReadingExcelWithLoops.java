package readingfile;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingExcelWithLoops {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fin = new FileInputStream(System.getProperty("user.dir")+"/src/config/ReadExcel.xlsx");
		
		
		Workbook workbook = WorkbookFactory.create(fin);
		Sheet sheet = workbook.getSheetAt(0);
		Row row0 = sheet.getRow(0);
		/*Cell cell = row0.getCell(0);
		String s = cell.getStringCellValue();*/
		int row,col;
		for(row=0; row<sheet.getLastRowNum(); row++){
			for(col=0;col<row0.getLastCellNum();col++){
				Row row1 = sheet.getRow(row);
				Cell cell = row1.getCell(col);
				System.out.print(cell.getStringCellValue()+"\t");
			}
			System.out.println("");
		}
	}

}
