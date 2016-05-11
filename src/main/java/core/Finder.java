package core;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import entities.ConfigEntity;
import entities.TitleEntity;

public class Finder extends SimpleFileVisitor<Path>
{
	private List<TitleEntity> titles;
	private JmlReader reader;
	
	
	public Finder(ConfigEntity _config){
		this.titles = new ArrayList<TitleEntity>();
		this.reader = new JmlReader(_config);
	}
	
	public List<TitleEntity> getTitlesTree(){
		return this.titles;
	}
	/*
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException
	{
		System.out.println("Se esta por procesar: " + dir);
		return FileVisitResult.CONTINUE;
	}*/

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
	{
		if(attrs.isRegularFile() && file.endsWith("info.jml")) 
		{
			this.titles.add(reader.getInfo(file.getParent().toString()));
		}
		return FileVisitResult.CONTINUE;
	}
	/*
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException
	{
		System.err.println(exc.getMessage());
		return FileVisitResult.CONTINUE;
	}*/
	/*
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException
	{
		System.out.println("Se proceso: " + dir);
		return FileVisitResult.CONTINUE;
	}*/

}
