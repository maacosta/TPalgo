package imp;
import java.util.List;

import interfaces.Filter;
import interfaces.Label;

public class FilterImp implements Filter
{
	public String name;
	public List<Label> labels;
	
	@Override
	public String getName(){
		return this.name;
	}

	@Override
	public List<Label> getLabels()
	{
		return this.labels;
	}
}
