import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ApplyRatio extends JFrame implements ActionListener
{
	JPanel p;
	JTextField tfattendance,tfmidscore ,tffinalscore , tfhomework ,tfquiz , tfannouncement , tfreport , tfother;
	JButton btnInsert;
	
	GridBagLayout gb;
	GridBagConstraints gbc;
	
	Student_List sList;
	StudentDAO dao;
	private void createUI()
	{

		
		
		gb = new GridBagLayout();
		setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		JLabel battendance = new JLabel("출석 :");
		tfattendance = new JTextField(10);
		gbAdd(battendance,0,2,1,1);
		gbAdd(tfattendance,1,2,3,1);
		
		JLabel bmidscore = new JLabel("중간점수 :");
		tfmidscore = new JTextField(10);
		gbAdd(bmidscore,0,3,1,1);
		gbAdd(tfmidscore,1,3,3,1);
		
		JLabel bfinalscore = new JLabel("기말점수 :");
		tffinalscore = new JTextField(10);
		gbAdd(bfinalscore,0,4,1,1);
		gbAdd(tffinalscore,1,4,3,1);
		
		JLabel bhomework = new JLabel("과제 :");
		tfhomework = new JTextField(10);
		gbAdd(bhomework,0,5,1,1);
		gbAdd(tfhomework,1,5,3,1);
		
		JLabel bquiz = new JLabel("퀴즈 :");
		tfquiz = new JTextField(10);
		gbAdd(bquiz,0,6,1,1);
		gbAdd(tfquiz,1,6,3,1);
		
		JLabel bannouncement = new JLabel("발표 :");
		tfannouncement = new JTextField(10);
		gbAdd(bannouncement,0,7,1,1);
		gbAdd(tfannouncement,1,7,3,1);
		
		JLabel breport = new JLabel("보고서 :");
		tfreport = new JTextField(10);
		gbAdd(breport,0,8,1,1);
		gbAdd(tfreport,1,8,3,1);
		
		JLabel bother = new JLabel("기타 :");
		tfother = new JTextField(10);
		gbAdd(bother,0,9,1,1);
		gbAdd(tfother,1,9,3,1);
		
		
		
		
		///////////////////////////////////////////////////// 버튼부분
		JPanel pButton = new JPanel();
		btnInsert = new JButton("적용");
		pButton.add(btnInsert);
		gbAdd(pButton,1,10,4,1);
		btnInsert.addActionListener(this);
		//////////////////////////////////////////////////////
		//setSize(1000,1000);
		setVisible(true);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public ApplyRatio(Student_List sList)
	{
		super("비율 적용");
		JFrame f = new JFrame();
		this.sList = sList;
		///////////////////////////////////
		
		createUI();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width/5)-(this.getWidth()/5), (dim.height/5)-(this.getHeight()/5));
		///////////////////////////////////
		setSize(350,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//new ApplyRatio();
	}
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnInsert)
		{
			apply();
		}
		
	}
	
	private void gbAdd(JComponent c, int x, int y, int w, int h) 
	{
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gb.setConstraints(c, gbc);
		gbc.insets = new Insets(2,2,2,2);
		add(c,gbc);
		
	}
	
	private void apply() 
	{
		String attendance = tfattendance.getText();
		String finalscore = tffinalscore.getText();
		String homework = tfhomework.getText();
		String quiz = tfquiz.getText();       
		String announcement = tfannouncement.getText();
		String report = tfreport.getText();
		String midscore = tfmidscore.getText();
		String other = tfother.getText();
		
		int _attendanceRatio= Integer.parseInt(attendance);
		int _midscoreRatio = Integer.parseInt(midscore);
		int _finalscoreRatio = Integer.parseInt(finalscore);
		int _homeworkRatio = Integer.parseInt(homework);
		int _quizRatio = Integer.parseInt(quiz);
		int _announceRatio = Integer.parseInt(announcement);
		int _reportRatio = Integer.parseInt(midscore);
		int _otherRatio = Integer.parseInt(other);
		
		sList.setTemp(_attendanceRatio,_midscoreRatio,_finalscoreRatio,_homeworkRatio,_quizRatio,_announceRatio,_reportRatio,_otherRatio);
		sList.setDAO();
		
		JOptionPane.showMessageDialog(this, "적용이 완료되었습니다."); 
		dispose();
				
	}
	
	

}
