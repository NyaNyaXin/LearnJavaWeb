package com.cx.javaweb.fileupload.app.listeners;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.cx.javaweb.fileupload.app.utils.FileUploadAppProperties;

/**
 * Application Lifecycle Listener implementation class FileUploadAppListener
 *
 */
public class FileUploadAppListener implements ServletContextListener {

    public FileUploadAppListener() {
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	InputStream in = getClass().getClassLoader().getResourceAsStream("/upload.properties");
    	Properties properties = new Properties();
    	try {
			properties.load(in);
			for(Map.Entry<Object, Object> prop:properties.entrySet()) {
				String propertyName = (String) prop.getKey();
				String propertyValue = (String) prop.getValue();
				FileUploadAppProperties.getInstance().addProperty(propertyName, propertyValue);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
