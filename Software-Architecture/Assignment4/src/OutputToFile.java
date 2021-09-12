import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputToFile implements Output {

	@Override
	public void write(List<String> lines) throws IOException {

		FileWriter fileWriter = new FileWriter("kwic_output.txt");

		for (String line : lines) {

			fileWriter.write(line);
			fileWriter.write("\n");

		}

		fileWriter.close();

	}
}
