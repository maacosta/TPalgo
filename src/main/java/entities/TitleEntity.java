package entities;

import java.util.ArrayList;
import java.util.List;

public class TitleEntity
{
	public String Nombre;
	public String Path;
	public List<FilterEntity> Filters;
	
	public TitleEntity()
	{
		this.Filters = new ArrayList<FilterEntity>();
	}
	
	
	public boolean containsLabel(String _labelName)
	{
		for(FilterEntity f : this.Filters){
			if(f.containsLabel(_labelName)){
				return true;
			}
		}
		return false;
	}
}
