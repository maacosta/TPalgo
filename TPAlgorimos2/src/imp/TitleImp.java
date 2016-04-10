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
	public Hashtable<Filter, List<Label>> atts = new Hashtable<Filter, List<Label>>();
	
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
		return this.atts;
	}
	
	public List<Label> getAtt(Filter attribute) 
	{
		if(atts.containsKey(attribute)) {
			return atts.get(attribute);
		}
		else return null;
	}

}
