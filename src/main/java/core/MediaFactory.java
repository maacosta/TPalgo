package core;

import interfaces.Library;
import entities.ConfigEntity;
import entities.LibraryEntity;
import imp.LibraryImp;

public class MediaFactory
{
	private String _path;
	private JmlReader _jmlReader;
	private LibraryEntity _libraryEntity;
	private ConfigEntity _configEntity;
	
	public MediaFactory(String path)
	{
		this._path = path;
		this._configEntity = new ConfigManager().getConfigEntity();	
	}
	
	public Library CreateLibrary()
	{
		this._jmlReader = new JmlReader(this._configEntity);
		
		this._libraryEntity = new LibraryEntity();
		
		Library l = new LibraryImp(this._libraryEntity);
		
		return l;
	}
}
