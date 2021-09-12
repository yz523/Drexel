
public class EngineerFactory implements AbstractFactory {

	@Override
	public Employee create(String employeeType) {
		if (employeeType.equals("ENGINEER")) {
			return new Engineer();
		} else {
			return new Manager();
		}
	}
}
