package cscie99.team2.lingolearn.server.spacedrepetition;

public interface SpacedRepetition {	
	/**
	 * Get the id of the next card from the deck.
	 * 
	 * @return The next card that should be shown to the user.
	 */
	public int DrawCard();
}
