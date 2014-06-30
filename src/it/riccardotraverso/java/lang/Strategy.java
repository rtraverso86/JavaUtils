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
	 * @return
	 */
	public final O execute(I input) {
		this.lastResult = apply(input);
		return this.lastResult;
	}

	/**
	 * Performs the real computation of the strategy. This method is called by
	 * execute(), which is in charge of also remembering the last value produced
	 * by apply().
	 * 
	 * @return
	 */
	protected abstract O apply(I input);

	/**
	 * Gets the latest computed result of execute().
	 * 
	 * @return
	 */
	public final O getLastResult() {
		return this.lastResult;
	}

}
