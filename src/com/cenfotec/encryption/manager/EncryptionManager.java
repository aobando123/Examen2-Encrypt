package com.cenfotec.encryption.manager;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Decoder;

import com.cenfotec.encryption.enums.CipherTypeEnum;

public abstract class EncryptionManager {
	protected String Path;
	protected final String KEY_EXTENSION = ".key";
	protected final String MESSAGE_ENCRYPT_EXTENSION = ".encript";
	protected CipherTypeEnum CipherType; 
	public abstract void createKey(String name) throws Exception;
	public abstract void encryptMessage(String messageName, String message, String keyName) throws Exception;
	public abstract void decryptMessage(String messageName, String keyName) throws Exception;
	protected final void writeBytesFile(String name, byte[] content, String type) throws FileNotFoundException, IOException {
		FileOutputStream fos = new FileOutputStream(Path + name + type);
		fos.write(content);
		fos.close();
	}
	

	protected final byte[] readMessageFile(String messageName) throws Exception{
		File file = new File(Path + messageName + MESSAGE_ENCRYPT_EXTENSION);
        int length = (int) file.length();
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = new byte[length];
        reader.read(bytes, 0, length);
        Decoder oneDecoder = Base64.getDecoder();
	    reader.close();
		return oneDecoder.decode(bytes);
	}
}
