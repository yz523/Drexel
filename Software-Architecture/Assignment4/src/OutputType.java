
public enum OutputType {

	CONSOLE {
		@Override
		public Output getInstance(SystemWrapper systemWrapper) {

			return new OutputToConsole(systemWrapper);
		}
	},

	FILE {
		@Override
		public Output getInstance(SystemWrapper systemWrapper) {

			return new OutputToFile();
		}
	};

	public abstract Output getInstance(SystemWrapper systemWrapper);

}
