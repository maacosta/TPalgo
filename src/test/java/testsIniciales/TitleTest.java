package testsIniciales;

import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import entities.ConfigEntity;
import entities.LibraryEntity;
import entities.TitleEntity;
import imp.LibraryImp;
import imp.TitleImp;
import interfaces.Filter;
import interfaces.Label;
import interfaces.Title;
import junit.framework.Assert;

public class TitleTest
{
	@Test
	public void testGetName()
	{
		SetOfData sod = new SetOfData();
		List<TitleEntity> tel = sod.getTitles_sod1();
		LibraryEntity le = new LibraryEntity(new ConfigEntity(), tel);
		
		TitleEntity te = null;
		for(TitleEntity tei : tel)
		{
			if(tei.Nombre == "Disco 2")
			{
				te = tei;
				break;
			}
		}
		Title ti = new TitleImp(le, te, new ConfigEntity());
		
		Assert.assertEquals("Disco 2", ti.getName());
	}
	
	@Test
	public void testGetPath()
	{
		SetOfData sod = new SetOfData();
		List<TitleEntity> tel = sod.getTitles_sod1();
		LibraryEntity le = new LibraryEntity(new ConfigEntity(), tel);
		
		TitleEntity te = null;
		for(TitleEntity tei : tel)
		{
			if(tei.Nombre == "Disco 1")
			{
				te = tei;
				break;
			}
		}
		Title ti = new TitleImp(le, te, new ConfigEntity());
		
		Assert.assertEquals("path 1", ti.getPath());
	}
	
	@Test
	public void testGetAtts1()
	{
		SetOfData sod = new SetOfData();
		List<TitleEntity> tel = sod.getTitles_sod1();
		LibraryEntity le = new LibraryEntity(new ConfigEntity(), tel);
		
		LibraryImp library = new LibraryImp(le);
		
		List<Title> titles = library.getTitles();
		
		Hashtable<Filter,List<Label>> atts = titles.get(0).getAtts();
		
		Filter primerFiltro = (Filter)atts.keySet().toArray()[0];
		Assert.assertEquals("Genero",primerFiltro.getName());
		
		List<Label> primeraListaLabels = (List<Label>)atts.values().toArray()[0];
		
		Assert.assertEquals("Rock",primeraListaLabels.get(0).getName());
		Assert.assertEquals("Pop",primeraListaLabels.get(1).getName());
	}
	
	@Test
	public void testGetAtts2()
	{
		SetOfData sod = new SetOfData();
		List<TitleEntity> tel = sod.getTitles_sod1();
		LibraryEntity le = new LibraryEntity(new ConfigEntity(), tel);
		
		LibraryImp library = new LibraryImp(le);
		
		List<Title> titles = library.getTitles();
		
		Hashtable<Filter,List<Label>> atts = titles.get(2).getAtts();
		
		Filter primerFiltro = (Filter)atts.keySet().toArray()[0];
		Assert.assertEquals("Artista",primerFiltro.getName());
		
		List<Label> primeraListaLabels = (List<Label>)atts.values().toArray()[0];
		
		Assert.assertEquals("Bob Dylan",primeraListaLabels.get(0).getName());
	}
}
