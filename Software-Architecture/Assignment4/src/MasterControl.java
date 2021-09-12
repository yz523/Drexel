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

		InputFactory inputFactory = new InputFactory(scannerWrapper, systemWrapper);
		Input input = inputFactory.create(inputMethod);
		inputList = input.read();

		CircularShifter circularShifter = new CircularShifter();
		List<String> shiftedList = new ArrayList<String>();
		shiftedList = circularShifter.shiftLines(inputList);

		Alphabetizer alphabetizer = new Alphabetizer();
		List<String> sortedList = new ArrayList<String>();
		sortedList = alphabetizer.sort(shiftedList);

		OutputFactory outputFactory = new OutputFactory(systemWrapper);
		Output output = outputFactory.create(outputMethod);
		try {

			output.write(sortedList);

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public String selectInput(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) {

		systemWrapper.println("Please enter FILE to input from file or CONSOLE to input from console:");
		String userInput = scannerWrapper.nextLine();
		return userInput;

	}

	public String selectOutput(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) {

		systemWrapper.println("Please enter FILE to output from file or CONSOLE to output from console:");
		String userInput = scannerWrapper.nextLine();
		return userInput;

	}
}
