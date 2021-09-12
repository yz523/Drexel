
public enum OutputType {

	COMMA {
		@Override
		public Output getInstance(SystemWrapper systemWrapper) {

			return null;
		}
	},

	TAB {
		@Override
		public Output getInstance(SystemWrapper systemWrapper) {

			return null;
		}
	},

	OTHER {
		@Override
		public Output getInstance(SystemWrapper systemWrapper) {

			return null;
		}
	};

	public abstract Output getInstance(SystemWrapper systemWrapper);

}
