package imp;
import java.util.List;

import interfaces.Filter;
import interfaces.Label;

public class FilterImp implements Filter
{
	public String name;
	public List<Label> labels;
	
	public String getName(){
		return this.name;
	}

	public List<Label> getLabels()
	{
		return this.labels;
	}
}
