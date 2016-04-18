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
	private LabelEntity _labelEntity;
	
	
	public LabelImp(LibraryEntity libraryEntity, LabelEntity labelEntity)
	{
		this._libraryEntity = libraryEntity;
		this._labelEntity = labelEntity;
	}
	
	
	public String getName()
	{
		return this._labelEntity.Nombre;
	}

	public List<Title> getTitles()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public List<Label> getSublabels()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
