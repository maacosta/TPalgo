package imp;
import java.util.List;

import interfaces.Label;
import interfaces.Title;

public class LabelImp implements Label
{
	public String name;
	
	@Override
	public String getName()
	{
		return this.name;
	}

	@Override
	public List<Title> getTitles()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Label> getSublabels()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
