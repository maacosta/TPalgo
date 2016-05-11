package core;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
		
		this.LoadEntity(fileLines, t);
		
		return t;
	}
	
	private List<String> GetLines(String path)
	{
		List<String> fileLines = null;
		Path jml = Paths.get(path, this._configEntity.InfoJmlName);
		try
		{
			fileLines = Files.readAllLines(jml, StandardCharsets.ISO_8859_1);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return fileLines;
	}
	
	private void LoadEntity(List<String> fileLines, TitleEntity t)
	{
		for(String line : fileLines)
		{
			int pos = line.indexOf("=");
			//sin = o sin valor, continuar
			if(pos == -1 || pos == line.length() - 1) continue;
			
			String fn = line.substring(0, pos);
			String fv = line.substring(pos + 1);
			
			if(fn.equals("Tittle"))
			{
				t.Nombre = fv;
			}

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
			t.Filters.add(fe);
		}
	}
}
