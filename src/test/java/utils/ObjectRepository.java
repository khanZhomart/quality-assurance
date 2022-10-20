package utils;

import constants.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ObjectRepository {
    private static final Properties props;

    static {
        props = new Properties();
        try {
            InputStream file = new FileInputStream(Constants.PROPS_PATH);
            props.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String name) {
        return props.getProperty(name);
    }
}
