package cscie99.team2.lingolearn.server;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import cscie99.team2.lingolearn.shared.Card;
import cscie99.team2.lingolearn.shared.error.CardNotFoundException;

/**
 * The purpose of this class is to improve the performance of the system while 
 * retrieving the cards from the data store. This class maintains a list of 
 * cards, currently active in the system and allows the cards to be reused by 
 * different decks. If the card is not used by any deck after a predefined 
 * period of time, it will be removed from the cache. 
 */
public class DeckManager {
	/**
	 * The standard ScheduledThreadPoolExecutor is customized here so it would be possible
	 * to process any Exceptions in the runnable task by overriding
	 * afterEcecure(r,t)
	 */
	private class CustomScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {
		/**
		 * Constructor.
		 */
		public CustomScheduledThreadPoolExecutor(int corePoolSize) {
			super(corePoolSize);
		}

		@Override
		public void afterExecute(Runnable runnable, Throwable throwable) {
			super.afterExecute(runnable, throwable);
			if (throwable == null && runnable instanceof Future<?>) {
				try {
					Future<?> future = (Future<?>) runnable;
					if (future.isDone())
						future.get();
				} catch (CancellationException ex) {
					throwable = ex;
				} catch (ExecutionException ex) {
					throwable = ex.getCause();
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
			}
			if (throwable != null) {
				// Exception occurred, forward to handler
				System.err.println("Error occured while processing Card cache entries: " + throwable);

				// TODO Periodic cache clean is not running anymore at this point, try to recover somehow?

			}
		}
	}

	/**
	 * This method iterates through the cache and removes any objects that
	 * have an access time that exceeds CACHE_INACTIVITY_TIME.
	 */
	private class CacheCleaner implements Runnable {
		@Override
		public void run() {
			Calendar now = Calendar.getInstance();
			Set<Integer> keys = cache.keySet(); 
			for (int key : keys) {
				// Check to see if the time for the current item will be before
				// the current time once the inactivity window is applied
				Calendar card = cache.get(key).date;
				card.add(Calendar.SECOND, CACHE_INACTIVITY_TIME);
				// The time is in the past, so remove the item from the cache
				if (card.before(now)) {
					cache.remove(key);
				}				
			}
		}
	}
	
	/**
	 * This tuple pairs the values that get cached	 by the DeckManager.
	 */
	private class ManagerTuple {
		public final Card card;
		public final Calendar date;
		public ManagerTuple(Card card, Calendar date) {
			this.card = card;
			this.date = date;
		}
	}
	
	// Singleton
	private static DeckManager instance = null;
	
	// The time, in seconds, that a card can be in the cache before removal 
	private final static int CACHE_INACTIVITY_TIME = 60;
	
	// The time, in seconds, when the cache is checked for inactivity
	private final static int PERIODIC_CHECK_TIME = 15;
	
	// This HashMap acts as the actual case of the cards
	private Map<Integer, ManagerTuple> cache  = new HashMap<Integer, ManagerTuple>();

	/**
	 * Default Singleton Constructor
	 */
	private DeckManager() {
		// Schedule the cleaner thread to run 
		ScheduledThreadPoolExecutor executor = new CustomScheduledThreadPoolExecutor(1);
		executor.scheduleWithFixedDelay(new CacheCleaner(), 1, PERIODIC_CHECK_TIME, TimeUnit.SECONDS);
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
	 * Get the card indicated from either the data store or the local cache.  
	 * 
	 * @param id The id of the card as it exists in the database.
	 * @return The card that was requested. 
	 * @throws CardNotFoundException Is thrown if the card cannot be found in
	 * the data store or local cache.
	 */
	public Card getCard(int id) throws CardNotFoundException {
		// Is the card not in the cache?
		if (!cache.containsKey(id)) {
			
			// TODO Get the card from the data store
			
		}
		// Update the access time
		ManagerTuple tuple = cache.get(id);
		cache.put(id, new ManagerTuple(tuple.card, Calendar.getInstance()));
		// Return the card
		return tuple.card;
	} 
}

