
//
//  main.java
//  lab3
//
//  Created by Yiyun Zhang on 2/27/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

public class main {
	public static void main(String[] args){
		Folder folder1 = new Folder("folder1",1.1,1);
		Folder folder2 = new Folder("folder2",2.5,2);
		Folder folder3 = new Folder("folder3",2.14,2);
		Folder folder4 = new Folder("folder4",3.21,3);
		Folder folder5 = new Folder("folder5",5.5,3);
		Folder folder6 = new Folder("folder6",11.14,3);
		Folder folder7 = new Folder("folder7",12.3,3);
		Folder folder8 = new Folder("folder8",5.14,3);
		Folder folder9 = new Folder("folder9",3.23,3);
		Folder folder10 = new Folder("folder10",11.12,3);
		Folder folder11 = new Folder("folder11",12.1,3);
		Folder folder12 = new Folder("folder12",5.1,3);
		Files file1 = new Files("file1.txt",1.1,21,2);
		Files file2 = new Files("file2.exe",1.1,2098,2);
		Files file3 = new Files("file3.mp4",3.12,124,2);
		Files file4 = new Files("file4.mp3",12.12,2345,2);
		Files file5 = new Files("file5.exe",11.23,436,2);
		Files file6 = new Files("file6.txt",1.3,766,3);
		Files file7 = new Files("file7.doc",7.7,777,4);
		folder1.add(file1);
		folder1.add(file2);
		folder1.add(file3);
		folder1.add(file4);
		folder1.add(file5);
		folder1.add(folder2);
		folder1.add(folder3);
		folder2.add(folder4);
		folder2.add(folder5);
		folder5.add(file6);
		folder2.add(folder6);
		folder2.add(folder7);
		folder7.add(file7);
		folder2.add(folder8);
		folder2.add(folder9);
		folder3.add(folder10);
		folder3.add(folder11);
		folder3.add(folder12);
		ConcreteVisitor v = new ConcreteVisitor();
		v.visitFolder(folder1);
		ConcreteVisitor v2 = new ConcreteVisitor();
		v2.visitTotalFile(folder1);
		ConcreteVisitor v3 = new ConcreteVisitor();
		v3.visitEarliestFile(folder1);	
	}
}