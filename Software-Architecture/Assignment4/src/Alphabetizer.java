import java.util.List;

public class Alphabetizer {

	public List<String> sort(List<String> lines) {

		List<String> sortedList = lines;

		for (int leftLocation = 0; leftLocation < lines.size(); leftLocation++) {

			for (int rightLocation = leftLocation + 1; rightLocation < lines.size(); rightLocation++) {

				if (compareChars(sortedList, leftLocation, rightLocation)) {

					swap(sortedList, leftLocation, rightLocation);

				}
			}
		}

		return sortedList;
	}

	public boolean compareChars(List<String> list, int leftLocation, int rightLocation) {

		int digitLocation = 0;

		if (getLowerCaseCharAt(list, leftLocation, digitLocation) > getLowerCaseCharAt(list, rightLocation,
				digitLocation)) {

			return true;

		}

		else {

			while (getLowerCaseCharAt(list, leftLocation, digitLocation) == getLowerCaseCharAt(list, rightLocation,
					digitLocation)) {

				digitLocation++;

				if (getLowerCaseCharAt(list, leftLocation, digitLocation) > getLowerCaseCharAt(list, rightLocation,
						digitLocation)) {

					return true;

				}
			}
		}

		return false;

	}

	public Character getLowerCaseCharAt(List<String> list, int listLocation, int digitLocation) {

		Character resultChar = list.get(listLocation).toLowerCase().charAt(digitLocation);

		return resultChar;

	}

	public void swap(List<String> list, int left, int right) {

		String temporaryBuffer = list.get(left);

		list.set(left, list.get(right));
		list.set(right, temporaryBuffer);

	}
}
