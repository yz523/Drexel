
abstract class Cookie {

	boolean raisins;
	boolean walnuts;
	boolean chocolate_chips;

	boolean hasRaisins() {
		return false;
	}

	boolean hasWalnuts() {
		return false;
	}

	boolean hasChocolate_chips() {
		return false;
	}

	double getRaisinsPrice() {
		return 0;
	}

	double getWalnutsPrice() {
		return 0;
	}

	double getChocolate_chipsPrice() {
		return 0;
	}

	static abstract class AbstractBuilder {

		Cookie cookie;

		AbstractBuilder raisins(boolean b) {
			return null;

		}

		AbstractBuilder walnuts(boolean b) {
			return null;

		}

		AbstractBuilder chocolate_chips(boolean b, int darkLevel) {
			validateDarkLevel(darkLevel);
			return null;

		}

		Cookie build() {

			return cookie;

		}
	}

	abstract double calculatePrice();

	private static void validateDarkLevel(int darkLevel) {

	}
}
