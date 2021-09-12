import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputFromFile implements Input {

	@Override
	public List<String> read() throws FileNotFoundException {

		List<String> inputLineList = new ArrayList<String>();
		File file = new File("kwic.txt");
		Scanner scanner = new Scanner(file);

		while (scanner.hasNextLine()) {
			inputLineList.add(scanner.nextLine());

		}
		scanner.close();

		return inputLineList;

	}
}
