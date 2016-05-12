package testsIniciales;

import java.util.ArrayList;
import java.util.List;

import entities.FilterEntity;
import entities.LabelEntity;
import entities.TitleEntity;

public class SetOfData
{
	
	public List<TitleEntity> getTitles_sod1()
	{
		TitleEntity te1 = new TitleEntity();
		te1.Nombre = "Disco 1";
		te1.Path = "path 1";
		FilterEntity fe1_1 = new FilterEntity("Genero");
		fe1_1.Labels.add(new LabelEntity("Rock"));
		fe1_1.Labels.add(new LabelEntity("Pop"));
		te1.Filters.add(fe1_1);
		
		TitleEntity te2 = new TitleEntity();
		te2.Nombre = "Disco 2";
		te2.Path = "path 2";
		FilterEntity fe2_1 = new FilterEntity("Genero");
		fe2_1.Labels.add(new LabelEntity("Alternativo"));
		fe2_1.Labels.add(new LabelEntity("Pop"));
		fe2_1.Labels.add(new LabelEntity("Rock"));
		te2.Filters.add(fe2_1);
		FilterEntity fe2_2 = new FilterEntity("Artista");
		fe2_2.Labels.add(new LabelEntity("Roberto Carlos"));
		te2.Filters.add(fe2_2);
		
		TitleEntity te3 = new TitleEntity();
		te3.Nombre = "Disco 3";
		te3.Path = "path 3";
		FilterEntity fe3_1 = new FilterEntity("Artista");
		fe3_1.Labels.add(new LabelEntity("Bob Dylan"));
		te3.Filters.add(fe3_1);
		
		List<TitleEntity> titles = new ArrayList<TitleEntity>();
		titles.add(te1);
		titles.add(te2);
		titles.add(te3);

		return titles;
	}
}
