package commerce.taf.dataReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

	public static Properties userData = loadProperties(System.getProperty("user.dir")+"\\src\\test\\java\\commerce\\taf\\data\\userRegisterationPropertiesData.properties");

	private static Properties loadProperties(String path)
	{
		Properties prop = new Properties();

		try 
		{
			FileInputStream stream = new FileInputStream(new File(path));
			prop.load(stream);
		} 
		catch (FileNotFoundException e) 
		{

			System.out.println("File not found exception : "+e.getMessage());
		}
		catch (IOException e) 
		{
			System.out.println("not able to load the file : "+e.getMessage());
		}

		return prop;
	}
}
