package imp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import entities.ConfigEntity;
import entities.LibraryEntity;
import interfaces.Filter;
import interfaces.Label;
import interfaces.Library;
import interfaces.Title;

public class LibraryImp implements Library
{
	private LibraryEntity _libraryEntity;
	private ConfigEntity _configEntity;
	public List<Filter> filters;
	public Set<Title> titles = new HashSet<Title>();

	public LibraryImp(LibraryEntity libraryEntity, ConfigEntity configEntity)
	{
		this._libraryEntity = libraryEntity;
		this._configEntity = configEntity;
	}
	
	@SuppressWarnings("unchecked")
	public List<Title> getTitles()
	{
		// TODO cargar titulos a titles
		return (List<Title>)titles;
	}

	public List<Filter> getFilters()
	{
		return this.filters;
	}

	public Filter getFilter(String filtername)
	{
		for (Filter filter : this.filters){
			if(filter.getName() == filtername)
				return filter;
		}
		return null;
	}

	public List<Label> getLabels(Filter f)
	{
		Filter filter = this.getFilter(f.getName());
		return filter.getLabels();
	}

	public Label getLabel(Filter f, String labelname)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Title> getTitles(Filter f, Label lb)
	{
		// TODO Auto-generated method stub
		Stream<Title> titlesList = titles.stream().filter(it -> it.getAtt(f).contains(lb));
		
		return (List<Title>)titlesList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Label> getLabels2(Filter f) {
		
		Set<Label> labels = new HashSet<Label>();
		for(Title title:getTitles()) {
			labels.addAll(title.getAtt(f));
		}
		return (List<Label>)labels;
	}

}
