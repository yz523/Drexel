
//
//  Visitor.java
//  lab3
//
//  Created by Yiyun Zhang on 2/27/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

public interface Visitor {
	void visitFile(Files files);
	void visitFolder(Folder folder);
	void visitTotalFile(Folder folder);
	void visitEarliestFile(Folder folder);
}
