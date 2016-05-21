package entities;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import imp.LabelImp;
import interfaces.Label;

public class ConfigEntity
{
	public String InfoJmlName;
	public String Separador;
	public String AlbumsPath;
	public Hashtable<String, List<LabelEntity>> sublabels;
	
	public ConfigEntity(){
		this.sublabels = new Hashtable<String, List<LabelEntity>>();
	}
	
	public boolean isSublabel(String labelName){
		return this.sublabels.containsKey(labelName);
	}
	
	public List<Label> getSublabels(String name, LibraryEntity libraryEntity, String filtername)
	{
		List<Label> sub = new ArrayList<Label>();
		
		if(this.isSublabel(name)){
			for(LabelEntity lb : this.sublabels.get(name)){
				sub.add(new LabelImp(libraryEntity,filtername,lb.Nombre,this));
			}
		}
			
		return sub;
	}
}
