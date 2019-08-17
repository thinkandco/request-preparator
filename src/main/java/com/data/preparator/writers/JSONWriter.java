package com.data.preparator.writers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * The utility class JSONWriter.
 */
public class JSONWriter {

	private JSONWriter() {
		// The utility class
	}

	/**
	 * Writes the JSON content at specified file path.
	 * 
	 * @param filePath
	 *            The file path
	 */
	public static void writeJSON(String filePath, String jsonContent) {

		try {
			Path path = Paths.get(filePath);
			if (!Files.exists(path)) {
				Files.createDirectories(path.getParent());
				Files.createFile(path);
			}
			Files.write(Paths.get(filePath), jsonContent.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException ioException) {
			ioException.printStackTrace();
			System.out.println("Error: Writing to file failed.");
		}
	}
}
