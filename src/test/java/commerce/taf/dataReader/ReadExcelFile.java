package commerce.taf.dataReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	static FileInputStream dataFile = null;
	private static XSSFWorkbook woorkbook;
	
	private FileInputStream loadFile()
	{
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\commerce\\taf\\data\\userRegistrationData.xlsx");
		FileInputStream stream = null;
		try 
		{
			stream = new FileInputStream(file);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Exception in loading the file : "+e.getMessage());
		}
		
		return stream;
	}
	
	public Object[][] getExcelData()
	{
		dataFile = loadFile();
		String[][] excelData = null;
		try 
		{
			woorkbook = new XSSFWorkbook(dataFile);
			XSSFSheet sheet = woorkbook.getSheetAt(0);
			
			int rows = sheet.getLastRowNum()+1;
			int cols = 4;
			
			excelData = new String[rows][cols];
			for (int i = 0; i < rows; i++) 
			{
				XSSFRow row = sheet.getRow(i);
				for (int j = 0; j < cols; j++) 
				{
					excelData[i][j] = row.getCell(j).toString();
				}
			}			
		} 
		catch (IOException e) 
		{
			System.out.println("Exception in loading the file : "+e.getMessage());
		}
		return excelData;
	}
}
