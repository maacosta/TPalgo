package testsIniciales;

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
}
