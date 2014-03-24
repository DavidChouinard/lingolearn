package cscie99.team2.lingolearn.server.datastore;

import static cscie99.team2.lingolearn.server.datastore.OfyService.ofy;
import cscie99.team2.lingolearn.server.datastore.ObjectifyableCard;
import cscie99.team2.lingolearn.server.datastore.ObjectifyableImage;
import cscie99.team2.lingolearn.shared.Card;
import cscie99.team2.lingolearn.shared.Image;
import cscie99.team2.lingolearn.shared.error.CardNotFoundException;

public class CardDAO {

	/**
	 * SingletonHolder is loaded on the first execution of Singleton.getInstance() 
	 * or the first access to SingletonHolder.INSTANCE, not before.
	 */
	private static class CardDAOHolder { 
		public static final CardDAO INSTANCE = new CardDAO();
	}

	public static CardDAO getInstance() {
		return CardDAOHolder.INSTANCE;
	}   
	
	public Card storeCard( Card card ) {
		ofy().save().entity(new ObjectifyableCard(card)).now();
		return card;	
	}
	
	/**
	 * Obtains first available card with specified kanji in the datastore
	 * @param kanji in as the search parameter
	 * @return Card with the requested kanji
	 * @throws CardNotFoundException 
	 */
	public Card getCardByKanji(String kanji) throws CardNotFoundException {
		ObjectifyableCard oCard = ofy().load().type(ObjectifyableCard.class).filter("kanji", kanji).first().now();
		if (oCard==null)
			throw new CardNotFoundException("Card was not found in the datastore.");
		else {
			Card card = oCard.getCard();
			return card;
		}
	}

	/**
	 * Obtains first available card with specified hiragana in the datastore
	 * @param hiragana in as the search parameter
	 * @return Card with the requested hiragana
	 * @throws CardNotFoundException 
	 */
	public Card getCardByHiragana(String hiragana) throws CardNotFoundException {
		ObjectifyableCard oCard = ofy().load().type(ObjectifyableCard.class).filter("hiragana", hiragana).first().now();
		if (oCard==null)
			throw new CardNotFoundException("Card was not found in the datastore.");
		else {
			Card card = oCard.getCard();
			return card;
		}
	}
	
	/**
	 * Obtains first available card with specified katakana in the datastore
	 * @param katakana in as the search parameter
	 * @return Card with the requested katakana
	 * @throws CardNotFoundException 
	 */
	public Card getCardByKatakana(String katakana) throws CardNotFoundException {
		ObjectifyableCard oCard = ofy().load().type(ObjectifyableCard.class).filter("katakana", katakana).first().now();
		if (oCard==null)
			throw new CardNotFoundException("Card was not found in the datastore.");
		else {
			Card card = oCard.getCard();
			return card;
		}
	}
	
	/**
	 * Obtains first available card with specified translation in the datastore
	 * @param translation in as the search parameter
	 * @return Card with the requested translation
	 * @throws CardNotFoundException 
	 */
	public Card getCardByTranslation(String translation) throws CardNotFoundException {
		ObjectifyableCard oCard = ofy().load().type(ObjectifyableCard.class).filter("transation", translation).first().now();
		if (oCard==null)
			throw new CardNotFoundException("Card was not found in the datastore.");
		else {
			Card card = oCard.getCard();
			return card;
		}
	}
	
	/**
	 *  *** Temp **
	 * Obtains first available card with specified enTranslation in the datastore
	 * @param translation in as the search parameter
	 * @return Card with the requested translation
	 * @throws CardNotFoundException 
	 */
	public Card getCardByEnTranslation(String eng) throws CardNotFoundException {
		ObjectifyableCard oCard = ofy().load().type(ObjectifyableCard.class).filter("enTransation", eng).first().now();
		if (oCard==null)
			throw new CardNotFoundException("Card was not found in the datastore.");
		else {
			Card card = oCard.getCard();
			return card;
		}
	}
	
	/**
	 * Obtains first available card with specified description in the datastore
	 * @param description in as the search parameter
	 * @return Card with the requested description
	 * @throws CardNotFoundException 
	 */
	public Card getCardByDescription(String desc) throws CardNotFoundException {
		ObjectifyableCard oCard = ofy().load().type(ObjectifyableCard.class).filter("description", desc).first().now();
		if (oCard==null)
			throw new CardNotFoundException("Card was not found in the datastore.");
		else {
			Card card = oCard.getCard();
			return card;}
	}

}
