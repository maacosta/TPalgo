package testsIniciales;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import entities.FilterEntity;
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
		
		LibraryEntity le = new LibraryEntity();
		le.Titles = new ArrayList<TitleEntity>();
		le.Titles.add(te1);
		le.Titles.add(te2);
		
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
		te1.Filters = new ArrayList<FilterEntity>();
		FilterEntity fe1_1 = new FilterEntity("Rock");
		FilterEntity fe1_2 = new FilterEntity("Pop");
		te1.Filters.add(fe1_1);
		te1.Filters.add(fe1_2);
		
		TitleEntity te2 = new TitleEntity();
		FilterEntity fe2_1 = new FilterEntity("Alternativo");
		FilterEntity fe2_2 = new FilterEntity("Pop");
		FilterEntity fe2_3 = new FilterEntity("Rock");
		te1.Filters.add(fe2_1);
		te1.Filters.add(fe2_2);
		te1.Filters.add(fe2_3);
		
		LibraryEntity le = new LibraryEntity();
		le.Titles = new ArrayList<TitleEntity>();
		le.Titles.add(te1);
		le.Titles.add(te2);
		
		Library l = new LibraryImp(le);
		
		Filter f = l.getFilter("Rock");
		
		Assert.assertEquals("Rock", f.getName());
	}
}
