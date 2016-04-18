package imp;
import java.util.ArrayList;
import java.util.List;

import entities.FilterEntity;
import entities.LibraryEntity;
import interfaces.Filter;
import interfaces.Label;

public class FilterImp implements Filter
{
	private LibraryEntity _libraryEntity;
	private FilterEntity _filterEntity;
	
	
	public FilterImp(LibraryEntity libraryEntity, FilterEntity filterEntity)
	{
		this._libraryEntity = libraryEntity;
		this._filterEntity = filterEntity;
	}
	
	
	public String getName(){
		return this._filterEntity.Nombre;
	}

	public List<Label> getLabels()
	{
		List<Label> labelList = new ArrayList<Label>();
		
		this._filterEntity.Labels.forEach(le ->
		{
			labelList.add(new LabelImp(this._libraryEntity, le));
		});
		
		return labelList;
	}
}
