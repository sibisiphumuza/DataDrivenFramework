package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigProp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		try 
		{
			FileReader reader = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			Properties properties = new Properties();
			properties.load(reader);
			System.out.println(properties.getProperty("browser"));
			System.out.println(properties.getProperty("testurl"));
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
