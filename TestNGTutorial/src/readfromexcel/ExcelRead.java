package readfromexcel;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) {
		XSSFWorkbook ExcelWBook;
		XSSFSheet ExcelWSheet;
		XSSFCell Cell;

		String location = System.getProperty("user.dir") + "//TestData//testdata.xlsx";
		String sheetName = "Sheet1";

		try {
			FileInputStream ExcelFile=new FileInputStream(location);
			ExcelWBook=new XSSFWorkbook(ExcelFile);
			ExcelWSheet=ExcelWBook.getSheet(sheetName);
			
			Cell=ExcelWSheet.getRow(0).getCell(1);
			String cellData=Cell.getStringCellValue();
			System.out.println("Cell Data: "+cellData);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
