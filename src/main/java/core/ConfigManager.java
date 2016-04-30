package core;

import java.io.InputStream;
import javax.xml.parsers.*;
import org.w3c.dom.*;

import entities.ConfigEntity;


//Esta clase encapsula el manejo del archivo de configuracion de la aplicacion
public class ConfigManager
{
	private Document doc;
	
	public ConfigManager(){
		setDocument("/resources/config.xml");
	}

	private void setDocument(String configPath)
	{
		InputStream input = this.getClass().getResourceAsStream(configPath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try
		{
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(input);
			doc.getDocumentElement().normalize();
			this.doc = doc;
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	
	private String getValue(String configName){
		NodeList nodos = this.doc.getElementsByTagName(configName);
		return nodos.item(0).getTextContent();
	}
	
	public ConfigEntity getConfigEntity(){
		ConfigEntity config = new ConfigEntity();
		config.Separador = this.getValue("separador");
		config.InfoJmlName = this.getValue("info-jml-name");
		return config;
	}
	
	public ConfigEntity getTestConfigEntity(){
		this.setDocument("/testResources/test-config.xml");
		return this.getConfigEntity();
	}
}
