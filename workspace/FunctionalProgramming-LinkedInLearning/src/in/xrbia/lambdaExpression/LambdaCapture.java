package in.xrbia.lambdaExpression;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class LambdaCapture {
	
	private final static int FIELD_WIDTH = 20;
	private static JTextField staticTextField;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		staticTextField = new JTextField(FIELD_WIDTH);
		staticTextField.setText("Static Field");
		
		JTextField localTextField = new JTextField(FIELD_WIDTH);
		localTextField.setText("Local Variable");
		
		JButton helloButton = new JButton("Say Hello");
		
		//For this we use regaula anonumous class.
		helloButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				staticTextField.setText("Hello World");
				localTextField.setText("Hello World");
			}
		});
		
		// For this we use lambda expression.
		JButton goodbyeButton = new JButton("Say Goodbye");
		goodbyeButton.addActionListener(event -> {
			staticTextField.setText("Goodbye World");
			localTextField.setText("Goodbye World");
		});
		
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(staticTextField);
		contentPane.add(localTextField);
		contentPane.add(helloButton);
		contentPane.add(goodbyeButton);
		
		// both access the same copy of static text field.
		staticTextField = null;
		// compilation error as lambda expression like annonymous inner class had constraint on using local variable.
		localTextField = null;
		
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}

}
