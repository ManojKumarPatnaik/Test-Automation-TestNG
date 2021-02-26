package readfromexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CusRegExcel { // Do not change the class name

	// Use this declaration to store values parsed from excel
	public static String[] customerData = new String[5];

	public static String[] readExcelData(String fileName) throws IOException { // Do not change the method signature

		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//Testdata//" + fileName);
			XSSFWorkbook book = new XSSFWorkbook(fis);
			XSSFSheet Sheet = book.getSheet("customervalid");

			XSSFRow row = Sheet.getRow(0);

			for (int i = 0; i < row.getLastCellNum(); i++) {
				XSSFCell cell = row.getCell(i);
				if (cell.getCellType().equals(CellType.STRING)) {
					customerData[i] = cell.getStringCellValue();
				} else if (cell.getCellType() == CellType.NUMERIC) {
					// customerData[i] = String.valueOf(cell.getNumericCellValue());
					customerData[i] = NumberToTextConverter.toText(Double.valueOf(cell.getNumericCellValue()));
				}

				return customerData;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerData;
	}

	public static void getExcelPath(String sheetName) {
		// Locate the excel sheet. Return the file path
		File file = new File("CustRegx.xlsx");
		file.getAbsolutePath();
	}
}
