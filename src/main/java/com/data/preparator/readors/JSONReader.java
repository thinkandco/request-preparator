package com.data.preparator.readors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.commons.lang3.StringUtils;

/**
 * The utility class JSONParser. It parses the JSON from file present at
 * specified path.
 */
public class JSONReader {

	private JSONReader() {
		// The utility class
	}

	/**
	 * Parses the JSON from file present at specified path.
	 * 
	 * @param filePath
	 *            the file path
	 * @return The JSON content
	 */
	public static String parseJSON(Path filePath) {

		try {
			return new String(Files.readAllBytes(filePath));
		} catch (IOException ioException) {
			System.out.println("Error: Invalid file path or file have no read permissions. File: " + filePath);
		}
		return StringUtils.EMPTY;
	}
}
