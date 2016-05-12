package imp;

import java.util.Hashtable;
import java.util.List;

import entities.LabelEntity;
import entities.LibraryEntity;
import entities.TitleEntity;
import interfaces.Filter;
import interfaces.Label;
import interfaces.Title;

public class TitleImp implements Title
{
	private LibraryEntity _libraryEntity;
	private TitleEntity _titleEntity;

	
	public TitleImp(LibraryEntity libraryEntity, TitleEntity titleEntity)
	{
		this._libraryEntity = libraryEntity;
		this._titleEntity = titleEntity;
	}
	
	
	public String getName()
	{
		return this._titleEntity.Nombre;
	}

	
	public String getPath()
	{
		return this._titleEntity.Path;
	}

	public Hashtable<Filter,List<Label>> getAtts()
	{
		Hashtable<Filter, List<Label>> hash = new Hashtable<Filter, List<Label>>();
		
		this._titleEntity.Filters.forEach(fe -> 
		{
			Filter f = new FilterImp(this._libraryEntity, fe);
			hash.put(f, f.getLabels());
		});
		
		return hash;
	}
	
	public List<LabelEntity> getAtt(Filter filtername) 
	{
		int i = 0;
		for(; i < _titleEntity.Filters.size() && !_titleEntity.Filters.get(i).Nombre.equalsIgnoreCase(filtername.getName()); i++);
		
		return _titleEntity.Filters.get(i).Labels;
	}
}
