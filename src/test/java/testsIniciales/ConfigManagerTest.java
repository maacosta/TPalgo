package testsIniciales;

import java.util.Enumeration;
import core.ConfigManager;
import entities.ConfigEntity;
import junit.framework.TestCase;

public class ConfigManagerTest extends TestCase
{
	public void testGetConfigEntity(){
		
		ConfigManager config=new ConfigManager();
		ConfigEntity cfgEntity = config.getTestConfigEntity();
		assertEquals("test2",cfgEntity.Separador);
		assertEquals("test1",cfgEntity.InfoJmlName);
	}
	
	public void testGetConfigEntity2(){
		ConfigManager config=new ConfigManager();
		ConfigEntity cfgEntity = config.getTestConfigEntity();
		
		assertTrue(cfgEntity.isSublabel("Géneros Populares"));
		assertTrue(cfgEntity.isSublabel("Música del Mundo"));
		
		assertEquals("Rock", cfgEntity.sublabels.get("Géneros Populares").get(0).Nombre);
		assertEquals("Pop", cfgEntity.sublabels.get("Géneros Populares").get(1).Nombre);
		assertEquals("Electrónica", cfgEntity.sublabels.get("Géneros Populares").get(2).Nombre);
		assertEquals("España", cfgEntity.sublabels.get("Música del Mundo").get(0).Nombre);
		assertEquals("Brasil", cfgEntity.sublabels.get("Música del Mundo").get(1).Nombre);
		assertEquals("Cuba", cfgEntity.sublabels.get("Música del Mundo").get(2).Nombre);
		
		assertTrue("España" != cfgEntity.sublabels.get("Géneros Populares").get(0).Nombre);
		assertTrue("Brasil"!= cfgEntity.sublabels.get("Géneros Populares").get(1).Nombre);
		assertTrue("Cuba"!= cfgEntity.sublabels.get("Géneros Populares").get(2).Nombre);
		assertTrue("Rock"!= cfgEntity.sublabels.get("Música del Mundo").get(0).Nombre);
		assertTrue("Pop"!= cfgEntity.sublabels.get("Música del Mundo").get(1).Nombre);
		assertTrue("Electrónica"!= cfgEntity.sublabels.get("Música del Mundo").get(2).Nombre);
	}
}
