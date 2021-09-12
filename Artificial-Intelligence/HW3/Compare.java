//
//  Compare.java
//  HW3
//
//  Created by Yiyun Zhang on 11/10/17.
//  Copyright © 2017 Yiyun Zhang. All rights reserved.
//

import java.util.Comparator;

public class Compare implements Comparator<Node> {
	
    public int compare(Node a, Node b) {
        if(a.getcost() > b.getcost()){
            return 1;
        }
        if(a.getcost() < b.getcost()){
            return -1;
        }
        return 0;
    }
}