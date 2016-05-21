package core;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
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
		
		NodeList sublabels = this.doc.getElementsByTagName("sublabels");
		Hashtable<String, List<LabelEntity>> listaSublabels = new Hashtable<String, List<LabelEntity>>();
		
		for(int i = 0; i<sublabels.getLength(); i++){
			NodeList label = sublabels.item(i).getChildNodes();
			listaSublabels.put(this.getLabelNameFromNodeList(label),this.getSublabelsFromNodeList(label));
		}
		
		return listaSublabels;
	}

	private List<LabelEntity> getSublabelsFromNodeList(NodeList label)
	{
		List<LabelEntity> lb = new ArrayList<LabelEntity>();
		
		for(int i=0; i<label.getLength(); i++){
			Node nodo = label.item(i);
			if(nodo.getNodeName() == "sublabel")
				lb.add(new LabelEntity(nodo.getTextContent()));
		}
		
		return lb;
	}

	private String getLabelNameFromNodeList(NodeList label)
	{
		String nombre = "";
		
		for(int i=0; i<label.getLength(); i++){
			Node nodo = label.item(i);
			if(nodo.getNodeName() == "name")
				nombre = nodo.getTextContent();
		}
		
		return nombre;
	}

	public ConfigEntity getTestConfigEntity(){
		this.setDocument("/testResources/test-config.xml");
		return this.getConfigEntity();
	}
	
}
