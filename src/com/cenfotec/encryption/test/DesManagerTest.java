package com.cenfotec.encryption.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cenfotec.encryption.manager.DesEncryptionManager;
import com.cenfotec.encryption.utils.FindFileUtility;

public class DesManagerTest {

	static DesEncryptionManager desManager;
	private  final static String keyName = "keyTestDes";
	private final static String keyMessageName = "Test";
	private final String keyMessage = "Hi, I'm test";
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		desManager = new DesEncryptionManager();	
	}

	@Test
	public void testGenerateKey() throws Exception {
		desManager.createKey(keyName);
		assertTrue(FindFileUtility.FindFile("des",keyName , ".key"));
	}
	
	@Test
	public void testEncryptFile() throws Exception {
		desManager.createKey(keyName);
		desManager.encryptMessage(keyMessageName, keyMessage, keyName);
		assertTrue(FindFileUtility.FindFile("des", keyMessageName, ".encript"));
	}
	
	@Test 
	public void testDecryptFile () throws Exception {
		desManager.createKey(keyName);
		desManager.encryptMessage(keyMessageName, keyMessage, keyName);
		String message = desManager.decryptMessage(keyMessageName, keyName);
		assertEquals(keyMessage, message);
	}

}
