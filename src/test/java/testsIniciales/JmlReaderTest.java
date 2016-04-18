package testsIniciales;

import org.junit.Test;

import core.JmlReader;
import entities.ConfigEntity;
import entities.TitleEntity;
import junit.framework.Assert;

public class JmlReaderTest
{
	@Test
	public void testGetInfo1()
	{
		ConfigEntity config = new ConfigEntity();
		config.InfoJmlName = "info1.jml";
		config.Separador = ";";
		JmlReader reader = new JmlReader(config);
		String infoPath = this.getClass().getResource("/testResources/").getPath();
		TitleEntity t = reader.getInfo(infoPath.substring(1));
		
		Assert.assertEquals(4, t.Filters.size());
		Assert.assertEquals("Kiss",
				t.Filters.stream()
				.filter(f -> f.Nombre.equals("Artist")).findFirst().get()
				.Labels.get(0).Nombre);
		Assert.assertEquals("Rock",
				t.Filters.stream()
				.filter(f -> f.Nombre.equals("Genre")).findFirst().get()
				.Labels.get(0).Nombre);
	}

	@Test
	public void testGetInfo2()
	{
		ConfigEntity config = new ConfigEntity();
		config.InfoJmlName = "info2.jml";
		config.Separador = ";";
		JmlReader reader = new JmlReader(config);
		String infoPath = this.getClass().getResource("/testResources/").getPath();
		TitleEntity t = reader.getInfo(infoPath.substring(1));
		
		Assert.assertEquals(3, t.Filters.size());
		Assert.assertEquals("Kiss",
				t.Filters.stream()
				.filter(f -> f.Nombre.equals("Artist")).findFirst().get()
				.Labels.get(0).Nombre);
		Assert.assertEquals("Rock",
				t.Filters.stream()
				.filter(f -> f.Nombre.equals("Genre")).findFirst().get()
				.Labels.get(0).Nombre);
		Assert.assertEquals("Pop",
				t.Filters.stream()
				.filter(f -> f.Nombre.equals("Genre")).findFirst().get()
				.Labels.get(1).Nombre);
	}

}
