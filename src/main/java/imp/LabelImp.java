package imp;
import java.util.List;

import entities.FilterEntity;
import entities.LabelEntity;
import entities.LibraryEntity;
import interfaces.Label;
import interfaces.Title;


public class LabelImp implements Label
{
	private LibraryEntity _libraryEntity;
	private String _filtername;
	private String _labelname;
	
	
	public LabelImp(LibraryEntity libraryEntity, String filtername, String labelname)
	{
		this._libraryEntity = libraryEntity;
		this._filtername = filtername;
		this._labelname = labelname;
	}
	
	
	public String getName()
	{
		return this._labelname;
	}

	public List<Title> getTitles()
	{
		throw new UnsupportedOperationException();
	}

	public List<Label> getSublabels()
	{
		throw new UnsupportedOperationException();
	}
	
}
