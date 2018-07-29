package com.cenfotec.encryption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.cenfotec.encryption.enums.CipherTypeEnum;

import com.cenfotec.encryption.manager.EncryptionManager;
import com.cenfotec.encryption.manager.EncryptionManagerFactory;



public class EncryptionSampleApplication {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static EncryptionManager encryptManager;
	
	
	public static void main(String[] args) throws Exception {
		initEncryptionManager();
		int option = 0;
		do {
    		System.out.println("1.Create key");
        	System.out.println("2.Encript Message");
        	System.out.println("3.Decrypt Message");
        	System.out.println("4.Change Encryption Method");
        	System.out.println("5.Exit ");
        	option = Integer.parseInt(br.readLine());
        	if (option >= 1 && option <= 4){
        		executeAction(option);
        	}
    	} while (option != 5);

    	
    }
	
	private static void initEncryptionManager() throws Exception{
		CipherTypeEnum cipherType = getCipherType();
		encryptManager =  EncryptionManagerFactory.create( cipherType);
		
	}

	private static CipherTypeEnum getCipherType() throws IOException {
		int option;
		do {
		System.out.println("Choose your preferred encryption type");
		System.out.println("1. AES");
		System.out.println("2. RSA");
		System.out.println("3. DES");
		option = Integer.parseInt(br.readLine());
		} while(option < 0 && option > 4);
		switch (option) {
		case 1:
			
			return CipherTypeEnum.AES;
		case 2: 
			return CipherTypeEnum.RSA;
			
		case 3:
			return CipherTypeEnum.DES;

		default:
			return null;
		
		}
	}

	private static void executeAction(int option) throws Exception {
		if (option == 1){ 
			System.out.println("Key name: ");
			String name = br.readLine();
			encryptManager.createKey(name);
		}
		if (option == 2){
			System.out.println("Key name: ");
			String name = br.readLine();
			System.out.println("Message name: ");
			String messageName = br.readLine();
			System.out.println("Message: ");
			String message = br.readLine();
			encryptManager.encryptMessage(messageName,message,name);		
		}
		if (option == 3){
			System.out.println("Key name: ");
			String keyName = br.readLine();
			System.out.println("Message name: ");
			String messageName = br.readLine();
			String message = encryptManager.decryptMessage(messageName, keyName);
			System.out.println("El mensaje era:");
			System.out.println(message);
		}
		if(option == 4) {
			initEncryptionManager();
		}
	}
}
