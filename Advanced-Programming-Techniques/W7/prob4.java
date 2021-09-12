import java.util.Date;

public class prob4 {
	public static void main ( String[] args ) {
		int i = Integer.parseInt(args[0]);
		Date today = new Date();
		long millisec = today.getTime();

		switch (i) {
			case 0:
				System.out.println("milliseconds since Januart 1,1970: " + millisec);
				break;
			case 1:
				System.out.println("seconds since Januart 1,1970: " + millisec/1000);
				break;
			case 2:
				System.out.println("days since Januart 1,1970: " + millisec/(86400000));
				break;
			case 3:
				System.out.println("current data and time: " + today.toString());
				break;
		}
	}
}
