//
//  Calculator.java
//  SCclient
//
//  Created by Yiyun Zhang on 3/18/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.awt.event.*;
import java.util.*;

public class Calculator {
	private GUI ui;
	private State state;
	private int last = 0;
	private boolean ne = true;

	public Calculator() {
		this.state = new Reset();
	}

	public void setUI(GUI gui) {
		ui = gui;
		ui.zero.addActionListener(new zero());
		ui.one.addActionListener(new one());
		ui.two.addActionListener(new two());
		ui.three.addActionListener(new three());
		ui.four.addActionListener(new four());
		ui.five.addActionListener(new five());
		ui.six.addActionListener(new six());
		ui.seven.addActionListener(new seven());
		ui.eight.addActionListener(new eight());
		ui.nine.addActionListener(new nine());
		ui.add.addActionListener(new add());
		ui.sub.addActionListener(new sub());
		ui.mul.addActionListener(new mul());
		ui.div.addActionListener(new div());
		ui.equal.addActionListener(new equal());
		ui.clear.addActionListener(new clear());
	}

	private class zero implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (ne) {
				ui.display.setText("0");
				ne = false;
			} else {
				String s = ui.display.getText();
				s += "0";
				ui.display.setText(s);
			}
		}
	}

	private class one implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (ne) {
				ui.display.setText("1");
				ne = false;
			} else {
				String s = ui.display.getText();
				s += "1";
				ui.display.setText(s);
			}
		}
	}

	private class two implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (ne) {
				ui.display.setText("2");
				ne = false;
			} else {
				String s = ui.display.getText();
				s += "2";
				ui.display.setText(s);
			}
		}
	}

	private class three implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (ne) {
				ui.display.setText("3");
				ne = false;
			} else {
				String s = ui.display.getText();
				s += "3";
				ui.display.setText(s);
			}
		}
	}

	private class four implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (ne) {
				ui.display.setText("4");
				ne = false;
			} else {
				String s = ui.display.getText();
				s += "4";
				ui.display.setText(s);
			}
		}
	}

	private class five implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (ne) {
				ui.display.setText("5");
				ne = false;
			} else {
				String s = ui.display.getText();
				s += "5";
				ui.display.setText(s);
			}
		}
	}

	private class six implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (ne) {
				ui.display.setText("6");
				ne = false;
			} else {
				String s = ui.display.getText();
				s += "6";
				ui.display.setText(s);
			}
		}
	}

	private class seven implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (ne) {
				ui.display.setText("7");
				ne = false;
			} else {
				String s = ui.display.getText();
				s += "7";
				ui.display.setText(s);
			}
		}
	}

	private class eight implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (ne) {
				ui.display.setText("8");
				ne = false;
			} else {
				String s = ui.display.getText();
				s += "8";
				ui.display.setText(s);
			}
		}
	}

	private class nine implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (ne) {
				ui.display.setText("9");
				ne = false;
			} else {
				String s = ui.display.getText();
				s += "9";
				ui.display.setText(s);
			}
		}
	}

	private class add implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = ui.display.getText();
			if (ne) {
				ui.display.setText("");
				state = new Reset();
			} else {
				if (s.equals("") || s.endsWith("+ ") || s.endsWith("- ") || s.endsWith("* ") || s.endsWith("/ ")) {
					return;
				}
				if (state.state()) {
					try {
						String eq = "";
						Evaluation equation = ui.getGUI();
						int res = equation.eval(s);
						eq = s + " = " + res;
						System.out.println(eq);
						last = res;
						s = Integer.toString(last) + " + ";
						ui.display.setText(s);
						state = new Calculable();
						Runnable r = new SCclient(eq);
						new Thread(r).start();
					} catch (ArithmeticException ee) {
						ee.printStackTrace();
					} catch (EmptyStackException ee) {
						ee.printStackTrace();
					}
				} else {
					s += " + ";
					ne = false;
					ui.display.setText(s);
					state = new Calculable();
				}
			}
		}
	}

	private class sub implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = ui.display.getText();
			if (ne) {
				ui.display.setText("");
				state = new Reset();
			} else {
				if (s.equals("") || s.endsWith("+ ") || s.endsWith("- ") || s.endsWith("* ") || s.endsWith("/ ")) {
					return;
				}
				if (state.state()) {
					try {
						String eq = "";
						Evaluation equation = ui.getGUI();
						int res = equation.eval(s);
						eq = s + " = " + res;
						System.out.println(eq);
						last = res;
						s = Integer.toString(last) + " - ";
						ui.display.setText(s);
						state = new Calculable();
						Runnable r = new SCclient(eq);
						new Thread(r).start();
					} catch (ArithmeticException ee) {
						ee.printStackTrace();
					} catch (EmptyStackException ee) {
						ee.printStackTrace();
					}
				} else {
					s += " - ";
					ne = false;
					ui.display.setText(s);
					state = new Calculable();
				}
			}
		}
	}

	private class mul implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = ui.display.getText();
			if (ne) {
				ui.display.setText("");
				state = new Reset();
			} else {
				if (s.equals("") || s.endsWith("+ ") || s.endsWith("- ") || s.endsWith("* ") || s.endsWith("/ ")) {
					return;
				}
				if (state.state()) {
					try {
						String eq = "";
						Evaluation equation = ui.getGUI();
						int res = equation.eval(s);
						eq = s + " = " + res;
						System.out.println(eq);
						last = res;
						s = Integer.toString(last) + " * ";
						ui.display.setText(s);
						state = new Calculable();
						Runnable r = new SCclient(eq);
						new Thread(r).start();
					} catch (ArithmeticException ee) {
						ee.printStackTrace();
					} catch (EmptyStackException ee) {
						ee.printStackTrace();
					}
				} else {
					s += " * ";
					ne = false;
					ui.display.setText(s);
					state = new Calculable();
				}
			}
		}
	}

	private class div implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = ui.display.getText();
			if (ne) {
				ui.display.setText("");
				state = new Reset();
			} else {
				if (s.equals("") || s.endsWith("+ ") || s.endsWith("- ") || s.endsWith("* ") || s.endsWith("/ ")) {
					return;
				}
				if (state.state()) {
					try {
						String eq = "";
						Evaluation equation = ui.getGUI();
						int res = equation.eval(s);
						eq = s + " = " + res;
						System.out.println(eq);
						last = res;
						s = Integer.toString(last) + " / ";
						ui.display.setText(s);
						state = new Calculable();
						Runnable r = new SCclient(eq);
						new Thread(r).start();
					} catch (ArithmeticException ee) {
						ee.printStackTrace();
					} catch (EmptyStackException ee) {
						ee.printStackTrace();
					}
				} else {
					s += " / ";
					ne = false;
					ui.display.setText(s);
					state = new Calculable();
				}
			}
		}
	}

	private class equal implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = ui.display.getText();
			String eq = "";
			if (ne) {
				ui.display.setText("");
				state = new Reset();
			}
			if (!state.state() || s.equals("") || s.endsWith("+ ") || s.endsWith("- ") || s.endsWith("* ")
					|| s.endsWith("/ ")) {
				return;
			}
			Evaluation cm = ui.getGUI();
			try {
				int res = cm.eval(s);
				eq = s + " = " + res;
				System.out.println(eq);
				ui.display.setText("" + res);
				state = new Reset();
				Runnable r = new SCclient(eq);
				new Thread(r).start();
				last = res;
				ne = true;
			} catch (ArithmeticException ee) {
				ee.printStackTrace();
			} catch (EmptyStackException ee) {
				ee.printStackTrace();
			}
		}
	}

	private class clear implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ui.display.setText("");
			state = new Reset();
			ne = true;
		}
	}
}