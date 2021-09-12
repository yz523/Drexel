import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MasterControl {

	public static void main(String[] args) throws IOException {

		MasterControl masterControl = new MasterControl();
		masterControl.start(ScannerWrapper.getInstance(), SystemWrapper.getInstance());

	}

	public void start(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) {

		Input input = new Input();
		List<String> inputList = new ArrayList<String>();
		inputList = input.read(scannerWrapper, systemWrapper);

		CircularShifter circularShifter = new CircularShifter();
		List<String> shiftedList = new ArrayList<String>();
		shiftedList = circularShifter.shiftLines(inputList);

		Alphabetizer alphabetizer = new Alphabetizer();
		List<String> sortedList = new ArrayList<String>();
		sortedList = alphabetizer.sort(shiftedList);

		Output output = new Output();
		output.write(sortedList, systemWrapper);

	}
}
