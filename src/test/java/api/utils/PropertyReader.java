package api.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertyReader {
    protected static Properties properties;
    protected static BufferedReader bufferedReader;

    //Approach 1 to read value from config file
    public static Properties readProperty(){
        properties = new Properties();
        try {
            bufferedReader = new BufferedReader(new FileReader("src/test/resources/config.properties"));
            properties.load(bufferedReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    //Approach 2
    public static ResourceBundle readValue(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
        return resourceBundle;
    }
}
