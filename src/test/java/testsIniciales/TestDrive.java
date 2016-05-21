package testsIniciales;

import core.MediaFactory;
import interfaces.Library;

public class TestDrive
{
	static MediaFactory mediaFactory = new MediaFactory("C:/");

	public static void main(String[] args)
	{
		Library library = mediaFactory.CreateLibrary();
		
		//library.getTitles().forEach(it -> System.out.println(it.getName()));
		
		library.getFilters().forEach(it -> System.out.println(it.getName()));
		
		//System.out.println(library.getFilters().get(3).getName());

	}

}
