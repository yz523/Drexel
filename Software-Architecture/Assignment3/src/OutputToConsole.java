import java.util.List;

public class OutputToConsole implements Output {

	SystemWrapper systemWrapper;

	public OutputToConsole(SystemWrapper systemWrapper) {

		this.systemWrapper = systemWrapper;

	}

	@Override
	public void write(List<String> lines) {

		for (String line : lines) {

			systemWrapper.println(line);

		}
	}
}
