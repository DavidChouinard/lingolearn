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
	/**
	 * This tuple pairs the values that get cached by the DeckManager.
	 */
	private class ManagerTuple {
		public final Card card;
		public final Date date;
		public ManagerTuple(Card card, Date date) {
			this.card = card;
			this.date = date;
		}
	}
	
	// Singleton
	private static DeckManager instance = null;
	
	// Time (in seconds) after which a card will be removed from the active cache
	private final static int CACHE_INACTIVITY_TIME = 1;
	// Time (in seconds) after which a card will be removed from the active cache
	private final static int PERIODIC_CHECK_TIME = 1;
	
	// This HashMap acts as the actual case of the cards
	private Map<String, ManagerTuple> cache  = new HashMap<String, ManagerTuple>();

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
	 * Get the card indicated from either the data store or the local cache.  
	 * 
	 * @param uid The unique identifier of the card, this will be used as is 
	 * to check to see if the card exists in the cache.
	 * @return The card that was requested. 
	 * @throws CardNotFoundException Is thrown if the card cannot be found in
	 * the data store or local cache.
	 */
	public Card getCard (String uid) throws CardNotFoundException {
		// Is the card not in the cache?
		if (!cache.containsKey(uid)) {
			
			// TODO Get the card from the data store
			
		}
		// Update the access time
		ManagerTuple tuple = cache.get(uid);
		cache.put(uid, new ManagerTuple(tuple.card, new Date()));
		// Return the card
		return tuple.card;
	} 
}

