import java.util.Arrays;

public class Multiple extends Question implements java.io.Serializable{
	
	private static final long serialVersionUID = 1;
	protected String[] option;
	protected Answer ans;
	
	public Multiple(){}
	
	public Multiple(boolean a){
		super(a);
		setOptions();
		setCorrectAns();
	}
	
	
	public void setOpt(int i, String s){
		option[i] = s;
	}
	
	protected void setOptions(){
		System.out.println("How many choices?");
		int i = Check.PosInt();
		option = Check.MultipleAnsW("choice", i, i, false);
	}

	public void setCorrectAns(String[] s){
		ans = new Answer(s);
	}
	
	public Answer getCorrectAnswer(){
		return ans;
	}
	
	private String getChar(int i) {
	    return i > 0 && i < 27 ? String.valueOf((char)(i + 'A' - 1)) : null;
	}

	public void display(){
		System.out.println(getPrompt());
		for(int i = 0; i < option.length; i++){
			System.out.println(getChar(i+1)+") "+option[i]);
		}
	}
	
	public Answer setCorrectAns() {
		getIsSurvey();
		if (isSurvey == true){
			ans = null;
			return ans;
		} else {
			System.out.println("Enter Correct Answer, \n");
			for (int i = 0; i < option.length; i++){
				System.out.println((i+1)+") "+option[i]);
			}
			String[] t = {option[Check.IntRange(1, option.length)-1]};
			setCorrectAns(t);
			ans = new Answer(t);
			return ans;
		}
	}
	
	public Answer answerQuestion() {
		display();
		String[] s;
		if (getMinAnswerSize()==getMaxAnswerSize()){
			s = Check.MultipleAnsN("answer",getMinAnswerSize(),getMaxAnswerSize(), option.length,false);
		}
		else {
			s = Check.MultipleAnsN("answer",getMinAnswerSize(),getMaxAnswerSize(), option.length,true);
		}
		String[] a = Arr.stoval(s,option);
		Arrays.sort(a);
		Answer ans = new Answer(a);
		return ans;
	}
	
	public void modifyChoices(){
		int c;
			display();
			System.out.println("Which choice do you want to modify? ");
			c = Check.IntRange(0, option.length);
			if (c!=0){
				String s = Check.StringIn("Enter the value:");
				option[c-1] = s;
			}
	}

	public void modify() {
		System.out.println("Do you wish to modify the choices?(0/1)");
		int c = Check.IntRange(0, 1);
		if (c==1){
			modifyChoices();
		}
	}
}
