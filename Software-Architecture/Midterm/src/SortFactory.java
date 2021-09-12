
public class SortFactory {

	public SortFactory() {

	}

	public Sort create(String choice) {

		SortType type = SortType.valueOf(choice);
		return type.getInstance();

	}
}
