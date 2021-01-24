package javabasicprogramms;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader_HashMap {

	public static final String EXCELLOCATION = "./testData/Excel_Reader.xlsx";
	private static FileInputStream fis;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;

	public static void loadExcelData() throws Exception {

		System.out.println("Load Excel Data ");

		File file = new File(EXCELLOCATION);
		fis = new FileInputStream(file);

		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Sheet1");
		fis.close();

	}

	public static Map<String, Map<String, String>> getDataMap() throws Exception {

		if (sheet == null) {

			loadExcelData();
		}

		Map<String, Map<String, String>> superMap = new HashMap<String, Map<String, String>>();

		Map<String, String> myMap = new HashMap<String, String>();

		// to iterate over the row and capture each row as key value
		
		for (int i = 1; i < sheet.getLastRowNum() + 1 ; i++) {
			// to get each row value
			row = sheet.getRow(i);
			// to get the key value of each row
			String kevalue = row.getCell(0).getStringCellValue();

			int colNum = row.getLastCellNum();

			for (int j = 1; j < colNum; j++) {

				String cellvalue = row.getCell(j).getStringCellValue();

				// now put all the key and value of each row and column value inside the HashMap
				myMap.put(kevalue, cellvalue);
			}

			//MASTERDATA key will have all the entire Sheet value 
			superMap.put("MASTERDATA", myMap);
		}

		return superMap;

	}

	
	public static String getValue (String key) throws Exception {
		
		
		//myMap value containing key and value will be stored inside the myVal Map
		Map<String , String> myVal = getDataMap().get("MASTERDATA");
		String returnvalue = myVal.get(key);
		
		return returnvalue ;
		
	}
	
	public static void main (String[] args) throws Exception {
		
		System.out.println ("url value is :" + getValue("baseurl"));
		System.out.println ("Username value is :" + getValue("Username"));
		System.out.println ("Lastname value is :" + getValue("LastName"));
		System.out.println ("Address value is :" +  getValue("Address"));
		
	}
	
}
