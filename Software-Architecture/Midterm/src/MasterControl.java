
public class MasterControl {

	public static void main(String[] args) {

		MasterControl masterControl = new MasterControl();
		masterControl.start();

	}

	public void start() {
		Employee employee = null;
		FactoryProducer factoryProducer = new FactoryProducer();
		factoryProducer.getFactory(true);
		AbstractFactory af = null;
		af.create(null);
		employee.getBonuses();
		HeapSort hs = new HeapSort();
		hs.sort();
		BubbleSort bs = new BubbleSort();
		bs.sort();
		ShellSort ss = new ShellSort();
		ss.sort();
		Report report = new Report();
		report.reportStatistics(0, 0, 0);
	}
}
