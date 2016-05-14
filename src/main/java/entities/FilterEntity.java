package entities;

import java.util.ArrayList;
import java.util.List;

public class FilterEntity
{
	public String Nombre;
	public List<LabelEntity> Labels;
	
	
	public FilterEntity(String nombre)
	{
		this.Nombre = nombre;
		this.Labels = new ArrayList<LabelEntity>();
	}
	
	
	public boolean containsLabel(String _labelName)
	{
		for(LabelEntity l : this.Labels){
			if(l.Nombre == _labelName)
				return true;
		}
		return false;
	}
}
