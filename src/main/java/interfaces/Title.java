package interfaces;

import java.util.Hashtable;
import java.util.List;

import entities.LabelEntity;

public interface Title
{
	public String getName();
	public String getPath();
	public Hashtable<Filter,List<Label>>  getAtts();
	public List<LabelEntity> getAtt(Filter f);
}
