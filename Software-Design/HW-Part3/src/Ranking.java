import java.util.*;

public class Ranking extends Question{

	private static final long serialVersionUID = 1;
	private String[] options;
	protected Answer ans;
	
	public Ranking(boolean a){
		super(a);
		setOptions(createOptions());
		setCorrectAns();
	}
	
	public String[] getOptions() {
		return options;
	}
	
	public void setOptions(String[] s) {
		options = s;
	}
	
	public String[] createOptions(){
		System.out.println("How many items will be in the list?");
		setMinAnswerSize(Check.IntRange(2, 99));
		setMaxAnswerSize(getMinAnswerSize());
		System.out.println(getCreateColumnPrompt());
		String[] s = Check.MultipleAnsW("list item",getMinAnswerSize(),getMinAnswerSize(),false);
		return s;
	}
	

	public void display(){
		System.out.println(getPrompt());
		for (int i=0;i<options.length;i++){
			System.out.println(getCharForNumber(i+1)+")"+options[i]);
		}
	}
	
	private String getCharForNumber(int i) {
	    return i > 0 && i < 27 ? String.valueOf((char)(i + 'A' - 1)) : null;
	}
	
	public String getCreateColumnPrompt(){
		return "Enter the items the user will rank, from top to bottom";
	}
	
	public Answer setCorrectAns() {
		getIsSurvey();
		if (isSurvey == true){
			ans = null;
			return ans;
		} else {
			System.out.println("Enter Correct Answer, \n");
			String[] s = Check.MultipleAnsN("ranking for item",getMinAnswerSize(),options.length, options.length,false);
			s = Arr.stoval(s,options);
			String[] a = new String[1]; 
			a[0] = Arrays.toString(s);
			setCorrectAnswer(a);
			Answer an = new Answer(a);
			return an;
		}
	}

	public void setCorrectAnswer(String[] s){
		ans = new Answer(s);
	}
	
	public Answer getCorrectAnswer(){
		return ans;
	}
	
	public Answer answerQuestion() {
		display();
		System.out.println("Rank the options:" );
		String[] ans = Check.MultipleAnsN("ranking",getMinAnswerSize(),options.length, options.length,false);
		ans = Arr.stoval(ans,options);
		String[] s = new String[1]; 
		s[0] = Arrays.toString(ans);
		Answer a = new Answer(s);
		return a;
	}

	public void modify() {
		System.out.println("Do you wish to modify the list?(0/1)");
		int c = Check.IntRange(0, 1);
		if (c==1){
			modifyOptions();
		}
	}
	
	public void modifyOptions(){
		int c;
			for(int i=0;i<options.length;i++){
				System.out.println((i+1)+")"+options[i]);
			}
			System.out.println("Which choice do you want to modify?");
			c = Check.IntRange(0, options.length);
			if (c!=0){
				String s = Check.StringIn("Enter the value:");
				options[c-1] = s;
			}
	}
}
