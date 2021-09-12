
public enum SortType {

	BUBBLE {
		@Override
		public Sort getInstance() {

			return new BubbleSort();
		}
	},

	HEAP {
		@Override
		public Sort getInstance() {

			return new HeapSort();
		}
	},

	SHELL {
		@Override
		public Sort getInstance() {

			return new ShellSort();
		}
	};

	public abstract Sort getInstance();

}
