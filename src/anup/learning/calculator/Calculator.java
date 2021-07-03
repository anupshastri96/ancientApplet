package anup.learning.calculator;

import java.applet.*;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Calculator extends Applet implements MouseListener, KeyListener{
	
	int res;
	int flag=0;
	int op1=0, op2=0, nextOp=0;
	char operator;
	
	GridLayout g = new GridLayout(5,4,5,5);
	Button[] b;
	TextField t;
		
	public void init() {
		setLayout(g);
		setSize(300,300);
		t = new TextField();
		b = new Button[16];
		
		b[0] = new Button("1");
		b[1] = new Button("2");
		b[2] = new Button("3");
		b[3] = new Button("4");
		b[4] = new Button("5");
		b[5] = new Button("6");
		b[6] = new Button("7");
		b[7] = new Button("8");
		b[8] = new Button("9");
		b[9] = new Button("0");
		b[10] = new Button("+");
		b[11] = new Button("-");
		b[12] = new Button("/");
		b[13] = new Button("*");
		b[14] = new Button("%");
		b[15] = new Button("=");
		

		
		for(int i=0; i<16; i++) {
			add(b[i]);
			b[i].addMouseListener(this);
		}
		
		add(t);
		t.addKeyListener(this);

	}
	

		
	@Override
	public void keyPressed(KeyEvent arg0) {
		
		char c = arg0.getKeyChar();
		if(c == '=') {
			System.out.println("Inside = operator");
			
			switch(operator) {
			
			case '+' :
				res = op1 + op2;
				System.out.println("Result after + :"+res);
				break;
			case '-' :
				res = op1 - op2;
				System.out.println("Result after - :"+res);
				break;
			case '/' :
				res = op1 / op2;
				System.out.println("Result after / :"+res);
				break;
			case '*' :
				res = op1 * op2;
				System.out.println("Result after * :"+res);
				break;
			case '%' :
				res = op1 % op2;
				System.out.println("Result after % :"+res);
				break;
			
			}
			flag = 0;
			op1 = 0;
			op2 = 0;
			t.setText(Integer.toString(res));
			nextOp=res;
		} 
		else {
			
			
			switch(c) {
			
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				if(nextOp!=0) {
					t.setText(Character.toString(c));
				}
				if(flag == 0) {
					
					op1 = op1*10 + Integer.parseInt(Character.toString(c));
					System.out.println("Getting op1"+op1);
					
				}
				else {
					op2 = op2*10 + Integer.parseInt(Character.toString(c));
					System.out.println("Getting op2"+op2);
				}
				break;
			case '+':
			case '-':
			case '/':
			case '*':
			case '%':
				if(nextOp!=0) {
					t.setText(Integer.toString(res));
					op1 = res;
				}
				operator = c;
				flag = 1;
			break;
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if((Button)arg0.getSource() == b[15]) {
			System.out.println("inside = operation now");
			
			switch(operator) {
			
			case '+' :
				res = op1 + op2;
				System.out.println("Result after +"+res);
				break;
			case '-' :
				res = op1 - op2;
				System.out.println("Result after -"+res);
				break;
			case '/' :
				res = op1 / op2;
				System.out.println("Result after /"+res);
				break;
			case '*' :
				res = op1 * op2;
				System.out.println("Result after *"+res);
				break;
			case '%' :
				res = op1 % op2;
				System.out.println("Result after %"+res);
				break;
			
			}
			flag = 0;
			op1 = 0;
			op2 = 0;
			t.setText(Integer.toString(res));
			nextOp=res;
		} 
		else {
			System.out.println("Calculator else block for button");
			
			Button temp = (Button) arg0.getSource();
			t.setText(t.getText()+temp.getLabel());
			char c =  t.getText().trim().charAt(t.getText().trim().length()-1);
			
			switch(c) {
			
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				if(nextOp!=0) {
					
					t.setText(Character.toString(c));
				}
				if(flag == 0) {
					
					op1 = op1*10 + Integer.parseInt(Character.toString(c));
					System.out.println("Getting op1:"+op1);
				}
				else {
					op2 = op2*10 + Integer.parseInt(Character.toString(c));
					System.out.println("Getting op2:"+op2);
				}
				break;
			case '+':
			case '-':
			case '/':
			case '*':
			case '%':
				if(nextOp!=0) {
					t.setText(Integer.toString(res));
					op1 = res;
				}				
				operator = c;
				flag = 1;
			break;
			}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
