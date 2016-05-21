package core;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import entities.ConfigEntity;
import entities.LabelEntity;


//Esta clase encapsula el manejo del archivo de configuracion de la aplicacion
public class ConfigManager
{
	private Document doc;
	
	public ConfigManager() {
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
		config.AlbumsPath = this.getValue("albums-path");
		config.sublabels = this.getSublabels();
		return config;
	}
	
	private Hashtable<String,List<LabelEntity>> getSublabels()
	{
		Hashtable<String, List<LabelEntity>> listaSublabels = new Hashtable<String, List<LabelEntity>>();
		
		Element sublabelsCollection = (Element) this.doc.getElementsByTagName("sublabels").item(0);
		NodeList sublabels = sublabelsCollection.getElementsByTagName("label");
		
		for(int i = 0; i<sublabels.getLength(); i++){
			Element label = (Element) sublabels.item(i);
			
			String nombre = label.getNodeName();
			listaSublabels.put(label.getElementsByTagName("name").item(0).getTextContent(),this.getSublabelsFromNodeList(label));
		}
		
		return listaSublabels;
	}

	private List<LabelEntity> getSublabelsFromNodeList(Element label)
	{
		List<LabelEntity> lb = new ArrayList<LabelEntity>();
		NodeList sublabels = label.getElementsByTagName("sublabel");
		
		for(int i=0; i<sublabels.getLength(); i++){
			Element nodo = (Element) sublabels.item(i);
			if(nodo.getTagName() == "sublabel")
				lb.add(new LabelEntity(nodo.getTextContent()));
		}
		
		return lb;
	}

	public ConfigEntity getTestConfigEntity(){
		this.setDocument("/testResources/test-config.xml");
		return this.getConfigEntity();
	}
	
}
