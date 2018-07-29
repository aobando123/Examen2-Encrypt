package com.cenfotec.encryption.manager;

import com.cenfotec.encryption.enums.CipherTypeEnum;

public class EncryptionManagerFactory {
	public static EncryptionManager create (CipherTypeEnum cipherEnum) {
		
		switch (cipherEnum) {
		case RSA:
			return new AsymetricEncryptManager();
		case AES:
			return new SymetricEncryptManager();
		case DES:
			return new DesEncryptionManager();
		default:
			return null;
		}
		
	}
}
