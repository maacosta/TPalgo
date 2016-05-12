package imp;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import entities.FilterEntity;
import entities.LibraryEntity;
import entities.TitleEntity;
import interfaces.Filter;
import interfaces.Label;
import interfaces.Library;
import interfaces.Title;

public class LibraryImp implements Library
{
	private LibraryEntity _libraryEntity;
	List<Title> titleList = new ArrayList<Title>();
	
	public LibraryImp(LibraryEntity libraryEntity)
	{
		this._libraryEntity = libraryEntity;
	}
	
	
	public List<Title> getTitles()
	{
		titleList.clear();
		
		this._libraryEntity.Titles.forEach(te -> 
		{
			titleList.add(new TitleImp(this._libraryEntity, te));
		});
		
		return titleList;
	}

	public List<Filter> getFilters()
	{
		List<Filter> f = new ArrayList<Filter>();
		Hashtable<String, FilterEntity> hash = new Hashtable<String, FilterEntity>();
		
		for(TitleEntity te : this._libraryEntity.Titles)
		{
			for(FilterEntity fe : te.Filters)
			{
				if(!hash.containsKey(fe.Nombre))
				{
					hash.put(fe.Nombre, fe);
					f.add(new FilterImp(this._libraryEntity, fe.Nombre));
				}
			}
		}
		
		return f;
	}

	public Filter getFilter(String filtername)
	{
		return new FilterImp(this._libraryEntity, filtername);
	}

	public List<Label> getLabels(Filter f)
	{
		Filter filter = this.getFilter(f.getName());
		return filter.getLabels();
	}

	public Label getLabel(Filter f, String labelname)
	{
		return new LabelImp(this._libraryEntity, f.getName(), labelname);
	}

	public List<Title> getTitles(Filter f, Label lb)
	{
		List<Title> titleList = new ArrayList<Title>();
		
		for(TitleEntity te : this._libraryEntity.Titles)
		{
			for(FilterEntity fe : te.Filters)
			{
				if(fe.Nombre == f.getName())
				{
					titleList.add(new TitleImp(this._libraryEntity, te));
				}
			}
		}
		
		return titleList;
	}
}
