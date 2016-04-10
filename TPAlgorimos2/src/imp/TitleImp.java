package imp;

import java.util.Hashtable;
import java.util.List;

import interfaces.Filter;
import interfaces.Label;
import interfaces.Title;

public class TitleImp implements Title
{
	public String name;
	public String path;
	
	
	@Override
	public String getName()
	{
		return this.name;
	}

	@Override
	public String getPath()
	{
		return this.path;
	}

	@Override
	public Hashtable<Filter,List<Label>> getAtts()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
