package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.File;

public class PropertyManager {
    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static final String propertyFilePath = System.getProperty("user.dir") + File.separator + "src" +
        File.separator +  "test" + File.separator+ "resources" + File.separator + "configuration.properties";

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
