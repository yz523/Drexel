import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MasterControl {

	public static void main(String[] args) throws IOException {

		MasterControl masterControl = new MasterControl();
		masterControl.start(ScannerWrapper.getInstance(), SystemWrapper.getInstance());

	}

	public void start(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) throws FileNotFoundException {

		String inputMethod = "";
		String outputMethod = "";

		inputMethod = selectInput(scannerWrapper, systemWrapper);
		outputMethod = selectOutput(scannerWrapper, systemWrapper);

		List<String> inputList = new ArrayList<String>();

		inputList = inputBasedOnSelection(inputMethod, scannerWrapper, systemWrapper);

		CircularShifter circularShifter = new CircularShifter();
		List<String> shiftedList = new ArrayList<String>();
		shiftedList = circularShifter.shiftLines(inputList);

		Alphabetizer alphabetizer = new Alphabetizer();
		List<String> sortedList = new ArrayList<String>();
		sortedList = alphabetizer.sort(shiftedList);

		outputBasedOnSelection(outputMethod, sortedList, scannerWrapper, systemWrapper);

	}

	public String selectInput(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) {

		systemWrapper.println("Please enter FILE to input from file or CONSOLE to input from console:");
		String userInput = scannerWrapper.nextLine();

		if (userInput.equals("FILE")) {
			return "FILE";
		} else {
			return "CONSOLE";

		}
	}

	public String selectOutput(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) {

		systemWrapper.println("Please enter FILE to output from file or CONSOLE to output from console:");
		String userInput = scannerWrapper.nextLine();

		if (userInput.equals("FILE")) {
			return "FILE";
		} else {
			return "CONSOLE";

		}
	}

	public List<String> inputBasedOnSelection(String inputMethod, ScannerWrapper scannerWrapper,
			SystemWrapper systemWrapper) throws FileNotFoundException {

		List<String> inputList = new ArrayList<String>();

		Input input;

		if (inputMethod.equals("FILE")) {

			input = new InputFromFile();

		} else {

			input = new InputFromConsole(scannerWrapper, systemWrapper);

		}

		inputList = input.read();

		return inputList;
	}

	public void outputBasedOnSelection(String outputMethod, List<String> sortedList, ScannerWrapper scannerWrapper,
			SystemWrapper systemWrapper) {

		Output output;

		if (outputMethod.equals("FILE")) {

			output = new OutputToFile();

		} else {

			output = new OutputToConsole(systemWrapper);

		}

		try {

			output.write(sortedList);

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
}
