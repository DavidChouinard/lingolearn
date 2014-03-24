package cscie99.team2.lingolearn.server.spacedrepetition;

import cscie99.team2.lingolearn.shared.Deck;

public interface SpacedRepetition {	
	/**
	 * Indicates if there are cards remaining in the deck.
	 * 
	 * @return True if there are cards remaining.
	 */
	public boolean CardsRemaining();
	
	/**
	 * Get the id of the next card from the deck.
	 * 
	 * @return The next card that should be shown to the user.
	 */
	public int DrawCard();
	
	/**
	 * Shuffle the deck of cards. 
	 */
	public void ShuffleDeck();
	
	/**
	 * Set the deck that should be used by the algorithm.
	 * 
	 * @param deck The deck to be used by the algorithm.
	 */
	public void SetDeck(Deck deck);
}
