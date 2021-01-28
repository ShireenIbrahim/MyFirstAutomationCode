package commerce.taf.dataReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class ReadJsonFile {
	public String fname, lname, email, password;
	
	public void loadJson()
	{
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\commerce\\taf\\data\\UserRegistration.json";
		File file = new File(path);
		
		JsonParser parser = new JsonParser();
		try 
		{
			JsonArray jarray = (JsonArray) parser.parse(new FileReader(file));
			for (Object jsonElement : jarray) 
			{
				JsonObject obj = (JsonObject) jsonElement;
				fname = obj.get("firstName").getAsString();
				lname = obj.get("lastName").getAsString();
				email = obj.get("email").getAsString();
				password = obj.get("password").getAsString();
				
				System.out.println(fname);
				System.out.println(lname);
				System.out.println(email);
				System.out.println(password);
			
			}
		} 
		catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) 
		{
			System.out.println("Exception while try to read json file : "+e.getMessage());
		}
			
	}

}
