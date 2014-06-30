package it.riccardotraverso.java.lang;

public class IterableUtils {

	private IterableUtils() {
		// Not instantiable class
	}
	
	
	public static <T, O> O execute(Iterable<T> coll, Strategy<T, O> s) {
		for (T val : coll) {
			s.execute(val);
		}
		return s.getLastResult();
	}
}
