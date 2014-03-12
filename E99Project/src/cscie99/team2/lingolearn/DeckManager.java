/**
 * CSCIE99 TEAM 2
 */
package cscie99.team2.lingolearn;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import cscie99.team2.lingolearn.error.CardNotFoundException;

/**
 * The purpose of this class is to improve the performance of the system while 
 * retrieving the cards from the data store. This class maintains a list of 
 * cards, currently active in the system and allows the cards to be reused by 
 * different decks. If the card is not used by any deck after a predefined 
 * period of time, it will be removed from the cache. 
 */
public class DeckManager {
	// Singleton
	private static DeckManager instance = null;
	
	// Time (in seconds) after which a card will be removed from the active cache
	private final static int CACHE_INACTIVITY_TIME = 1;
	// Time (in seconds) after which a card will be removed from the active cache
	private final static int PERIODIC_CHECK_TIME = 1;
	
	
	private Map<String, Card> cardMap =
			new HashMap<String, Card>();	// Defines Map of the card objects in the active cache
											// Card Id is a unique key, non-case sensitive;
											// The key is stored in lower case.
	
	private HashMap<String, Date> lastAccessMap =
			new HashMap <String, Date>();	// Defines Map of the Card last access time
											// Card Id is a unique key, non-case sensitive;
											// The key is stored in lower case.
	
	/**
	 * Default Singleton Constructor
	 */
	private DeckManager() {
		// Initialize once only for periodical purging of the stale Card objects from the cache
		RunCacheCleaner();
	}

	/**
	 * Get an instance of the DeckManager.
	 */
	public static DeckManager getInstance() {
		if (instance == null) {
			instance = new DeckManager();
		}
		return instance;
	}
	
	/**
	 * This method utilizes the ScheduledExecutorService in order to periodically run
	 * the CacheCleaner process with the interval set by PERIODIC_CHECK_TIME.
	 * 
	 */
	private void RunCacheCleaner() {
		ScheduledThreadPoolExecutor executor = new CustomScheduledThreadPoolExecutor(1);
		executor.scheduleWithFixedDelay(new CacheCleaner(), 1, CACHE_INACTIVITY_TIME, TimeUnit.SECONDS);
	}

	/**
	 * The standard ScheduledThreadPoolExecutor is customized here so it would be possible
	 * to process any Exceptions in the runnable task by overriding
	 * afterEcecure(r,t)
	 */
	private class CustomScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {
		// Default Constructor
		public CustomScheduledThreadPoolExecutor(int corePoolSize) {
			super(corePoolSize);
		}

		@Override
		public void afterExecute(Runnable r, Throwable t) {
			super.afterExecute(r, t);
		    if (t == null && r instanceof Future<?>) {
		        try {
		          Future<?> future = (Future<?>) r;
		          if (future.isDone())
		            future.get();
		        } catch (CancellationException ce) {
		            t = ce;
		        } catch (ExecutionException ee) {
		            t = ee.getCause();
		        } catch (InterruptedException ie) {
		            Thread.currentThread().interrupt();
		        }
		      }
			if (t != null) {
				// Exception occurred, forward to handler
				System.err.println("!!! Error occured while processing Card cache entries: " + t);
				// TODO
				// Periodic cache clean is not running anymore at this point.
				// Try to recover somehow?
			}

		}
	}
	
	/**
	 * This method iterates through the lastAccessMap entries and deletes any stale records
	 * along with the corresponding Card objects from the cardMap if CACHE_INACTIVITY_TIME expires.
	 *
	 */
	private class CacheCleaner implements Runnable {
		//@Override
		public void run() {
			// TODO
		}
	}
	
	/**
	 * This method returns a Card object from the local cache if it is already
	 * there or retrieves it from the data store and place it in the local cache.
	 * Each time the Card is requested, the access time stamp is updated so
	 * non-frequently used cards will be deleted by CacheCleaner.  
	 * 
	 * @param cardId					CardId of the Card
	 * @return							Requested Card Object 
	 * @throws CardNotFoundException	If the Card can not be located in the local cache or in the Datastore
	 */
	public Card getCard (String cardId) throws CardNotFoundException {
		Card myCard = null;
		cardId = cardId.toLowerCase();
		// check the card cache, if the card is not already there,
		// retrieve it from the data store
		if (cardMap.get(cardId) == null) {
			// TODO
			// Temporary placeholder only.
			// Retrieve the card from the Datastore;
			// Process errors and throw exceptions..
			myCard = new Card();
			// Update cardMap. The key is converted to the lower case
			cardMap.put(cardId, myCard);
		} else {
			// Card is in the local cache
			myCard = cardMap.get(cardId);
		}
		// update last access time
		updateAccessTime(cardId);

		return myCard;
	} 
	
	/**
	 * Helper method to update the last access time of the card in the cache  
	 * @param cardId
	 */
	private void updateAccessTime (String cardId) {
		// TODO
	}
}

