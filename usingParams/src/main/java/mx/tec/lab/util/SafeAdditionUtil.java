package mx.tec.lab.util;

public class SafeAdditionUtil {
	public int safeAdd(final int a, final int b) {
		long result = ((long) a) + b;
		if (result > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else if (result < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		} else {
			return (int) result;
		}
	}
}
