package com.cenfotec.encryption.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cenfotec.encryption.manager.AsymetricEncryptManager;
import com.cenfotec.encryption.utils.FindFileUtility;

public class AsymetricManagerTest {

	static AsymetricEncryptManager asymetricManager;
	private  final static String keyName = "keyTestAsym";
	private final static String keyMessageName = "Test";
	private final String keyMessage = "Hi, I'm test";
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		asymetricManager = new AsymetricEncryptManager();	
	}

	@Test
	public void testGenerateKey() throws Exception {
		asymetricManager.createKey(keyName);
		assertTrue(FindFileUtility.FindFile("asymetric",keyName + "public", ".key"));
		assertTrue(FindFileUtility.FindFile("asymetric",keyName + "private", ".key"));
	}
	
	@Test
	public void testEncryptFile() throws Exception {
		asymetricManager.createKey(keyName);
		asymetricManager.encryptMessage(keyMessageName, keyMessage, keyName);
		assertTrue(FindFileUtility.FindFile("asymetric", keyMessageName, ".encript"));
	}
	
	@Test 
	public void testDecryptFile () throws Exception {
		asymetricManager.createKey(keyName);
		asymetricManager.encryptMessage(keyMessageName, keyMessage, keyName);
		String message = asymetricManager.decryptMessage(keyMessageName, keyName);
		assertEquals(keyMessage, message);
	}
}
