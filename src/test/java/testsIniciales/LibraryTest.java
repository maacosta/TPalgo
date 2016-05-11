package testsIniciales;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import entities.ConfigEntity;
import entities.FilterEntity;
import entities.LabelEntity;
import entities.LibraryEntity;
import entities.TitleEntity;
import imp.LibraryImp;
import interfaces.Filter;
import interfaces.Library;
import interfaces.Title;

public class LibraryTest
{
	@Test
	public void testGetTitles()
	{
		TitleEntity te1 = new TitleEntity();
		te1.Nombre = "te1";
		
		TitleEntity te2 = new TitleEntity();
		te2.Nombre = "te2";
		
		List<TitleEntity> titles = new ArrayList<TitleEntity>();
		titles.add(te1);
		titles.add(te2);

		LibraryEntity le = new LibraryEntity(new ConfigEntity(), titles);
		
		Library l = new LibraryImp(le);
		
		List<Title> tL = l.getTitles();
		Assert.assertEquals(2, tL.size());
		Assert.assertEquals(tL.get(0).getName(), te1.Nombre);
		Assert.assertEquals(tL.get(1).getName(), te2.Nombre);
	}
	
	@Test
	public void testGetFilter()
	{
		TitleEntity te1 = new TitleEntity();
		FilterEntity fe1_1 = new FilterEntity("Genero");
		fe1_1.Labels.add(new LabelEntity("Rock"));
		fe1_1.Labels.add(new LabelEntity("Pop"));
		te1.Filters.add(fe1_1);
		
		TitleEntity te2 = new TitleEntity();
		FilterEntity fe2_1 = new FilterEntity("Genero");
		fe2_1.Labels.add(new LabelEntity("Alternativo"));
		fe2_1.Labels.add(new LabelEntity("Pop"));
		fe2_1.Labels.add(new LabelEntity("Rock"));
		te2.Filters.add(fe2_1);
		
		List<TitleEntity> titles = new ArrayList<TitleEntity>();
		titles.add(te1);
		titles.add(te2);

		LibraryEntity le = new LibraryEntity(new ConfigEntity(), titles);
		
		Library li = new LibraryImp(le);
		
		Filter f = li.getFilter("Genero");
		
		Assert.assertEquals("Genero", f.getName());
		Assert.assertEquals(3, f.getLabels().size());
	}
}
