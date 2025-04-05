package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author mithun
 *
 */

public class FileUtiliy {
	/** 
	 * This method will read data from property file and return it in String format to the caller
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	
	public String getDataFromProperty(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/commondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
		
	}

}
