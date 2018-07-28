package com.cenfotec.encryption.manager;

import com.cenfotec.encryption.enums.CipherTypeEnum;
import com.cenfotec.encryption.enums.EncryptionTypeEnum;

public class EncryptionManagerFactory {
	public static EncryptionManager create (EncryptionTypeEnum encryptionType, 
			CipherTypeEnum cipherEnum) {
		
		switch (encryptionType) {
		case Asymetric:
			return new AsymetricEncryptManager(cipherEnum);
		case Symetric:
			return new SymetricEncryptManager(cipherEnum);

		default:
			return null;
		}
		
	}
}
