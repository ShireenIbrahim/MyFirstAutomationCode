package commerce.taf.dataReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReadCSVFile {

	public static Object[][] readFile()
	{
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\commerce\\taf\\data\\UserRegistration.csv");
		String [][] csvData = new String [0][];
		try 
		{
			CSVReader reader = new CSVReader(new FileReader(file));
			List<String[]> rows;
			rows = reader.readAll();
			reader.getMultilineLimit();
			csvData = new String [rows.size()][4];
				for (int i = 0; i < rows.size(); i++) 
				{
					csvData[i] = rows.get(i);
				}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Exception when try to read file CSV : "+e.getMessage());
		}
		catch (CsvException | IOException e) 
		{
			System.out.println("Exception when try to read file CSV : "+e.getMessage());
		}
		return csvData;
	}
}
