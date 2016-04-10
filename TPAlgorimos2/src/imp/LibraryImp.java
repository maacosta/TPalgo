package imp;
import java.util.List;

import interfaces.Filter;
import interfaces.Label;
import interfaces.Library;
import interfaces.Title;

public class LibraryImp implements Library
{
	public List<Filter> filters;

	@Override
	public List<Title> getTitles()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Filter> getFilters()
	{
		return this.filters;
	}

	@Override
	public Filter getFilter(String filtername)
	{
		for (Filter filter : this.filters){
			if(filter.getName() == filtername)
				return filter;
		}
		return null;
	}

	@Override
	public List<Label> getLabels(Filter f)
	{
		Filter filter = this.getFilter(f.getName());
		return filter.getLabels();
	}

	@Override
	public Label getLabel(Filter f, String labelname)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Title> getTitles(Filter f, Label lb)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
