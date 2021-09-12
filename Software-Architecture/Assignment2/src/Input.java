import java.util.ArrayList;
import java.util.List;

public class Input {

	public List<String> read(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) {

		List<String> inputLineList = new ArrayList<String>();
		String inputLine = scannerWrapper.nextLine();

		systemWrapper.println("Please enter lines to add, then enter -1 to finish:");
		systemWrapper.println("\n");

		while (!inputLine.equals("-1")) {

			inputLineList.add(inputLine);
			inputLine = scannerWrapper.nextLine();

		}

		return inputLineList;

	}
}
