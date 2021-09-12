
public class MachineContext {

	private MachineState machineState;

	MachineContext() {

		machineState = new DepositeState();

	}

	void nextState(MachineState machineState) {

	}

	private boolean meetMinimumInput(double input) {
		return false;
	}

	private boolean isLargerThanOnePointFiveDeposite(double deposite) {
		return false;
	}

	private boolean isCanceled(ScannerWrapper scannerWrapper) {
		return false;
	}
}
