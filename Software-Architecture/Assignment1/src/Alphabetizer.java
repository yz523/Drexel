import java.util.List;

public class Alphabetizer {

	public List<String> sort(List<String> lines) {

		List<String> sortedList = lines;

		for (int leftLocation = 0; leftLocation < lines.size(); leftLocation++) {
			for (int rightLocation = leftLocation + 1; rightLocation < lines.size(); rightLocation++) {

				int charLocation = 0;
				Character firstCharOfLoweCaseLeftItem = sortedList.get(leftLocation).toLowerCase().charAt(charLocation);
				Character firstCharOfLoweCaseRightItem = sortedList.get(rightLocation).toLowerCase()
						.charAt(charLocation);

				if (firstCharOfLoweCaseLeftItem.equals(firstCharOfLoweCaseRightItem)) {
					furtherCompare(sortedList, leftLocation, rightLocation);
				}

				if (firstCharOfLoweCaseLeftItem > firstCharOfLoweCaseRightItem) {
					swap(sortedList, leftLocation, rightLocation);
				}
			}
		}

		return sortedList;

	}

	public void furtherCompare(List<String> list, int left, int right) {

		int digitLocation = 0;

		while (list.get(left).toLowerCase().charAt(digitLocation) == list.get(right).toLowerCase()
				.charAt(digitLocation)) {

			digitLocation++;

			if (list.get(left).toLowerCase().charAt(digitLocation) > list.get(right).toLowerCase()
					.charAt(digitLocation)) {
				swap(list, left, right);
			}
		}
	}

	public void swap(List<String> list, int left, int right) {

		String temporaryBuffer = list.get(left);

		list.set(left, list.get(right));
		list.set(right, temporaryBuffer);
	}
}
