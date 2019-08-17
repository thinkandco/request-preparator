package com.data.preparator.modifiers;

import java.util.UUID;

/**
 * The utility class JSONModifier.
 */
public class JSONModifier {

	private JSONModifier() {
		// The utility class
	}

	/**
	 * Replaces the place holders in JSON content with some random generated values.
	 * 
	 * @param The
	 *            original JSON content
	 * @return The modified JSON content
	 */
	public static String modifyJSON(String original) {

		String uuid = UUID.randomUUID().toString();
		return original.replaceAll("ChangeThisFieldWithUUID", uuid);
	}
}
