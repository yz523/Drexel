
public class OutputFactory {

	SystemWrapper systemWrapper;

	public OutputFactory(SystemWrapper systemWrapper) {

		this.systemWrapper = systemWrapper;

	}

	public Output create(String choice) {

		OutputType outputType = OutputType.valueOf(choice);
		return outputType.getInstance(systemWrapper);
	}

}
