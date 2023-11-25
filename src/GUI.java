import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI {
	private JFrame frame;
	private JLabel label1;
	private JTextField txt1;
	private JTextArea area;
	private JButton btn1;

	GUI() {
		frame = new JFrame();

		label1 = new JLabel("Enter list here");
		label1.setBounds(50, 40, 100, 40);

		txt1 = new JTextField();
		txt1.setBounds(30, 90, 120, 30);

		area = new JTextArea();

		area.setBounds(20, 140, 260, 200);
		area.setEnabled(false);

		btn1 = new JButton("Add");
		btn1.setBounds(160,90,100,30);
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					String item = txt1.getText();
					
					if (txt1.getText().equals("")) {
						throw new Exception("Text field is required");
					}
					else {
						area.append(item + "\n" );
						txt1.setText("");
					}
				}catch (Exception error) {
					System.out.println(error.getMessage());
//					JOptionPane.showMessageDialog(frame,error.getMessage(),"Alert", JOptionPane.WARNING_MESSAGE);
					JOptionPane.showMessageDialog(null, error.getMessage(), "Information", JOptionPane.INFORMATION_MESSAGE);
					//WARNING_MESSAGE
					//ERROR_MESSAGE
					//INFORMATION_MESSAGE
				}
				
			}
			
		});
		
		
		frame.add(btn1);
		frame.add(area);
		frame.add(txt1);
		frame.add(label1);
		frame.setLayout(null);
		frame.setSize(325, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Textarea");
	}
}
