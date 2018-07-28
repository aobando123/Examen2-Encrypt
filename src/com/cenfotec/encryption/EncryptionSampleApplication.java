package com.cenfotec.encryption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.cenfotec.encryption.enums.CipherTypeEnum;
import com.cenfotec.encryption.enums.EncryptionTypeEnum;
import com.cenfotec.encryption.manager.EncryptionManager;



public class EncryptionSampleApplication {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static EncryptionManager encryptManager;
	
	
	public static void main(String[] args) throws Exception {
		System.out.println("Choose your preferred encryptionType");
		System.out.println("Choose your preferred encryptionType");
		int option = 0;
		do {
    		System.out.println("1.Create key");
        	System.out.println("2.Encript Message");
        	System.out.println("3.Decrypt Message");
        	System.out.println("4.Exit ");
        	option = Integer.parseInt(br.readLine());
        	if (option >= 1 && option <= 3){
        		executeAction(option);
        	}
    	} while (option != 4);

    	
    }
	
	private static void initEncryptionManager() throws Exception{
		int option;
		CipherTypeEnum cipherType;
		EncryptionTypeEnum encryptType = getEncryptionType();
		
		
	}

	private static EncryptionTypeEnum getEncryptionType() throws IOException {
		int option;
		
		System.out.println("Choose your preferred encryptionType");
		System.out.println("1. Asymetric");
		System.out.println("2. Symetric");
		option = Integer.parseInt(br.readLine());
		if(option == 1) {
			return EncryptionTypeEnum.Asymetric;
		} else {
			return EncryptionTypeEnum.Symetric;
		}
	}
	private static CipherTypeEnum getCipherType() throws IOException {
		int option;
		
		System.out.println("Choose your preferred encryptionType");
		System.out.println("1. AES");
		System.out.println("2. RSA");
		System.out.println("3. DES");
		option = Integer.parseInt(br.readLine());
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
			encryptManager.decryptMessage(messageName, keyName);			
		}
	}
}
