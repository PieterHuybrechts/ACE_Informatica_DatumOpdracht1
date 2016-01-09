package database;

/**
 * 
 * @author Sven Noreillie
 *
 */

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import common.DBException;
import common.DBMissingException;
import model.ModelBase;

public interface DataService<T extends ModelBase> {
	/**
	 * Fetches all items from a database without filtering 
	 * @return a List of all items specified by the generic type
	 * @throws DBMissingException
	 * @throws DBException
	 */
	List<T> getAll() throws DBMissingException, DBException;

	/**
	 * Fetch an item by id
	 * @param id
	 * @return a specific item that matches the given id if found
	 * @throws NoSuchElementException
	 * @throws DBMissingException
	 * @throws DBException
	 */
	T get(int id) throws NoSuchElementException, DBMissingException, DBException;

	/**
	 * Add an item to the database
	 * @param entity
	 * @throws DBMissingException
	 * @throws DBException
	 */
	void add(ModelBase entity) throws DBMissingException, DBException;
	
	/**
	 * Add a collection of items to the database
	 * @param entities
	 * @throws DBMissingException
	 * @throws DBException
	 */
	void addAll(List<? extends ModelBase> entities) throws DBMissingException, DBException;
	
	/**
	 * Add an item to the database
	 * @param entity
	 * @throws DBMissingException
	 * @throws DBException
	 */
	void update(T entity) throws DBMissingException, DBException;

	/**
	 * Removes an item from the database
	 * @param entity
	 * @throws DBMissingException
	 * @throws DBException
	 */
	void remove(T entity) throws DBMissingException, DBException;

	/**
	 * Gets a list of T using a predicate to filter
	 * @param predicate to filter on
	 * @return filtered list of T
	 * @throws NoSuchElementException
	 * @throws DBMissingException
	 * @throws DBException
	 */
	List<T> getFiltered(Predicate<? super T> predicate) throws NoSuchElementException, DBMissingException, DBException;
}
