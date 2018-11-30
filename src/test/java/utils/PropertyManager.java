package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String propertyFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\configuration.properties";
    private static String url;
    private static String email;
    private static String password;

    public static PropertyManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }

    private void loadData() {
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream(propertyFilePath));
        }
        catch (IOException e) {
            System.out.println(("Configuration properties file cannot be found"));
        }

        url = prop.getProperty("url");
        email = prop.getProperty("email");
        password = prop.getProperty("password");
    }

    public String getUrl() {
        return url;
    }

    public String getEmail () {
        return email;
    }

    public String getPassword () {
        return password;
    }
}
