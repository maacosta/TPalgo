package imp;
import java.util.ArrayList;
import java.util.List;

import entities.ConfigEntity;
import entities.FilterEntity;
import entities.LabelEntity;
import entities.LibraryEntity;
import entities.TitleEntity;
import interfaces.Label;
import interfaces.Title;


public class LabelImp implements Label
{
	private LibraryEntity _libraryEntity;
	private String _filtername;
	private String _labelname;
	private ConfigEntity _configEntity;
	
	
	public LabelImp(LibraryEntity libraryEntity, String filtername, String labelname, ConfigEntity config)
	{
		this._libraryEntity = libraryEntity;
		this._filtername = filtername;
		this._labelname = labelname;
		this._configEntity = config;
	}
	
	
	public String getName()
	{
		return this._labelname;
	}

	public List<Title> getTitles()
	{
		List<Title> t = new ArrayList<Title>();
		
		for(TitleEntity title : this._libraryEntity.Titles){
			if(title.containsLabel(this._labelname))
				t.add(new TitleImp(this._libraryEntity, title, this._configEntity));
		}
		return t;
	}
	
	public List<Label> getSublabels()
	{
		return this._configEntity.getSublabels(this.getName(), this._libraryEntity, this._filtername);
	}
	
}
