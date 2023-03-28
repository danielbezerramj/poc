package br.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    private static final Logger LOG = LoggerFactory.getLogger(ReadProperties.class);

    private static ReadProperties instance = null;
    private Properties properties = null;

    private ReadProperties() {
        properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream("src/main/resources/properties/general.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }

    public static synchronized ReadProperties getInstance() {
        if (instance == null) {
            instance = new ReadProperties();
        }
        return instance;
    }

    public String getValue(String key) {
        return this.properties.getProperty(key, String.format("The key %s does not exists!", key));
    }
}
