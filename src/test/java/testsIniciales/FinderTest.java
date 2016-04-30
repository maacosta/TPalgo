package testsIniciales;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;
import core.Finder;
import entities.ConfigEntity;

public class FinderTest
{

	@Test
	public void testFinder()
	{
		ConfigEntity cfg = new ConfigEntity();
		cfg.Separador = ";";
		cfg.InfoJmlName = "info.jml";
		Finder f = new Finder(cfg);
		String albumsStringPath = this.getClass().getResource("/testResources/ALBUMS").getPath();
		Path albumsPath = Paths.get(albumsStringPath.substring(1));
		try
		{
			Files.walkFileTree(albumsPath,f);
			assertEquals("Francis Albert Sinatra & Antonio Carlos Jobim son Muy Amigos",f.getTitlesTree().get(0).Nombre);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
