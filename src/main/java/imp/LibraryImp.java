package imp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import core.ConfigManager;
import entities.LibraryEntity;
import entities.TitleEntity;
import interfaces.Filter;
import interfaces.Label;
import interfaces.Library;
import interfaces.Title;

public class LibraryImp implements Library
{
	private LibraryEntity _libraryEntity;
	
	
	public LibraryImp(LibraryEntity libraryEntity)
	{
		this._libraryEntity = libraryEntity;
	}
	
	
	public List<Title> getTitles()
	{
		List<Title> titleList = new ArrayList<Title>();
		
		this._libraryEntity.Titles.forEach(te -> 
		{
			titleList.add(new TitleImp(this._libraryEntity, te));
		});
		
		return titleList;
	}

	public List<Filter> getFilters()
	{
		throw new UnsupportedOperationException();
	}

	public Filter getFilter(String filtername)
	{
		throw new UnsupportedOperationException();
		/*for (Filter filter : this.filters){
			if(filter.getName() == filtername)
				return filter;
		}
		return null;*/
	}

	public List<Label> getLabels(Filter f)
	{
		Filter filter = this.getFilter(f.getName());
		return filter.getLabels();
	}

	public Label getLabel(Filter f, String labelname)
	{
		throw new UnsupportedOperationException();
	}

	public List<Title> getTitles(Filter f, Label lb)
	{
		throw new UnsupportedOperationException();
		/*Stream<Title> titlesList = titles.stream().filter(it -> it.getAtt(f).contains(lb));
		
		return (List<Title>)titlesList;*/
	}
}
