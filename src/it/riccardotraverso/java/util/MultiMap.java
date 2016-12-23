/*
 * Copyright (C) 2014 Riccardo Traverso
 * 
 * This file is part of JavaUtils
 * Website: https://github.com/rtraverso86/JavaUtils
 * 
 * JavaUtils is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * JavaUtils is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package it.riccardotraverso.java.util;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Set;

/**
 * A multimap is a map associating multiple values to a single key. The class
 * {@link MultiHashMap} provides an implementation via {@link HashMap}s to this
 * class.
 * 
 * @param <K>
 *            The type of the keys
 * @param <V>
 *            The type of the values
 * 
 * @see MultiHashMap
 */
public interface MultiMap<K, V> {

	/**
	 * Returns true if and only if the given value is associated to some key.
	 * 
	 * @param value
	 */
	public abstract boolean containsValue(V value);

	/**
	 * Gets the set of values associated to a given key, or null if the key
	 * doesn't exist.
	 * 
	 * @param key
	 */
	public abstract Set<V> get(K key);

	/**
	 * Puts a value associated to a given key.
	 * 
	 * @param key
	 * @param value
	 * @return true if the set associated to the key did not already contain the
	 *         given value
	 */
	public abstract boolean put(K key, V value);
	
	/**
	 * Removes the whole set of values associated to a key.
	 * 
	 * @param key
	 * @return the set of values just removed
	 */
	public abstract Set<V> remove(K key);
	
	/**
	 * Removes a single given value from those associated to a key.
	 * 
	 * @param key
	 * @param value
	 * @return true if the value was associated to the given key
	 */
	public abstract boolean remove(K key, V value);
	
	/**
	 * Returns a the set of all {@code <key, value>} pairs contained in the
	 * {@link MultiMap}.
	 */
	public abstract Set<SimpleEntry<K, V>> entrySet();
	
	/**
	 * Returns the set of all keys contained in the {@link MultiMap}.
	 */
	public abstract Set<K> keySet();

}