public class Answer implements java.io.Serializable{

	private static final long serialVersionUID = 1;
	private String[] answer;
	
	public Answer(String[] a){
		setAnswer(a);	
	}
	
	public void setAnswer(String[] a){
		answer = a;
	}
	
	public String[] getAnswer(){
		return answer;
	}
	
	public void setSpecAns(int i, String s){
		answer[i] = s;
	}

}
