package base;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {

    private final String propertyFilePath= "config.properties";
    Properties properties = new Properties();

    public Properties returnConfigFiles() {

        try {
            InputStream input = ConfigFileReader.class.getClassLoader().getResourceAsStream(propertyFilePath);
            properties.load(input);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        return properties;
    }
}