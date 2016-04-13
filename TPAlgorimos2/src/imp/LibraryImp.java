package imp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import interfaces.Filter;
import interfaces.Label;
import interfaces.Library;
import interfaces.Title;

public class LibraryImp implements Library
{
	public List<Filter> filters;
	public Set<Title> titles = new HashSet<Title>();

	@Override
	public List<Title> getTitles()
	{
		// TODO cargar titulos a titles
		return titles;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Title> getTitles(Filter f, Label lb)
	{
		// TODO Auto-generated method stub
		Stream<Title> titlesList = titles.stream().filter(it -> it.getAtt(f).contains(lb));
		
		return (List<Title>)titlesList;
	}
	
	public List<Label> getLabels2(Filter f) {
		
		Set<Label> labels = new HashSet<Label>();
		for(Title title:getTitles()) {
			labels.addAll(title.getAtt(f));
		}
		return (List<Label>)labels;
	}

}
