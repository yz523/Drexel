import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TF extends Multiple implements java.io.Serializable{

	private static final long serialVersionUID = 1;
	
	public TF(boolean a) {
		super(a);
	}
	
	protected void setOptions(){
		option = new String[2];
		option[0] = "True";
		option[1] = "False";
	}
	
	public Answer setCorrectAns(){
		getIsSurvey();
		if (isSurvey == true){
			ans = null;
			return ans;
		} else {
	        String voiceName = "kevin16";
	        VoiceManager voiceManager = VoiceManager.getInstance();
	        Voice voice = voiceManager.getVoice(voiceName);
	        voice.allocate();
	        voice.speak("Enter Correct Answer(True(0)/False(1))");
	        voice.deallocate();
			System.out.println("Enter Correct Answer(True(0)/False(1))");
			String[] s = {option[Check.IntRange(0,1)]};
			setCorrectAns(s);
			ans = new Answer(s);
			return ans;
		}
	}
}
