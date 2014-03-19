package cscie99.team2.lingolearn.server.spacedrepetition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import cscie99.team2.lingolearn.shared.error.SpacedRepetitionException;

/**
 * This factory returns objects that implement the SpacedRepetition interface.
 */
public class SpacedRepetitionFactory {
	
	private final static String ERROR_MESSAGE = "An error occured creating the object of type ";
	
	/**
	 * 
	 * @param name
	 * @return
	 * @throws SpacedRepetitionException 
	 */
	public static SpacedRepetition getSpacedRepetition(String name) throws SpacedRepetitionException {
		try {
			Class<?> cls = Class.forName(name);
			Constructor<?> constructor = cls.getConstructor();
			Object object = constructor.newInstance();
			return (SpacedRepetition)object;
		} catch (ClassNotFoundException ex) {
			throw new SpacedRepetitionException(ERROR_MESSAGE + name, ex);
		} catch (NoSuchMethodException ex) {
			throw new SpacedRepetitionException(ERROR_MESSAGE + name, ex);
		} catch (SecurityException ex) {
			throw new SpacedRepetitionException(ERROR_MESSAGE + name, ex);
		} catch (InstantiationException ex) {
			throw new SpacedRepetitionException(ERROR_MESSAGE + name, ex);
		} catch (IllegalAccessException ex) {
			throw new SpacedRepetitionException(ERROR_MESSAGE + name, ex);
		} catch (IllegalArgumentException ex) {
			throw new SpacedRepetitionException(ERROR_MESSAGE + name, ex);
		} catch (InvocationTargetException ex) {
			throw new SpacedRepetitionException(ERROR_MESSAGE + name, ex);
		}		
	}
}
