package cscie99.team2.lingolearn.server.datastore;

import static cscie99.team2.lingolearn.server.datastore.OfyService.ofy;
import cscie99.team2.lingolearn.server.datastore.ObjectifyableCard;
import cscie99.team2.lingolearn.server.datastore.ObjectifyableImage;
import cscie99.team2.lingolearn.shared.Card;
import cscie99.team2.lingolearn.shared.Image;

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
	
	public Card getCardByKanji(String kanji) {
		ObjectifyableCard oCard = ofy().load().type(ObjectifyableCard.class).filter("kanji", kanji).first().now();
		Card card = oCard.getCard();
		return card;
	}
	
	public Card getCardByEnTranslation(String eng) {
		ObjectifyableCard oCard = ofy().load().type(ObjectifyableCard.class).filter("enTransation", eng).first().now();
		Card card = oCard.getCard();
		return card;
	}

}
