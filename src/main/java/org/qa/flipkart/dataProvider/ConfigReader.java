package org.qa.flipkart.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static String getProperty(String key){

        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream(new File(System.getProperty("user.dir") + "/src/main/resources/qa.properties")));
        }catch (FileNotFoundException e){
            System.out.println("Could not find the file "+e.getMessage());
        }catch(IOException e){
            System.out.println("Could not load the file "+e.getMessage());
        }
       return prop.getProperty(key);

    }
}
