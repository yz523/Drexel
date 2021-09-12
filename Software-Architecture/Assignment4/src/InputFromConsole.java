import java.util.ArrayList;
import java.util.List;

public class InputFromConsole implements Input {

	ScannerWrapper scannerWrapper;
	SystemWrapper systemWrapper;

	public InputFromConsole(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) {

		this.scannerWrapper = scannerWrapper;
		this.systemWrapper = systemWrapper;

	}

	@Override
	public List<String> read() {

		systemWrapper.println("Please enter lines to add, then enter -1 to finish:");

		List<String> inputLineList = new ArrayList<String>();
		String inputLine = scannerWrapper.nextLine();

		while (!inputLine.equals("-1")) {

			inputLineList.add(inputLine);
			inputLine = scannerWrapper.nextLine();

		}

		return inputLineList;
	}
}
