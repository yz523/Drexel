
public class OutputFactory {

	SystemWrapper systemWrapper;

	public OutputFactory(SystemWrapper systemWrapper) {

		this.systemWrapper = systemWrapper;

	}

	public Output create(String choice) {

		if (!choice.equals("FILE") && !choice.equals("CONSOLE")) {

			throw new IllegalArgumentException("invalid");

		} else {

			OutputType outputType = OutputType.valueOf(choice);
			return outputType.getInstance(systemWrapper);

		}
	}
}
