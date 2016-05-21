package testsIniciales;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import entities.ConfigEntity;
import entities.LibraryEntity;
import imp.LibraryImp;
import interfaces.Filter;
import interfaces.Label;
import interfaces.Library;
import interfaces.Title;

public class LibraryTest
{
	@Test
	public void testGetTitles()
	{
		SetOfData sod = new SetOfData();
		LibraryEntity le = new LibraryEntity(new ConfigEntity(), sod.getTitles_sod1());
		
		Library li = new LibraryImp(le, new ConfigEntity());
		
		List<Title> tL = li.getTitles();
		
		Assert.assertEquals(3, tL.size());
		Assert.assertEquals(true, tL.stream().anyMatch(t -> t.getName() == "Disco 1"));
		Assert.assertEquals(true, tL.stream().anyMatch(t -> t.getName() == "Disco 2"));
		Assert.assertEquals(true, tL.stream().anyMatch(t -> t.getName() == "Disco 3"));
	}
	
	@Test
	public void testGetFilters()
	{
		SetOfData sod = new SetOfData();
		LibraryEntity le = new LibraryEntity(new ConfigEntity(), sod.getTitles_sod1());
		
		Library li = new LibraryImp(le, new ConfigEntity());
		
		List<Filter> fs = li.getFilters();
		
		Assert.assertEquals(2, fs.size());
	}
	
	@Test
	public void testGetFilter()
	{
		SetOfData sod = new SetOfData();
		LibraryEntity le = new LibraryEntity(new ConfigEntity(), sod.getTitles_sod1());
		
		Library li = new LibraryImp(le, new ConfigEntity());
		
		Filter f = li.getFilter("Genero");
		
		Assert.assertEquals("Genero", f.getName());
		Assert.assertEquals(3, f.getLabels().size());
	}
	
	@Test
	public void testGetLabels()
	{
		SetOfData sod = new SetOfData();
		LibraryEntity le = new LibraryEntity(new ConfigEntity(), sod.getTitles_sod1());
		
		Library li = new LibraryImp(le, new ConfigEntity());
		Filter fi1 = li.getFilter("Genero");
		Filter fi2 = li.getFilter("Artista");
		
		Assert.assertEquals(3, li.getLabels(fi1).size());
		Assert.assertEquals(2, li.getLabels(fi2).size());
	}
	
	@Test
	public void testGetLabel()
	{
		SetOfData sod = new SetOfData();
		LibraryEntity le = new LibraryEntity(new ConfigEntity(), sod.getTitles_sod1());
		
		Library li = new LibraryImp(le, new ConfigEntity());
		Filter fi = li.getFilter("Genero");
		
		Assert.assertEquals("Rock", li.getLabel(fi, "Rock").getName());
	}
	
	@Test
	public void testGetTitles_byFilterLabel()
	{
		SetOfData sod = new SetOfData();
		LibraryEntity le = new LibraryEntity(new ConfigEntity(), sod.getTitles_sod1());
		
		Library li = new LibraryImp(le, new ConfigEntity());
		Filter fi = li.getFilter("Genero");
		Label la = li.getLabel(fi, "Rock");
		List<Title> tl = li.getTitles(fi, la);
		
		Assert.assertEquals(2, tl.size());
		Assert.assertEquals(true, tl.stream().anyMatch(t -> t.getName() == "Disco 1"));
		Assert.assertEquals(true, tl.stream().anyMatch(t -> t.getName() == "Disco 2"));
	}
	
	@Test
	public void testGetTitles_byFilterLabel2()
	{
		SetOfData sod = new SetOfData();
		LibraryEntity le = new LibraryEntity(new ConfigEntity(), sod.getTitles_sod1());
		
		Library li = new LibraryImp(le, new ConfigEntity());
		Filter fi = li.getFilter("Genero");
		Label la = li.getLabel(fi, "Alternativo");
		List<Title> tl = li.getTitles(fi, la);
		
		Assert.assertEquals(1, tl.size());
		Assert.assertEquals(true, tl.stream().anyMatch(t -> t.getName() == "Disco 2"));
	}
	
	@Test
	public void testGetTitles_bySublabels()
	{
		SetOfData sod = new SetOfData();
		ConfigEntity cfg = new ConfigEntity();
		cfg.sublabels = sod.getSublabels_sod1();
		
		LibraryEntity le = new LibraryEntity(cfg, sod.getTitles_sod2());
		
		Library li = new LibraryImp(le, cfg);
		Filter fi = li.getFilter("Genero");
		Label la = li.getLabel(fi, "Géneros Populares");
		
		List<Title> tl = li.getTitles(fi, la);
		
		Assert.assertEquals(2, tl.size());
		Assert.assertEquals(true, tl.stream().anyMatch(t -> t.getName() == "Disco 1"));
		Assert.assertEquals(true, tl.stream().anyMatch(t -> t.getName() == "Disco 2"));
		Assert.assertEquals(false, tl.stream().anyMatch(t -> t.getName() == "Disco 3"));
	}
}
