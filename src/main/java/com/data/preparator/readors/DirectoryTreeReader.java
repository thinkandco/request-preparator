package com.data.preparator.readors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The utility class DirectoryTreeReader. It reads the directory tree and
 * populates necessary information.
 */
public class DirectoryTreeReader {

	private DirectoryTreeReader() {
		// The utility class
	}

	/**
	 * Gets the list of all json files present in the specified base path.
	 * 
	 * @param basePath
	 *            The base path
	 * @return The list of files
	 */
	public static List<Path> getAllJsonFiles(String basePath) {

		List<Path> filePaths = new ArrayList<>();

		try (Stream<Path> paths = Files.walk(Paths.get(basePath))) {
			filePaths.addAll(paths.distinct().filter(Files::isRegularFile)
					.filter(path -> path.toString().endsWith(".json")).collect(Collectors.toList()));
		} catch (IOException ioException) {
			System.out.println("Error: Invalid base path");
		}

		return filePaths;
	}
}
