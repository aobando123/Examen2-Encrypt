package com.cenfotec.encryption.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cenfotec.encryption.manager.SymetricEncryptManager;

public class SymetricEncryptManagerTest {

	static SymetricEncryptManager symetricEncrypt;
	private  final static String keyName = "keyTestSym";
	private final static String keyMessageName = "Test";
	private final String keyMessage = "Hi, I'm test";
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		symetricEncrypt = new SymetricEncryptManager();	
    	
	}

	@Test
	public void testGenerateKey() throws Exception {
		symetricEncrypt.createKey(keyName);
		assertTrue(findFile(keyName, ".key"));
	}
	
	@Test
	public void testEncryptFile() throws Exception {
		symetricEncrypt.createKey(keyName);
		symetricEncrypt.encryptMessage(keyMessageName, keyMessage, keyName);
		assertTrue(findFile(keyMessageName, ".encript"));
	}
	
	@Test 
	public void testDecryptFile () throws Exception {
		symetricEncrypt.createKey(keyName);
		symetricEncrypt.encryptMessage(keyMessageName, keyMessage, keyName);
		String message = symetricEncrypt.decryptMessage(keyMessageName, keyName);
		assertEquals(keyMessage, message);
	}

	
	
	private boolean findFile( String fileName, String extension) {
		try {
			File keyFile = new File("C:\\encrypt\\symetric\\" + fileName + extension );
			return true;
		} catch(Exception e) {
			return false;
		}
		
	}

}
