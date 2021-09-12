import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Survey extends Main implements java.io.Serializable{

	private static final long serialVersionUID = 1;
	private Question[] question;
	protected String sname;
	public int sc;
	private String[] MenuOptions = {"Add a new T/F question", "Add a new multiple choice question",
											"Add a new short answer question", "Add a new essay question",
											"Add a new ranking question", "Add a new matching question"};
	protected FileSL sl;
	protected static boolean isSurvey = true;
	
	public Survey(){
		super();
		sl = new FileSL();
		String t = Check.FileName("Enter the name:");
		setName(t);
        String voiceName = "kevin16";
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(voiceName);
        voice.allocate();
        voice.speak("Survey "+t+":");
        voice.deallocate();
		System.out.println("Survey "+t+":");
		setlist(createlist());
	}
	
	public void setName(String name){
		if (Check.FileNametf(name)){
			sname=Filename(name);
		}
		else{
	        String voiceName = "kevin16";
	        VoiceManager voiceManager = VoiceManager.getInstance();
	        Voice voice = voiceManager.getVoice(voiceName);
	        voice.allocate();
	        voice.speak("Name not available");
	        voice.deallocate();
			System.out.println("Name not available");
		}
	}
	
	protected String getName(){
		return sname;
	}
	
	public String Filename(String name){
		name = "s_"+name;
		return name;	
	}
	
	protected Question[] getlist(){
		return question;
	}
	
	public String[] getmenu(){
		return MenuOptions;
	}
	
	public void setlist(Question[] q){
		question = q;
	}
	
	public Question[] createlist(){
        String voiceName = "kevin16";
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(voiceName);
        voice.allocate();
        voice.speak("How many questions?");
        voice.deallocate();
		System.out.println("How many questions?");
		int s = Check.PosInt();

		Question[] q = new Question[s];
		
		for (int i = 0; i < s; i++){
			displaymenu(getmenu());
			String c = getmenu()[Check.IntRange(1, getmenu().length)-1];
			q[i] = createQuestion(c);
		}
		
		return q;
	}
	
	public void displaymenu(String[] s){
        String voiceName = "kevin16";
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(voiceName);
        voice.allocate();
        voice.speak("Select a Question Type:");      
		System.out.println("Select a Question Type:");
		for (int i = 1; i <= s.length; i++){
			voice.speak(i+") "+s[i-1]);
			System.out.println(i+") "+s[i-1]);
		}
		 voice.deallocate();
	}
	
	protected Question createQuestion(String i){
        String voiceName = "kevin16";
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(voiceName);
        voice.allocate(); 
		switch (i){
			case "Add a new T/F question":
				 voice.speak("Enter the prompt to " + i+":");
				System.out.println("Enter the prompt to " + i+":");
				TF tf = new TF(isSurvey);
				return tf;
			case "Add a new multiple choice question":
				 voice.speak("Enter the prompt to " + i+":");
				System.out.println("Enter the prompt to " + i+":");
				Multiple multi = new Multiple(isSurvey);
				return multi;
			case "Add a new essay question":
				 voice.speak("Enter the prompt to " + i+":");
				System.out.println("Enter the prompt to " + i+":");
				Essay essay = new Essay(isSurvey);
				return essay;
			case "Add a new short answer question":
				 voice.speak("Enter the prompt to " + i+":");
				System.out.println("Enter the prompt to " + i+":");
				ShortAnswer shortAnswer = new ShortAnswer(isSurvey);
				return shortAnswer;
			case "Add a new matching question":
				 voice.speak("Enter the prompt to " + i+":");
				System.out.println("Enter the prompt to " + i+":");
				Matching matching = new Matching(isSurvey);
				return matching;
			case "Add a new ranking question":
				 voice.speak("Enter the prompt to " + i+":");
				System.out.println("Enter the prompt to " + i+":");
				Ranking ranking = new Ranking(isSurvey);
				return ranking;
		}
		Question q = null;
		voice.deallocate();
		return q;
	}
	
	public void display(){
		displayQuestions();
	}
	
	public void displayQuestions(){
        String voiceName = "kevin16";
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(voiceName);
        voice.allocate();
        voice.speak("Survey Name: " + getName());
		System.out.println("Survey Name: " + getName());
		for (int i = 0; i < getlist().length; i++){
			voice.speak("Question " + (i+1) + ": ");
			System.out.print("Question " + (i+1) + ": ");
			getlist()[i].display();
			System.out.println("");
		}
		 voice.deallocate();
	}
	
	public void modify(){
        String voiceName = "kevin16";
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(voiceName);
        voice.allocate();
			display();
	        voice.speak("Which question would you like to modify?\nEnter an existing question");
			System.out.println("Which question would you like to modify?\nEnter an existing question");
			display();
			int i = Check.IntRange(0, getlist().length);
			sc = i;
			if(i!=0){
				getlist()[i-1].display();
		        voice.speak("o you wish to modify the prompt?(y/n)");
				System.out.println("Do you wish to modify the prompt?(y/n)");
				Scanner s = new Scanner(System.in);
				String str = s.nextLine();
				if(str.equals("y")){
			        voice.speak(question[i-1].getPrompt());
					System.out.println(question[i-1].getPrompt());
			        voice.speak("Enter a new prompt:");
					System.out.println("Enter a new prompt:");
					Scanner ss = new Scanner(System.in);
					String strr = ss.nextLine();
					question[i-1].setPrompt(strr);
				}
				question[i-1].modify();
				}	
	        voice.deallocate();
	}
	
	public void take(){
        String voiceName = "kevin16";
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(voiceName);
        voice.allocate();
		AnsSheet a = new AnsSheet(question.length,sname);
	    voice.speak("Survey start");
		System.out.println("Survey start:");
		for (int i=0;i<question.length;i++){
		    voice.speak("Question "+(i+1)+":\n");
			System.out.println("Question "+(i+1)+":\n");
			a.insertAnswer(i, question[i].answerQuestion());
		}
		 voice.deallocate();
		sl.saveAnsSheet(a);
	}
	
	private File[] getAnsFile(){
		String d = System.getProperty("user.dir");
		File f = new File(d+"/ts/ans/"+sname);
		return f.listFiles(); 
	}
	
	public void tabulate(){
		@SuppressWarnings("unchecked")
		HashMap<String, Number>[] h = (HashMap<String,Number>[]) new HashMap<?,?>[question.length];
		for (int i=0;i<question.length;i++){ 
			h[i] = new HashMap<String,Number>();
		}
		File[] f = getAnsFile();
		if(f!=null){
			for (int k=0;k<f.length;k++){
				AnsSheet ua = sl.loadAnsSheet((f[k]));
				for (int i=0;i<question.length;i++){
					String[] a = ua.getUserAnswers()[i].getAnswer();
					for (int j=0;j<a.length;j++){
						if (h[i].containsKey(a[j])){
							int num = h[i].get(a[j]).intValue()+1;
							h[i].put(a[j], num);
						}
						else{
							h[i].put(a[j], 1);
						}
					}
				}
			}
		}else{
	        String voiceName = "kevin16";
	        VoiceManager voiceManager = VoiceManager.getInstance();
	        Voice voice = voiceManager.getVoice(voiceName);
	        voice.allocate();
	        voice.speak("Answer sheet not found");
	        voice.deallocate();
			System.out.println("Answer sheet not found");
		}
		outtabulation(h);
	}
	
	
	private void outtabulation(HashMap<String,Number>[] h){
        String voiceName = "kevin16";
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(voiceName);
        voice.allocate();
        voice.speak("Tabulation for "+getName());
		System.out.println("Tabulation for "+getName());
		for (int i=0;i<h.length;i++){
			   voice.speak("\nQuestion "+(i+1));
			System.out.println("\nQuestion "+(i+1));
			   voice.speak(getlist()[i].getPrompt());
			System.out.println(getlist()[i].getPrompt());
			   voice.speak("Tabulation:");
			System.out.println("Tabulation:");
			Iterator<?> it = h[i].entrySet().iterator();
			while(it.hasNext()){
				@SuppressWarnings("rawtypes")
				Map.Entry m = (Map.Entry)it.next();
				   voice.speak(m.getKey()+ " : "+m.getValue());
				System.out.println(m.getKey()+ " : "+m.getValue());
				it.remove();
			}
		}
		voice.deallocate();
	}

}

