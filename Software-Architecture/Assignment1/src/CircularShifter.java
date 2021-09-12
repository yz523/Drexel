import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircularShifter {

	public List<String> shiftLines(List<String> lines) {

		List<String> shiftedList = new ArrayList<String>();

		for (int lineLocation = 0; lineLocation < lines.size(); lineLocation++) {
			List<String> wordList = new ArrayList<String>(Arrays.asList(lines.get(lineLocation).split(" ")));

			for (int wordCount = 0; wordCount < wordList.size(); wordCount++) {
				String shiftedLine = "";

				for (String word : wordList) {
					shiftedLine += word + " ";
				}

				shiftedList.add(shiftedLine.trim());
				String first = wordList.get(0);
				wordList.remove(0);
				wordList.add(first);

			}
		}

		return shiftedList;

	}
}
