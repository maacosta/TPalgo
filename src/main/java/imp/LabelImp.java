package imp;
import java.util.List;

import entities.LabelEntity;
import entities.LibraryEntity;
import interfaces.Label;
import interfaces.Library;
import interfaces.Title;


public class LabelImp implements Label
{
	private LibraryEntity _libraryEntity;
	private String _labelname;
	
	
	public LabelImp(LibraryEntity libraryEntity, String labelname)
	{
		this._libraryEntity = libraryEntity;
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
