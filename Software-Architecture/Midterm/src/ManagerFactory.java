
public class ManagerFactory implements AbstractFactory {

	@Override
	public Employee create(String employeeType) {
		if (employeeType.equals("MANAGER")) {
			return new Manager();

		} else {
			return new Engineer();
		}
	}

}
