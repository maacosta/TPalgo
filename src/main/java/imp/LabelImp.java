package imp;
import java.util.List;

import interfaces.Label;
import interfaces.Title;


public class LabelImp implements Label
{
	public String name;
	
	public LabelImp(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}

	public List<Title> getTitles()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public List<Label> getSublabels()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
