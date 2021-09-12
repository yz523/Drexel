import java.io.IOException;
import java.util.List;

public interface Output {

	public void write(List<String> lines) throws IOException;

}
