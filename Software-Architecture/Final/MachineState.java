
interface MachineState {

	public double penny = 0;
	public double nickel = 0;
	public double dime = 0;
	public double quarter = 0;

	default double getCurrentDeposite() {

		return 0;

	}

	default void getDeposite(ScannerWrapper scannerWrapper) {

	}

	default void buildCookie(ScannerWrapper scannerWrapper) {

	}

	default void getCookiePrice(Cookie cookie) {

	}

	default void calculateRefund(Cookie cookie) {

	}

	default void calculateDenominations(int refund) {

	}

}
