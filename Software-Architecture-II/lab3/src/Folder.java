
//
//  Folder.java
//  lab3
//
//  Created by Yiyun Zhang on 2/27/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.util.ArrayList;
import java.util.List;

public class Folder extends Component {

	private List<Component> children = new ArrayList<Component>();
	private String folderName = "";
	private double date = 0.00;
	private int level = 0;

	public Folder(String name, double d, int l) {
		folderName = name;
		date = d;
		level = l;
	}

	public void operation() {
		String indent = "";
		for (int i = 1; i < level; i++) {
			indent = indent + "  ";
		}
		System.out.print(indent + "-" + folderName + "  " + date + "\n");
		for (Component component : children) {
			component.operation();
		}
	}

	public void add(Component component) {
		children.add(component);
	}

	public void remove(Component component) {
		children.remove(component);
	}

	public Component getChild(int index) {
		return children.get(index);
	}

	public void accept(Visitor visitor) {
		visitor.visitFolder(this);
	}

	public void total() {
		for (Component component : children) {
			component.total();
		}
	}

	void earliest() {
		for (Component component : children) {
			component.earliest();
		}
	}
}