import java.util.Arrays;
import java.util.Scanner;

public class ShortAnswer extends Question{
	
	private static final long serialVersionUID = 1;
	protected boolean isSurvey;
	protected Answer ans;
	
	public ShortAnswer(boolean a){
		super(a);
		isSurvey = a;
		setCorrectAns();
	}
	
	public void setCorrectAns(String[] s){
		ans = new Answer(s);
	}
	
	public Answer getCorrectAnswer(){
		return ans;
	}
	
	public void display(){
		System.out.println(getPrompt());
	}
	
	public Answer setCorrectAns() {
		getIsSurvey();
		if (isSurvey == true){
			Answer a = null;
			return a;
		} else {
			System.out.println("Enter Correct Answer");
			Scanner s = new Scanner(System.in);
			String res = s.nextLine();
			String[] aa = {res};
			setCorrectAns(aa);
			ans = new Answer(aa);
			return ans;
		}
	}
	
	public Answer answerQuestion() {
		display();
		String[] s;
		if(getMinAnswerSize()==getMaxAnswerSize()){
			s = Check.MultipleAnsW("answer",getMinAnswerSize(),getMaxAnswerSize(),false);
		}
		else{
			s = Check.MultipleAnsW("answer",getMinAnswerSize(),getMaxAnswerSize(),true);
		}
		s = Check.arrayToUpper(s);
		Arrays.sort(s);
		Answer ans = new Answer(s);
		return ans;
	}
	
	public void modify() {}
}
