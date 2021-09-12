public class AnsSheet implements java.io.Serializable{

	private static final long serialVersionUID = 1;
	private String surveyName;
	private String userName;
	private Answer[] userAnswers;
	
	
	public AnsSheet(int n,String s){
		userAnswers = new Answer[n];
		surveyName = s;
		userName = Check.FileName("Enter the username");
	}
	
	protected void insertAnswer(int q,Answer a){
		userAnswers[q] = a;
	}

	protected void setUserName(String s){
		userName = s;
	}
	
	protected void setSurveyName(String s){
		surveyName = s;
	}
	
	protected Answer[] getUserAnswers(){
		return userAnswers;
	}
	
	protected String getUserName(){
		return userName;
	}
	
	protected String getSurveyName(){
		return surveyName;
	}	
}