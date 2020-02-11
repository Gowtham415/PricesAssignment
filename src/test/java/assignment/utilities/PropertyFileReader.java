package assignment.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	private static PropertyFileReader propInstance = null;
	static String configFilePath = System.getProperty("user.dir") + "\\Configurations\\config.properties";
	FileInputStream fileInput;
	Properties properties;

	private PropertyFileReader() {
		try {
			fileInput = new FileInputStream(new File(configFilePath));
			properties = new Properties();
			properties.load(fileInput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Singleton Object
	public static PropertyFileReader getInstance() {
		if (propInstance == null) {
			return new PropertyFileReader();
		} else {
			return propInstance;
		}
	}

	public String getproperty(String propertyname) {
		return properties.getProperty(propertyname);
	}
}
