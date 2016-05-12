package entities;

import java.util.List;

public class LibraryEntity
{
	public LibraryEntity(ConfigEntity config, List<TitleEntity> titles)
	{
		this.Config = config;
		this.Titles = titles;
	}
	
	public ConfigEntity Config;
	public List<TitleEntity> Titles;
}
