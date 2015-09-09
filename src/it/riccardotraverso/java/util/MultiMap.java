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
import java.util.Set;

/**
 * A multimap is a map associating multiple values to a single key.  
 * 
 * @author Riccardo Traverso
 *
 * @param <K> The type of the keys
 * @param <V> The type of the values
 */
public interface MultiMap<K, V> {

	public abstract boolean containsValue(V value);
	
	public abstract Set<V> get(K key);

	public abstract boolean put(K key, V value);
	
	public abstract Set<V> remove(K key);
	
	public abstract boolean remove(K key, V value);
	
	public abstract Set<SimpleEntry<K, V>> entrySet();
	
	public abstract Set<K> keySet();

}