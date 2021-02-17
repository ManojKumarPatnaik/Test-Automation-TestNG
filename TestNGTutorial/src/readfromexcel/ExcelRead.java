package readfromexcel;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) {
		XSSFWorkbook ExcelWBook;
		XSSFSheet ExcelWSheet;
		XSSFCell Cell;
		
		String location = System.getProperty("user.dir") + "//TestData//testdata.xlsx";
		String sheetName = "LoginTest";

		try {
			FileInputStream ExcelFile=new FileInputStream(location);
			ExcelWBook=new XSSFWorkbook(ExcelFile);
			ExcelWSheet=ExcelWBook.getSheet(sheetName);
			XSSFRow Row=ExcelWSheet.getRow(0);
			for(int i=0;i<3;i++) {
				System.out.println(Row.getCell(i).getStringCellValue());
			}
			//Cell=.getCell(1);
			
			
			//String cellData=Cell.getStringCellValue();
			//System.out.println("Cell Data: "+cellData);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
