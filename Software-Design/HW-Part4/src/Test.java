import java.util.Scanner;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Test extends Survey {

	private static final long serialVersionUID = 1;
	private Answer[] ans;
	protected static boolean isSurvey = false;
	
	public Test(){
		super();
	}
	
	public Answer[] getAns() {
		return ans;
	}

	public void setAns(Answer[] a) {
		ans = a;
	}
	
	public String Filename(String name){
		name= "t_"+name;
		return name;	
	}

	public Question[] createlist(){
        String voiceName = "kevin16";
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(voiceName);
        voice.allocate();
        voice.speak("How many questions");
        voice.deallocate();
		System.out.println("How many questions?");
		int n = Check.PosInt();
		ans = new Answer[n];
		Question[] q = new Question[n];
		for (int i=0;i<n;i++){
			displaymenu(getmenu());
			String c = getmenu()[Check.IntRange(1, getmenu().length)-1];
			q[i] = createQuestion(c,i);
		}
		return q;
	}
	
	protected Question createQuestion(String i,int in){
        String voiceName = "kevin16";
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(voiceName);
        voice.allocate(); 
		switch (i){
			case "Add a new T/F question":
				voice.speak("Enter the prompt to " + i+":");
				System.out.println("Enter the prompt to " + i+":");
				TF tf = new TF(isSurvey);
				ans[in] = tf.getCorrectAnswer();
				return tf;
			case "Add a new multiple choice question":
				voice.speak("Enter the prompt to " + i+":");
				System.out.println("Enter the prompt to " + i+":");
				Multiple multi = new Multiple(isSurvey);
				ans[in]=multi.getCorrectAnswer();
				return multi;
			case "Add a new essay question":
				voice.speak("Enter the prompt to " + i+":");
				System.out.println("Enter the prompt to " + i+":");
				Essay essay = new Essay(isSurvey);
				ans[in] = essay.getCorrectAnswer();
				return essay;
			case "Add a new short answer question":
				voice.speak("Enter the prompt to " + i+":");
				System.out.println("Enter the prompt to " + i+":");
				ShortAnswer shortAnswer = new ShortAnswer(isSurvey);
				ans[in] = shortAnswer.getCorrectAnswer();
				return shortAnswer;
			case "Add a new matching question":
				voice.speak("Enter the prompt to " + i+":");
				System.out.println("Enter the prompt to " + i+":");
				Matching matching = new Matching(isSurvey);
				ans[in] = matching.getCorrectAnswer();
				return matching;
			case "Add a new ranking question":
				voice.speak("Enter the prompt to " + i+":");
				System.out.println("Enter the prompt to " + i+":");
				Ranking ranking = new Ranking(isSurvey);
				ans[in] = ranking.getCorrectAnswer();
				return ranking;
		}
		Question re = new TF(isSurvey);
		voice.deallocate();
		return re;
	}
	
	public void display(){
        String voiceName = "kevin16";
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(voiceName);
        voice.allocate();
        voice.speak("Display with answer?(0/1)");
        voice.deallocate();
		System.out.println("Display with answer?(0/1)");
		int c = Check.IntRange(0, 1);
		if(c==1){
			displayWithAnswers();
		}
		else{
			displayQuestions();
		}
	}
	
	public void displayWithAnswers(){
        String voiceName = "kevin16";
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(voiceName);
        voice.allocate();
        voice.speak("Survey Name: " + getName());
		System.out.println("Survey Name: " + getName());
		for (int i=0;i<getlist().length;i++){
			voice.speak("Question " + (i+1) + ": ");
			System.out.print("Question " + (i+1) + ": ");
			getlist()[i].display();
			if (ans[i]!=null){
				voice.speak("Correct Answer(s):");
				System.out.println("Correct Answer(s):");
				String[] s =  ans[i].getAnswer();
				for(int j=0;j<s.length;j++){
					voice.speak(s[j]);
					System.out.println(s[j]);
				}
			}
		}
		voice.deallocate();
	}
	public void modifyWithAnswers(){
        String voiceName = "kevin16";
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(voiceName);
        voice.allocate();
		modify();
		 voice.speak("Do you wish to modify the correct answer?(y/n)");
		System.out.println("Do you wish to modify the correct answer?(y/n)");
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		if(str.equals("y")){
			 voice.speak("What choice do you wish to make the new correct answer");
			System.out.println("What choice do you wish to make the new correct answer?");
			Scanner ss = new Scanner(System.in);
			String strr = ss.nextLine();
			int tmp = Integer.parseInt(strr);
			 voice.speak("Enter the answer value");
			System.out.println("Enter the answer value:");
			Scanner sss = new Scanner(System.in);
			String strrr = sss.nextLine();
			ans[sc-1].setSpecAns(sc-1, strrr);
		}
		voice.deallocate();
	}
	
	public void gradeTest(AnsSheet ua){
        String voiceName = "kevin16";
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(voiceName);
        voice.allocate();
		int u = 0;
		int c = 0;
		int g = 0;
		Question[] q = getlist();
		double w = (100.0/q.length);
		Answer[] a = ua.getUserAnswers();
		int[] grade;
		for (int i = 0; i < q.length; i++){
	        voice.speak("Question "+(i+1)+":");
			System.out.println("Question "+(i+1)+":");
			grade = q[i].gradeQuestion(a[i], ans[i]);
			c+=grade[0];
			g+=grade[1];
			if((grade[0]==0)&&(grade[1])==0){ 
				u+=1;
			}
		}
        voice.speak("Grade");
		System.out.println("Grade:");
        voice.speak(String.valueOf(Math.round(c*w))+"/"+String.valueOf(Math.round(g*w)));
		System.out.println(String.valueOf(Math.round(c*w))+"/"+String.valueOf(Math.round(g*w)));
		   voice.deallocate();
	}
}
