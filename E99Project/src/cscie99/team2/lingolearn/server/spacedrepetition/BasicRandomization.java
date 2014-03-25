package cscie99.team2.lingolearn.server.spacedrepetition;

import java.util.Collections;
import java.util.List;

import cscie99.team2.lingolearn.shared.error.SpacedRepetitionException;

/**
 * This class implements a basic randomization method, that isn't spaced
 * repetition per se.
 */
public class BasicRandomization extends SpacedRepetition {
	// The shuffled deck of cards that is drawn off of 
	private List<Long> shuffledDeck = null;
	
	@Override
	public Long DrawCard() throws SpacedRepetitionException {
		// Check for issues with the deck
		if (deck == null) {
			throw new SpacedRepetitionException("The deck has not been provided yet.");
		}
		if (shuffledDeck == null) {
			throw new SpacedRepetitionException("The deck has not been shuffled yet.");
		}
		if (shuffledDeck.size() == 0) {
			throw new SpacedRepetitionException("The deck needs to be reshuffled.");
		}
		return shuffledDeck.remove(0);
	}
	
	@Override
	public boolean CardsRemaining() {
		return (shuffledDeck.size() > 0);
	}
	
	@Override
	public void ShuffleDeck() throws SpacedRepetitionException {
		// Make sure we have a deck to work with
		if (deck == null) {
			throw new SpacedRepetitionException("The deck has not been provided yet.");
		}
		// Copy the card ids over and shuffle the deck
		shuffledDeck = deck.getCardIds();
		Collections.shuffle(shuffledDeck);
	}
}
