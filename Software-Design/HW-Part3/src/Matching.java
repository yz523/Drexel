import java.util.Arrays;

public class Matching extends Ranking{

	private static final long serialVersionUID = 1;
	private String[] mo;
	
	public Matching(boolean a){
		super(a);
	}
	
	public void setmo(String[] s){
		mo = s;
	}
	
	public String[] getmo() {
		return mo;
	}
	
	public String[] createmo(){
		System.out.println("Enter the options from top to bottom");
		String[] s = Check.MultipleAnsW("list item",getMinAnswerSize(),getMinAnswerSize(),false);
		return s;
	}
	
	public void display(){
		System.out.println(getPrompt());
		for (int i=0;i<getOptions().length;i++){
			System.out.println(getChar(i+1)+")"+getOptions()[i]+"       " +(i+1)+")"+mo[i]);
		}
	}
	
	private String getChar(int i) {
	    return i > 0 && i < 27 ? String.valueOf((char)(i + 'A' - 1)) : null;
	}
	
	public String getCreateColumnPrompt(){
		return "Enter the options from top to bottom";
	}
	
	
	private String[] arrval(String[] a, String[] b){
		String[] ele = null;
		if (a.length==b.length){
			ele = new String[a.length];
			for(int i=0;i<a.length;i++){
				ele[i] = a[i]+":"+b[i];
			}
		}
		return ele;
	}
	
	public Answer setCorrectAns() {
		setmo(createmo());
		getIsSurvey();
		if (isSurvey == true){
			ans = null;
			return ans;
		} else {
			System.out.println("Enter Correct Answer, \n");
			String[] a = Check.MultipleAnsN("matching for item",getMinAnswerSize(),getMinAnswerSize(), getMinAnswerSize(),false);
			String[] b = arrval(getOptions(),Arr.stoval(a,mo));
			String[] c = new String[1]; 
			c[0] = Arrays.toString(b);
			setCorrectAnswer(c);
			Answer an = new Answer(c);
			return an;
		}
	}
}