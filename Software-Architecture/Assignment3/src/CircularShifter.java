import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircularShifter {

	public List<String> shiftLines(List<String> lines) {

		List<String> shiftedList = new ArrayList<String>();

		for (int lineLocation = 0; lineLocation < lines.size(); lineLocation++) {

			List<String> wordList = splitWords(lines, lineLocation);

			replicateWords(shiftedList, wordList);
		}

		return shiftedList;

	}

	public List<String> splitWords(List<String> lines, int lineLocation) {

		List<String> wordList = new ArrayList<String>(Arrays.asList(lines.get(lineLocation).split(" ")));

		return wordList;

	}

	public void replicateWords(List<String> shiftedList, List<String> wordList) {

		for (int wordCount = 0; wordCount < wordList.size(); wordCount++) {

			String shiftedLine = "";
			shiftedLine = combineWords(shiftedList, wordList);
			shiftedList.add(shiftedLine.trim());
			moveWords(wordList);

		}
	}

	public String combineWords(List<String> shiftedList, List<String> wordList) {

		String shiftedLine = "";

		for (String word : wordList) {

			shiftedLine += word + " ";

		}

		return shiftedLine;
	}

	public void moveWords(List<String> wordList) {

		String firstWord = wordList.get(0);
		wordList.remove(0);
		wordList.add(firstWord);

	}
}
