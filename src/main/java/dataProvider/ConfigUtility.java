package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtility {
	
	public static String readProperty(String key) throws IOException
	{
		File src = new File(System.getProperty("user.dir")+("/Configuration/config.properties"));
		FileInputStream fis = new FileInputStream(src);
		Properties prop = new Properties();
		prop.load(fis);
		String valueOfKey = prop.getProperty(key);
		return valueOfKey;
	}
}
