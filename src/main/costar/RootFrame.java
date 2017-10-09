package costar;

final class RootFrame {

	private static final RootFrame INSTANCE = new RootFrame();

	public static RootFrame getInstance() {
		return INSTANCE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public RootFrame clone() {
		return this;
	}

	private RootFrame() {
	}

}