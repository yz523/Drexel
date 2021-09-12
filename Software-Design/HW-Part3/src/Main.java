import java.io.File;
import java.util.*;


public class Main {
	
	private static String[] menu1 = {"Survey","Test"};
	private static String[] menu2s = {"Create a new Survey", "Display a Survey", "Load a Survey", "Save a Survey", "Modify an Existing Survey", "Take a Survey", "Tabulate a Survey", "Quit"};
	private static String[] menu2t = {"Create a new Test", "Display a Test", "Load a Test", "Save a Test", "Modify an Existing Test", "Take a Test", "Tabulate a Test", "Grade a Test",  "Quit"};
	
	private static Survey cs;
	private static FileSL sl = new FileSL();
	
	private static void menu1() {
		for (int i=1;i<=menu1.length;i++){
			System.out.println(String.valueOf(i)+")"+menu1[i-1]);
		}
		System.out.println("");
		String m1c = menu1[Check.IntRange(1, menu1.length)-1];
		System.out.println(m1c);
		switch(m1c){
			case "Survey":{	
				menu2s();
				break;
			}
			case "Test":{
				menu2t();
				break;
			}
		}
	}

	protected static void menu2s() {
		for (int i=1;i<=menu2s.length;i++){
			System.out.println(String.valueOf(i)+")"+menu2s[i-1]);
		}
		System.out.println("");
		String m2c = menu2s[Check.IntRange(1, menu2s.length)-1];
		
		switch(m2c){
			case "Create a new Survey":{
				Survey sur = new Survey();
				cs = sur;
				System.out.println("Survey created, what to do next?\n");
				menu2s();	
				break;
			}
			case "Display a Survey":{
				if (cs!=null){
					cs.display();
					menu2s();
				}else{
					System.out.println("No survey loaded\n");
					menu2s();
				}
				break;
			}
			case "Load a Survey":{
				System.out.println("Survey:");
				sl.Display("Survey");
				String name = Check.StringIn("Enter Survey name to load");
				Survey temp = sl.load("s_"+name);
				if (temp!=null){
					cs=temp;
				}
				menu2s();
				break;
			}
			case "Save a Survey":{
				sl.save(cs);
				menu2s();
				break;
			}
			case "Modify an Existing Survey":{
				System.out.println("What survey do you wish to modify?");
				sl.Display("Survey");
				String name = Check.StringIn("Enter existing Survey name:");
				Survey temp = sl.load("s_"+name);
				if (temp!=null){
					temp.modify();
					cs=temp;
				}
				System.out.println("Modify finished, what to do next?\n");
				menu2s();
				break;
			}
			case "Take a Survey":{
				System.out.println("Enter the name of the survey you wish to take:");
				sl.Display("Survey");
				String name = Check.StringIn("Enter existing survey name:");
				Survey temp = sl.load("s_"+name);
				if (temp!=null){
					temp.take();
				}
				System.out.println("This is the end of the survey\n");
				break;
			}
			case "Tabulate a Survey":{
				if(cs!=null){
					cs.tabulate();
				}
				else{
					System.out.println("No survey loaded");
				}
				menu2s();
				break;
			}
			case "Quit":{
				System.out.println("exit");
				System.exit(0);
				break;
			}
		}
	}
	
	private static void menu2t() {
		for (int i=1;i<=menu2t.length;i++){
			System.out.println(String.valueOf(i)+")"+menu2t[i-1]);
		}
		System.out.println("");
		String m2c = menu2t[Check.IntRange(1, menu2t.length)-1];
		System.out.println(m2c);
		switch(m2c){
			case "Create a new Test":{
				Survey sur = new Test();
				cs = sur;
				System.out.println("Test created, what to do next?\n");
				menu2t();
				break;
			}
			case "Display a Test":{
				if (cs!=null){
					cs.display();
					menu2t();
				}else{
					System.out.println("No test loaded\n");
					menu2t();
				}
				break;
			}
			case "Load a Test":{
				System.out.println("Test:");
				sl.Display("Test");
				String name = Check.StringIn("Enter Test name to load");
				Survey temp = sl.load("t_"+name);
				if (temp!=null){
					cs=temp;
				}
				menu2t();
				break;
			}
			case "Save a Test":{
				sl.save(cs);
				menu2t();
				break;
			}
			case "Modify an Existing Test":{
				System.out.println("What test do you wish to modify?");
				sl.Display("Test");
				String name = Check.StringIn("Enter existing Test name:");
				Survey temp = sl.load("t_"+name);
				if (temp!=null){
					Test tt = (Test) temp;
					tt.modifyWithAnswers();;
					cs=tt;
				}
				System.out.println("Modify finished, what to do next?\n");
				menu2t();
				break;
			}
			case "Take a Test":{
				System.out.println("Enter the name of the test you wish to take:");
				sl.Display("Test");
				String name = Check.StringIn("Enter existing test name:");
				Survey temp = sl.load("t_"+name);
				if (temp!=null){
					temp.take();
				}
				System.out.println("This is the end of the test\n");
				break;
			}
			case "Tabulate a Test":{
				if(cs!=null){
					cs.tabulate();
				}
				else{
					System.out.println("No test loaded");
				}
				menu2t();
				break;
			}
			case "Grade a Test":{		
				System.out.println("Enter the username of the current test you wish to grade:");
				Scanner s = new Scanner(System.in);
				String name = s.nextLine();
				if (cs!=null){
					Test t = (Test) cs;
					AnsSheet as =sl.loadAnsSheet(name,cs.getName());
					System.out.println(name+cs.getName());
					t.gradeTest(as);
				}
				System.out.println("This is the end of the grade\n");
				menu1();
				break;
			}
			
			case "Quit":{
				System.out.println("exit");
				System.exit(0);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		String d = System.getProperty("user.dir");
		File td = new File(d+"/ts/");
		td.mkdirs();
		String dd = System.getProperty("user.dir");
		File tdd = new File(d+"/ts/ans/");
		tdd.mkdirs();
		boolean t = true;
		while (t ==true){
			menu1();
		}
		Scanner s = new Scanner(System.in);
		s.close();
	}
}
