import java.util.Scanner;

public class ScannerWrapper {

	Scanner scanner;

	private static ScannerWrapper instance = new ScannerWrapper();

	private ScannerWrapper() {

		scanner = new Scanner(System.in);

	}

	public static ScannerWrapper getInstance() {

		return instance;

	}

	public String nextLine() {

		return scanner.nextLine();

	}
}
