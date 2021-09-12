
public class FactoryProducer {

	public AbstractFactory getFactory(boolean isManager) {
		if (isManager) {
			return new ManagerFactory();
		} else {
			return new EngineerFactory();
		}
	}

}
