package core;

import interfaces.Library;
import entities.ConfigEntity;
import entities.LibraryEntity;
import imp.LibraryImp;

public class MediaFactory
{
	private String _path;
	private ConfigEntity _configEntity;
	private JmlReader _jmlReader;
	private LibraryEntity _libraryEntity;
	
	public MediaFactory(String path)
	{
		this._path = path;
		this._configEntity = new ConfigEntity();
		this._configEntity.InfoJMLName = "info.jml";
		this._jmlReader = new JmlReader(this._configEntity.InfoJMLName);
		
	}
	
	public Library CreateLibrary()
	{
		Library l = new LibraryImp(this._libraryEntity, this._configEntity);
		
		return l;
	}
}
