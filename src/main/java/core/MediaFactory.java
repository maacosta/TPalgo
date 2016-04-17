package core;

import interfaces.Library;
import entities.LibraryEntity;
import imp.LibraryImp;

public class MediaFactory
{
	private String _path;
	private ConfigManager _configManager;
	private JmlReader _jmlReader;
	private LibraryEntity _libraryEntity;
	
	public MediaFactory(String path)
	{
		this._path = path;
		this._configManager = new ConfigManager();
		this._jmlReader = new JmlReader(this._configManager.getValue("info-jml-name"));
		
	}
	
	public Library CreateLibrary()
	{
		Library l = new LibraryImp(this._libraryEntity, this._configManager);
		
		return l;
	}
}
