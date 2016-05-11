package core;

import interfaces.Library;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
		
		Finder f = new Finder(this._configEntity);
		Path albumsPath = Paths.get(this._configEntity.AlbumsPath);
		try
		{
			Files.walkFileTree(albumsPath,f);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		this._libraryEntity = new LibraryEntity(this._configEntity, f.getTitlesTree());

		Library l = new LibraryImp(this._libraryEntity);
		
		return l;
	}
}
