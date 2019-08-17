package com.data.preparator;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.data.preparator.modifiers.JSONModifier;
import com.data.preparator.readors.DirectoryTreeReader;
import com.data.preparator.readors.JSONReader;
import com.data.preparator.writers.JSONWriter;

/**
 * The Application
 */
public class App {

	public static void main(String[] args) {

		List<Path> jsonFilePaths = DirectoryTreeReader.getAllJsonFiles("/home/mechanic/Downloads/jsons");

		if (!jsonFilePaths.isEmpty()) {
			jsonFilePaths.forEach(path -> {
				String fileContent = JSONReader.parseJSON(path);

				if (StringUtils.isNotEmpty(fileContent)) {
					String modifiedJSON = JSONModifier.modifyJSON(fileContent);
					String fileName = path.getFileName().toString();
					JSONWriter.writeJSON("modified" + File.separator + fileName, modifiedJSON);
				} else {
					System.out.println("File empty. Path: " + path);
				}
			});
		} else {
			System.out.println("ERROR: No JSON files found.");
		}
	}
}
