package imp;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

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
			Filter f = new FilterImp(this._libraryEntity, fe.Nombre);
			List<Label> labels = new ArrayList<Label>();
			
			fe.Labels.forEach(l -> labels.add(new LabelImp(this._libraryEntity, fe.Nombre, l.Nombre)));
			
			hash.put(f, labels);
		});

		return hash;
	}
	
	public List<Label> getAtt(Filter filtername) 
	{
		return this.getAtts().get(filtername);
	}
}
