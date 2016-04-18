package core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import entities.ConfigEntity;
import entities.FilterEntity;
import entities.LabelEntity;
import entities.TitleEntity;

public class JmlReader
{
	private ConfigEntity _configEntity;
	
	
	public JmlReader(ConfigEntity configEntity)
	{
		this._configEntity = configEntity;
	}
	
	
	public TitleEntity getInfo(String path)
	{
		TitleEntity t = new TitleEntity();
		t.Path = path;
		
		List<String> fileLines = this.GetLines(path);
		
		t.Filters = this.LoadEntity(fileLines);
		
		return t;
	}
	
	private List<String> GetLines(String path)
	{
		List<String> fileLines = null;
		Path jml = Paths.get(path, this._configEntity.InfoJmlName);
		try
		{
			fileLines = Files.readAllLines(jml);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return fileLines;
	}
	
	private List<FilterEntity> LoadEntity(List<String> fileLines)
	{
		List<FilterEntity> fList = new ArrayList<FilterEntity>();
		
		for(String line : fileLines)
		{
			int pos = line.indexOf("=");
			if(pos == -1) continue;
			
			String fn = line.substring(0, pos);
			String fv = line.substring(pos + 1);
			
			FilterEntity fe = new FilterEntity(fn);
			
			if(fv.indexOf(this._configEntity.Separador) == -1)
			{
				fe.Labels.add(new LabelEntity(fv));
			}
			else
			{
				String[] fvList = fv.split(this._configEntity.Separador);
				for(String v : fvList)
				{
					fe.Labels.add(new LabelEntity(v));
				}
			}
			fList.add(fe);
		}
		
		return fList;
	}
}
