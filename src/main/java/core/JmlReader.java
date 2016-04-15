package core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import entities.TitleEntity;

public class JmlReader
{
	private String _infoJmlName;
	
	public JmlReader(String infoJmlName)
	{
		this._infoJmlName = infoJmlName;
	}
	
	public TitleEntity getInfo(String path)
	{
		TitleEntity t = new TitleEntity();
		
		return t;
	}
	
	private List<String> GetLines(String path)
	{
		List<String> fileLines = null;
		Path jml = Paths.get(path, this._infoJmlName);
		try
		{
			fileLines=Files.readAllLines(jml);

			for(String fl:fileLines)
			{
				String f = fl.trim();
			}
		}
		catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileLines;
	}
}
