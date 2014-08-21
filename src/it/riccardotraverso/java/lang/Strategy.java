/*
 * Copyright (C) 2014 Riccardo Traverso
 * 
 * This file is part of JavaUtils
 * Website: https://github.com/rtraverso86/JavaUtils
 * 
 * JavaUtils is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * JavaUtils is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package it.riccardotraverso.java.lang;

public abstract class Strategy<I, O> {

	protected O lastResult;

	public Strategy(O firstResult) {
		this.lastResult = firstResult;
	}

	/**
	 * Executes the strategy on the given input.
	 * 
	 * @param input
	 */
	public final O execute(I input) {
		this.lastResult = apply(input);
		return this.lastResult;
	}

	/**
	 * Performs the real computation of the strategy. This method is called by
	 * execute(), which is in charge of also remembering the last value produced
	 * by apply().
	 */
	protected abstract O apply(I input);

	/**
	 * Gets the latest computed result of execute().
	 */
	public final O getLastResult() {
		return this.lastResult;
	}

}
