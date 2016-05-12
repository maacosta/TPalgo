package testsIniciales;

import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import entities.ConfigEntity;
import entities.LibraryEntity;
import entities.TitleEntity;
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
		Title ti = new TitleImp(le, te);
		
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
		Title ti = new TitleImp(le, te);
		
		Assert.assertEquals("path 1", ti.getPath());
	}
	
	@Test
	public void testGetAtts()
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
		
		Title ti = new TitleImp(le, te);
		Hashtable<Filter, List<Label>> att = ti.getAtts();
		
		Assert.assertEquals(2, att.size());
		
		Filter f = null;
		Set<Filter> fis = att.keySet();

		for(Filter fi : fis)
		{
			if(fi.getName() == "Genero")
			{
				f = fi;
				break;
			}
		}
		Assert.assertEquals(3, att.get(f).size());
		
		for(Filter fi : fis)
		{
			if(fi.getName() == "Artista")
			{
				f = fi;
				break;
			}
		}
		
		Assert.assertEquals(1, att.get(f).size());
	}
	
	@Test
	public void testGetAtt()
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
		
		Title ti = new TitleImp(le, te);

		Filter f = null;
		Hashtable<Filter, List<Label>> att = ti.getAtts();
		for(Filter fi : att.keySet())
		{
			if(fi.getName() == "Genero")
			{
				f = fi;
				break;
			}
		}
		
		Assert.assertEquals(2, ti.getAtt(f).size());		
	}
}
