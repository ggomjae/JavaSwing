import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class StartScreen extends JFrame implements ActionListener
{
	private String id = "이성규";
	private String password = "123123";
	private JTextField tf;
	private JPasswordField pf;
	private JButton StartScreen;
	JLabel StartScreenText = new JLabel();
	private boolean isStartScreen = false;

	public StartScreen() 
	{
		JPanel idPanel = new JPanel();
		JPanel passPanel = new JPanel();
		tf = new JTextField(12);
		pf = new JPasswordField(10);
		StartScreenText.setForeground(Color.RED);

		JLabel idLabel = new JLabel("ID : ");
		
		JLabel passLabel = new JLabel("PASSWORD : ");
		StartScreen = new JButton("StartScreen");
		StartScreen.addActionListener(this);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width/5)-(this.getWidth()/5), (dim.height/5)-(this.getHeight()/5));
		
		idPanel.add(idLabel);
		idPanel.add(tf);

		passPanel.add(passLabel);
		passPanel.add(pf);

		this.add(idPanel);
		this.add(passPanel);
		this.add(StartScreen);
		this.add(StartScreenText);

		setLayout(new FlowLayout());
		setResizable(false);
		setTitle("StartScreen");
		setSize(1000, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
	}


	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if (e.getSource() == StartScreen)
		{
			try 
			{
				if (id.equals(tf.getText()) && password.equals(pf.getText()))
					isStartScreen = true;
				else
					isStartScreen = false;
				if (isStartScreen) 
				{
					JOptionPane.showMessageDialog(this, "환영합니다");
					new Student_List();
					this.dispose();
				} 
				else
				{
					StartScreenText.setText("ID 또는 password가 잘못되었습니다.");
					
				}
			} catch (Exception e1)
			{
				System.out.println("false");
			}
		}
	}

	public static void main(String[] args)
	{
		
	}
}
