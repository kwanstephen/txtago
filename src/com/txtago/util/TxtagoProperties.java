package com.txtago.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;


public class TxtagoProperties {
		

	private static Logger log = Logger.getLogger(TxtagoProperties.class);
	

	private static TxtagoProperties instance = new TxtagoProperties();
	

	private Properties props = new Properties();
	

	private TxtagoProperties() {
		loadFromFile("/config/txtago.properties");
	}


	public static TxtagoProperties getInstance() {
		return instance;
	}
	

	private void loadFromFile(String filename) {
		
		try {
			ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
			InputStream is = servletContext.getResourceAsStream(filename);
			props.load(is);
		} 
		catch (FileNotFoundException e) {
			log.error("Could not find configuration file, \"" + filename + "\"", e);
		} 
		catch (IOException e) {
			log.error("Could not load configuration file, \"" + filename + "\"", e);
		}
	}
	
	public void setProperty(String key, String value)
	{
		props.setProperty(key, value);
	}
	
	public Set getKeySet()
	{
		return props.keySet();
	}


	public String getProperty(String key) {
		return props.getProperty(key);
	}
	

}
