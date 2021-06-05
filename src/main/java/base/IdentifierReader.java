package base;

import java.io.InputStream;
import java.util.Properties;

public class IdentifierReader {

    private final String iOSpropertyFilePath= "ios.properties";
    private final String androidpropertyFilePath= "android.properties";

    Properties properties = new Properties();
    public static IdentifierReader defaultReader = new IdentifierReader();

    private IdentifierReader() {
        loadProperties();
    }

    private void loadProperties()  {
        try {
            if (System.getProperty("propEnv").equals("Android")) {
                InputStream input = ConfigFileReader.class.getClassLoader().getResourceAsStream(androidpropertyFilePath);
                properties.load(input);
            } else {
                InputStream input = ConfigFileReader.class.getClassLoader().getResourceAsStream(iOSpropertyFilePath);
                properties.load(input);
            }
        }

        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }
    }


    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}