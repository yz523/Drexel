public class Essay extends ShortAnswer{
	
	private static final long serialVersionUID = 1;
	public Essay(boolean a){
		super(a);
	}

	public Answer setCorrectAns(){
		String[] s = {"Essay"};
		setCorrectAns(s);
		ans = new Answer(s);
		return ans;
	}
}
