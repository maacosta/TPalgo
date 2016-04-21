package core;

import interfaces.Library;
import entities.ConfigEntity;
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
	}
	
	public Library CreateLibrary()
	{
		//ConfigManager debería devolver el ConfigEntity cargado
		ConfigEntity config = new ConfigEntity();
		
		this._jmlReader = new JmlReader(config);
		
		this._libraryEntity = new LibraryEntity();
		
		Library l = new LibraryImp(this._libraryEntity);
		
		return l;
	}
}
