package com.qapitol.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropFile {
    private static Properties prop;
    private final static String propertFilePath = "C:\\Users\\Qapitol QA\\IdeaProjects\\DemoAutomation\\src\\main\\resources\\config\\data.properties";

    private static void loadData() throws IOException, FileNotFoundException {
        prop = new Properties();

        File f = new File(propertFilePath);

        FileReader obj = new FileReader(f);
        prop.load(obj);
    }

    public static String getObject(String data) throws IOException {
        loadData();
        return prop.getProperty(data);
    }
}
