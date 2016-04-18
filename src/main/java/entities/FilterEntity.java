package entities;

import java.util.ArrayList;
import java.util.List;

public class FilterEntity
{
	public FilterEntity(String nombre)
	{
		this.Nombre = nombre;
		this.Labels = new ArrayList<LabelEntity>();
	}
	
	public String Nombre;
	public List<LabelEntity> Labels;
}
