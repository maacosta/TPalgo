package entities;

import java.util.ArrayList;
import java.util.List;

public class TitleEntity
{
	public TitleEntity()
	{
		this.Filters = new ArrayList<FilterEntity>();
	}
	
	public String Nombre;
	public String Path;
	public List<FilterEntity> Filters;
}
