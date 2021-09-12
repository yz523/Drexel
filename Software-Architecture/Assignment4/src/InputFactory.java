public class InputFactory {

	ScannerWrapper scannerWrapper;
	SystemWrapper systemWrapper;

	public InputFactory(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) {

		this.scannerWrapper = scannerWrapper;
		this.systemWrapper = systemWrapper;

	}

	public Input create(String choice) {

		switch (choice) {

		case "CONSOLE":

			InputFromConsole inputFromConsole = new InputFromConsole(scannerWrapper, systemWrapper);
			return inputFromConsole;

		case "FILE":

			InputFromFile inputFromFile = new InputFromFile();
			return inputFromFile;

		default:

			throw new IllegalArgumentException("invalid");

		}
	}
}
