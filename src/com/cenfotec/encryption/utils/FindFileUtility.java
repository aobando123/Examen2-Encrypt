package com.cenfotec.encryption.utils;

import java.io.File;

public class FindFileUtility {
	public static boolean FindFile( String dir,String fileName, String extension) {	
			File keyFile = new File("C:\\encrypt\\" + dir + "\\"+ fileName + extension );
			return keyFile.exists();	
		
	}
}
