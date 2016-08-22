package com.tunnel.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

	public static byte[] readFileContentAsByteArray(String location) {
		byte[] arr = null;
		try (InputStream is = new FileInputStream(location);) {
			arr = new byte[is.available()];
			is.read(arr);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return arr;
	}
	
	public static void createPathIfNotExist(String ...paths){
		for(String path: paths){
			if (!Paths.get(path).toFile().exists()) {
				try {
					Files.createDirectories(Paths.get(path));
				} catch (IOException e) {
					throw new RuntimeException("Failed to create dir: " + path, e);
				}
			}
		}
	}
}