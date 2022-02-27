package com.naukri.automation.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
	public void writeText(String content, String StorageFileLocation) {
		try {
			File file = new File(StorageFileLocation);
			boolean deletionResult = file.delete();
			file = new File(StorageFileLocation);			
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			TestNGLogUtility.info(file.getAbsoluteFile().getAbsolutePath());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

