package readfromexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.IOException;

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
//				System.out.println(cell.getCellType());
				if(i%2==0) {
					customerData[i] = cell.getStringCellValue();
				}else {
					customerData[i] = String.valueOf((int)cell.getNumericCellValue());
				}
				//System.out.println(customerData[i]+ i);
//				if(cell.getCellType().equals(CellType.STRING)) {
//				customerData[i] = cell.getStringCellValue();
//				}else if(cell.getCellType()==CellType.NUMERIC) {
//					customerData[i] = String.valueOf(cell.getNumericCellValue());
//				}
//				String type=cell.getCellType().toString();
//				if(type.equals("STRING")) {
//					customerData[i] = cell.getStringCellValue();
//					}else if(type.equals("NUMERIC")) {
//						customerData[i] = String.valueOf(cell.getNumericCellValue());
//					}
			
//				switch(type){
//				case STRING:
//					customerData[i] = cell.getStringCellValue();
//					break;
//					
//				case NUMERIC:
//					customerData[i] = String.valueOf(cell.getNumericCellValue());
//					break;
//				}
				// System.out.println(customerData[i]);
			}
			// Implement code to read data from excel file. Store the values in
			// 'customerData' array. Return the array. * // FileOutputStream fos =new
			// FileOutputStream(fileName); // book.write(fos);
			// fos.flush();
			// fos.close();
			return customerData;

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
