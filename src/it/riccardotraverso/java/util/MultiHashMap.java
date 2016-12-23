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
import java.util.HashSet;
import java.util.Set;



public class MultiHashMap<K, V> implements MultiMap<K, V> {
	
	private HashMap<K, HashSet<V>> container = new HashMap<K, HashSet<V>>();
	
	/* (non-Javadoc)
	 * @see it.riccardotraverso.java.util.MultiMap#get(K)
	 */
	@Override
	public Set<V> get(K key) {
		return container.get(key);
	}
	
	/* (non-Javadoc)
	 * @see it.riccardotraverso.java.util.MultiMap#put(K, V)
	 */
	@Override
	public boolean put(K key, V value) {
		HashSet<V> set = container.get(key);
		if (set == null) {
			container.put(key, set = new HashSet<V>());
		}
		return set.add(value);
	}

	@Override
	public boolean containsValue(V value) {
		for (Set<V> set : container.values()) {
			if (set.contains(value))
				return true;
		}
		return false;
	}

	@Override
	public Set<V> remove(K key) {
		return container.remove(key);
	}

	@Override
	public boolean remove(K key, V value) {
		Set<V> set = container.get(key);
		if (set == null) { return false; }
		boolean ret = set.remove(value);
		if (set.isEmpty()) {
			container.remove(key);
		}
		return ret;
	}

	@Override
	public Set<SimpleEntry<K, V>> entrySet() {
		Set<SimpleEntry<K, V>> es = new HashSet<SimpleEntry<K,V>>();
		for (HashMap.Entry<K, HashSet<V>> entry : container.entrySet()) {
			K key = entry.getKey();
			for (V value : entry.getValue()) {
				es.add(new SimpleEntry<K, V>(key, value));
			}
		}
		return es;
	}

	@Override
	public Set<K> keySet() {
		return container.keySet();
	}
}
