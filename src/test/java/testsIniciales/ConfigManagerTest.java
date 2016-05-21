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
		
		assertTrue(cfgEntity.isSublabel("G�neros Populares"));
		assertTrue(cfgEntity.isSublabel("M�sica del Mundo"));
		
		assertEquals("Rock", cfgEntity.sublabels.get("G�neros Populares").get(0).Nombre);
		assertEquals("Pop", cfgEntity.sublabels.get("G�neros Populares").get(1).Nombre);
		assertEquals("Electr�nica", cfgEntity.sublabels.get("G�neros Populares").get(2).Nombre);
		assertEquals("Espa�a", cfgEntity.sublabels.get("M�sica del Mundo").get(0).Nombre);
		assertEquals("Brasil", cfgEntity.sublabels.get("M�sica del Mundo").get(1).Nombre);
		assertEquals("Cuba", cfgEntity.sublabels.get("M�sica del Mundo").get(2).Nombre);
		
		assertTrue("Espa�a" != cfgEntity.sublabels.get("G�neros Populares").get(0).Nombre);
		assertTrue("Brasil"!= cfgEntity.sublabels.get("G�neros Populares").get(1).Nombre);
		assertTrue("Cuba"!= cfgEntity.sublabels.get("G�neros Populares").get(2).Nombre);
		assertTrue("Rock"!= cfgEntity.sublabels.get("M�sica del Mundo").get(0).Nombre);
		assertTrue("Pop"!= cfgEntity.sublabels.get("M�sica del Mundo").get(1).Nombre);
		assertTrue("Electr�nica"!= cfgEntity.sublabels.get("M�sica del Mundo").get(2).Nombre);
	}
}
