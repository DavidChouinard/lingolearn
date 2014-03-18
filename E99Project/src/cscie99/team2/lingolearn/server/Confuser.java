package cscie99.team2.lingolearn.server;

import cscie99.team2.lingolearn.shared.error.ConfuserException;

public class Confuser {
	/**
	 * The various character types that are recognized by the confuser algorithm
	 */
	public enum CharacterType {
		Unknown,
		Hiragana,
		Katakana,
		Kanji
	}
	
	/**
	 * 
	 * @param character
	 * @return
	 * @throws ConfuserException 
	 */
	public static CharacterType checkCharacter(String character) throws ConfuserException {
		// Make sure we are only working with a single character
		if (character.length() != 1) {
			throw new ConfuserException("The character string is an invalid length.");
		}		

		// TODO Check to see if this is a hiragana
		
		// TODO Check to see if this is a katakana
		
		// TODO Check to see if this is kanji


		// Fall through to unknown
		return CharacterType.Unknown;
	}
}
