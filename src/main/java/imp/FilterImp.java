package imp;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import entities.FilterEntity;
import entities.LabelEntity;
import entities.LibraryEntity;
import interfaces.Filter;
import interfaces.Label;

public class FilterImp implements Filter
{
	private LibraryEntity _libraryEntity;
	private String _filtername;
	
	
	public FilterImp(LibraryEntity libraryEntity, String filtername)
	{
		this._libraryEntity = libraryEntity;
		this._filtername = filtername;
	}
	
	
	public String getName(){
		return this._filtername;
	}

	public List<Label> getLabels()
	{
		List<Label> labelList = new ArrayList<Label>();
		Hashtable<String, LabelEntity> hash = new Hashtable<String, LabelEntity>();
		
		this._libraryEntity.Titles.forEach(te ->
		{
			te.Filters.forEach(fe -> 
			{
				if(fe.Nombre == this._filtername)
				{
					fe.Labels.forEach(le -> 
					{
						if(!hash.containsKey(le.Nombre))
						{
							hash.put(le.Nombre, le);
							labelList.add(new LabelImp(this._libraryEntity, le.Nombre));
						}
					});
				}
			});
		});
		
		return labelList;
	}
}
