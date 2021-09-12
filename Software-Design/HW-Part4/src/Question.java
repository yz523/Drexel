import java.util.Arrays;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

abstract class Question implements java.io.Serializable{

	private static final long serialVersionUID = 1;
	private String prompt;
	private int minSize=1;
	private int maxSize=1;
	protected boolean isSurvey;
	abstract public Answer setCorrectAns();
	abstract public void display();
	abstract public void modify();
	abstract public Answer answerQuestion();
	
	public Question(){}
	
	public void setMinAnswerSize(int i){
		minSize = i;
	}
		
	public int getMinAnswerSize(){
		return minSize;
	}
	
	public void setMaxAnswerSize(int i){
		maxSize = i;
	}
	
	public int getMaxAnswerSize(){
		return maxSize;
	}
	
	
	public Question(boolean a){
		setIsSurvey(a);
		setPrompt(Check.StringIn(""));
	}
	
	public void setIsSurvey(boolean a){
		isSurvey = a;
	}
	
	public boolean getIsSurvey(){
		return isSurvey;
	}
		
	public void setMinSize(int i){
		minSize = i;
	}
	
	public void setMaxSize(int i){
		maxSize = i;
	}
	
	public int getMaxSize(){
		return maxSize;
	}
	
	
	public int getMinSize(){
		return minSize;
	}
	
	
	protected void setPrompt(String s){
		prompt = s;
	}
	
	protected String getPrompt(){
		return prompt;
	}
	
	public int[] gradeQuestion(Answer ua, Answer ca){
        String voiceName = "kevin16";
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(voiceName);
        voice.allocate();
		int[] g = new int[2];
		g[0] = 1;
		g[1] = 1;
		String[] e = {"Essay"};
		String[] u = ua.getAnswer();
		String[] c = ca.getAnswer();
		
		if(u != null && c != null){
			if(u.length == c.length){
				if (Arrays.equals(c, e) ) {
					voice.speak("Your answer - " + Arrays.toString(c));
					System.out.println("Your answer - " + Arrays.toString(c));
					g[0]=0;
					g[1]=0;
				} else {
					for(int i = 0; i < c.length; i++){
				        voice.speak("Correct answer: " + Arrays.toString(c));
						System.out.println("Correct answer: " + Arrays.toString(c));
						voice.speak("Your answer: " + Arrays.toString(u));
						System.out.println("Your answer: " + Arrays.toString(u));
						if(!c[i].equals(u[i])){
							g[0]=0;			
						}
					}
				}
			} else {
				g[0]=0;
			}
		} else {
			g[0]=0;
		}
		voice.deallocate();
		return g;
	}
}
