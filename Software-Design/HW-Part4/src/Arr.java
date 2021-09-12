import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;


public class Arr {

	public Arr() {}

	public static String[] stoval(String[] a,String[] b){
		String voiceName = "kevin16";
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(voiceName);
        voice.allocate();
		String[] s = null;
		try{
			s = new String[a.length];
			for(int i=0;i<s.length;i++){
				s[i] = b[Integer.parseInt(a[i])-1];
			}
		}
		catch(Exception e){
	        voice.speak("Hello world!");
			System.out.println("Error changing selections to values");
		}
		voice.deallocate();
		return s;
	}
}