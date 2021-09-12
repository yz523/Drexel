import java.io.File;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileSL implements java.io.Serializable{

	private static final long serialVersionUID = 1;
	
	public FileSL(){}
	
	public void save(Survey s){
        String voiceName = "kevin16";
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(voiceName);
        voice.allocate();
		try{
			String d = System.getProperty("user.dir");
			File td = new File(d+"/ts/");
			td.mkdirs();
			FileOutputStream fo = new FileOutputStream(d+"/ts/"+s.getName());
			ObjectOutputStream out  = new ObjectOutputStream(fo);
			out.writeObject(s);
			out.close();
			fo.close(); 
			voice.speak("File saved: "+d+"\\ts\\"+s.getName());
			System.out.println("File saved: "+d+"\\ts\\"+s.getName());			
			File dir = new File(d+"/ts/ans/"+s.getName());
			dir.mkdirs();
			voice.speak("Answer saved:"+dir.getAbsolutePath());
			System.out.println("Answer saved:"+dir.getAbsolutePath()+"\n");
		}catch(IOException i){
			voice.speak("Save Failed");
			System.out.println("Save Failed");
		}
        voice.deallocate();
	}
	
	public Survey load(String n){
        String voiceName = "kevin16";
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(voiceName);
        voice.allocate();
		Survey s=  null;		
		try{
			String d = System.getProperty("user.dir");
			String f = d+"\\ts\\"+n;
			FileInputStream fin = new FileInputStream(f);
			ObjectInputStream in = new ObjectInputStream(fin);
			s = (Survey) in.readObject();
			in.close();
			fin.close();
		    voice.speak("Survey/Test Loaded");
			System.out.println("Survey/Test Loaded\n");
		} catch (Exception e) {
		    voice.speak("File not Found");
			System.out.println("File not Found\n");
		}
		voice.deallocate();
		return s;
	}

	public void Display(String a) {
        String voiceName = "kevin16";
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(voiceName);
        voice.allocate();
		String d = System.getProperty("user.dir");
		String f = d+"\\ts\\";
		
		File fo = new File(f);
		File[] l = fo.listFiles();	    
		
		for (int i = 0; i < l.length; i++) {
			if (l[i].isFile()) {
				String file = l[i].getName();
				if (file.matches("^(s_).*") && a == "Survey"){
					file = file.replaceAll("^(s_)", "");
				    voice.speak(i + ") " + file);
					System.out.println(i + ") " + file);
				} 
				if (file.matches("^(t_).*") && a == "Test"){
					file = file.replaceAll("^(t_)", "");
				    voice.speak(i + ") " + file);
					System.out.println(i + ") " + file);
				}
			}
		}
		  voice.deallocate();
	}
	
	public void saveAnsSheet(AnsSheet ur){
        String voiceName = "kevin16";
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(voiceName);
        voice.allocate();
		String surveyName = ur.getSurveyName();
		String userName = ur.getUserName();
		try{
			String workingDir = System.getProperty("user.dir");
			FileOutputStream fileOut = new FileOutputStream(workingDir+"/ts/ans/"+surveyName+"/ans_"+userName+surveyName);
			ObjectOutputStream out  = new ObjectOutputStream(fileOut);
			out.writeObject(ur);
			out.close();
			fileOut.close();
			voice.speak("Answer saved in "+workingDir+"/ts/ans/"+surveyName+"/ans_"+userName+surveyName);
			System.out.println("Answer saved in "+workingDir+"/ts/ans/"+surveyName+"/ans_"+userName+surveyName);
		}catch(IOException i){
			voice.speak("Problem in Saving Answer Sheet");
			System.out.println("Problem in Saving Answer Sheet\n");
		}
		voice.deallocate();
	}
	
	public AnsSheet loadAnsSheet(File file){
        String voiceName = "kevin16";
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(voiceName);
        voice.allocate();
		AnsSheet ua=  null;
		try{
			FileInputStream fileIn = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			ua = (AnsSheet) in.readObject();
			in.close();
			fileIn.close();
			  voice.speak(ua.getUserName()+"'Answer sheet loaded");
			System.out.println(ua.getUserName()+"'Answer sheet loaded\n");
			return ua;
		}
		catch(Exception e){
			  voice.speak("Error in loading answer sheets");
			System.out.println("Error in loading answer sheets\n");
		}
		voice.deallocate();
		return ua;
	}
	
	public AnsSheet loadAnsSheet(String un, String sn){
        String voiceName = "kevin16";
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(voiceName);
        voice.allocate();
		AnsSheet a =null;
		String d = System.getProperty("user.dir");
		try{
			FileInputStream f = new FileInputStream(d+"/ts/ans/"+sn+"/ans_"+un+sn);
			ObjectInputStream in = new ObjectInputStream(f);
			a = (AnsSheet) in.readObject();
			in.close();
			f.close();
		    voice.speak("Answer sheet loaded");
			System.out.println("Answer sheet loaded\n");
			return a;
		}
		catch(Exception e){
		    voice.speak("Error in loading answer sheets");
			System.out.println("Error in loading answer sheets\n");
		}
		voice.deallocate();
		return a;
	}
}
