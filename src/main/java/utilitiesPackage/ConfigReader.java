/* 
 * This class reads the properties from the config file.
 */

package utilitiesPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	// we will be reading with the help of Properties file
	
	private Properties properties;
	
	// declare a string path and put the complete LOCATION of the file in your system
	private String path = "/Users/arkobiswas/Developer/eclipse-workspace/CucumberPOMSeries/src/test/resources/configPackage/config.properties";
	
	public Properties InitializeProperties() {
		
		properties = new Properties();
		
		// to interract with config.properties
		
		try {
			
			
			FileInputStream ip = new FileInputStream(path);
			properties.load(ip);
			System.out.println(">>> File launched successfully and input taken.");
		
		} catch (FileNotFoundException e) {
			
			System.out.println("!!! File not found exception.");
			
			e.printStackTrace();
		
		} catch (IOException e) {
			
			System.out.println("!!! I/O exception.");
			
			e.printStackTrace();
		}
		
		return properties;
		
	}

}
