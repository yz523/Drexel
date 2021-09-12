
//
//  Observer.java
//  KWIC3
//
//  Created by Yiyun Zhang on 2/21/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

interface Observer {
	public String usrInput = "";
	public List<String> lines = new ArrayList<String>();
	public List<String> result = new ArrayList<String>();
	public void update() throws IOException;
}
