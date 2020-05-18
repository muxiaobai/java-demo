package io.github.muxiaobai.java.java.exception;

// Overridden methods may throw only the exceptions
// specified in their base-class versions, or exceptions
// derived from the base-class exceptions.

class BaseballException extends Exception {
	private static final long serialVersionUID = 1L;
}

class Strike extends BaseballException {
	private static final long serialVersionUID = 1L;
}

class Foul extends BaseballException {
	private static final long serialVersionUID = 1L;
}

class StormException extends Exception {
	private static final long serialVersionUID = 1L;
}

class RainedOut extends StormException {
	private static final long serialVersionUID = 1L;
}

class PopFoul extends Foul {
	private static final long serialVersionUID = 1L;
}

abstract class Inning {
	public Inning() throws BaseballException {
	}

	public void event() throws BaseballException {
		// Doesn't actually have to throw anything
	}

	public abstract void atBat() throws Strike, Foul;

	public void walk() {
	} // Throws no checked exceptions
}

interface Storm {
	public void event() throws RainedOut;

	public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {
	public static void main(String[] args) {
		try {
			StormyInning si = new StormyInning();
			si.atBat();
		} catch (PopFoul e) {
			System.out.println("Pop foul");
		} catch (RainedOut e) {
			System.out.println("Rained out");
		} catch (BaseballException e) {
			System.out.println("Generic baseball exception");
		}
		// Strike not thrown in derived version.
		try {
			// What happens if you upcast?
			Inning i = new StormyInning();
			i.atBat();
			// You must catch the exceptions from the
			// base-class version of the method:
		} catch (Strike e) {
			System.out.println("Strike");
		} catch (Foul e) {
			System.out.println("Foul");
		} catch (RainedOut e) {
			System.out.println("Rained out");
		} catch (BaseballException e) {
			System.out.println("Generic baseball exception");
		}
	}

	// OK to add new exceptions for constructors, but you
	// must deal with the base constructor exceptions:
	public StormyInning() throws RainedOut, BaseballException {
		//throw new RainedOut();
		//throw new BaseballException();
	}

	public StormyInning(String s) throws Foul, BaseballException {
	}

	// Regular methods must conform to base class:
	// ! void walk() throws PopFoul {} //Compile error
	// Interface CANNOT add exceptions to existing
	// methods from the base class:
	// ! public void event() throws RainedOut {}
	// If the method doesn't already exist in the
	// base class, the exception is OK:
	public void rainHard() throws RainedOut {
		throw new RainedOut();
	}

	// You can choose to not throw any exceptions,
	// even if the base version does:
	public void event() {
	}

	// Overridden methods can throw inherited exceptions:
	public void atBat() throws PopFoul {
		throw new PopFoul();
	}

}
