import javax.swing.*;

import java.awt.event.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;



import java.awt.event.*;
import java.awt.*;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;

public class Student_List extends JFrame implements MouseListener,ActionListener
{
	JLabel fileLabel = new JLabel();
	Vector v;
	Vector cols;
	DefaultTableModel model;
	JTable jTable;
	JScrollPane pane;
	JPanel pbtn1,pbtn2;
	JButton btnInsert;
	JMenuItem m3RatioScore ;
	JMenuItem m3SumScore;
	JMenuItem m3RatingScore;
	JMenuItem m3SumAvgScore;
	JMenuItem m4ApplyRatio;
	JMenuItem m4ScoreRatio;
	JMenuItem m2Attendance;//
	JMenuItem m3grapic;
	////////////////////////////////////////
	int attendanceRatio = 10 ;//����Ʈ��
	int midscoreRatio = 10 ;
	int finalscoreRatio =10 ;
	int homeworkRatio = 10 ;
	int quizRatio = 10 ;
	int announceRatio = 10 ;
	int reportRatio = 10 ;
	int otherRatio = 10 ;
	
	int aascoreRatio = 10;
	int ascoreRatio = 10;
	int bbscoreRatio =10;
	int bscoreRatio = 10;
	int ccscoreRatio = 10;
	int cscoreRatio = 10;
	int ddscoreRatio = 10;
	int dscoreRatio =10;
	//////////////////////////////////////////
	
	
	StudentDAO dao = new StudentDAO(); //////// �̰� �ٲ�°Ŵ�.
	
	public Student_List() 
	{ 
		super("�л�����");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width/5)-(this.getWidth()/5), (dim.height/5)-(this.getHeight()/5));
		//StudentDAO dao = new StudentDAO();
		StudentDAO dao = new StudentDAO(); 
		v = dao.getStudentList(); // ���� DB�� ������°ų�.
		//System.out.println("v="+v);
		cols = getColumn();
		
		model = new DefaultTableModel(v,cols);
		
		jTable = new JTable(model);
		pane = new JScrollPane(jTable);
		add(pane);
		
		pbtn1 = new JPanel();
		pbtn2 = new JPanel();
		btnInsert = new JButton("�л����");
		pbtn1.add(btnInsert);
	
		add(pbtn1,BorderLayout.SOUTH);

		jTable.addMouseListener(this);
		btnInsert.addActionListener(this);
		makeMenu();
		
		setSize(1500,700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public Vector getColumn() 
	{
		Vector col = new Vector();
		col.add("�й�");
		col.add("�̸�");
		col.add("���");
		col.add("�߰�");
		col.add("�⸻");
		col.add("����");
		col.add("����");
		col.add("��ǥ");
		col.add("����");
		col.add("��Ÿ");
		
		return col;
	}
	
	public void jTableRefresh() 
	{
		StudentDAO dao = new StudentDAO();
		DefaultTableModel model = new DefaultTableModel(dao.getStudentList(),getColumn());
		jTable.setModel(model);
		
	}
	
	public void makeMenu()
	{
	
		JMenuItem item;	
		KeyStroke key;
		
		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu("����");
		JMenu m2 = new JMenu("�Է�");
		JMenu m3 = new JMenu("����");
		JMenu m4 = new JMenu("����");
		JMenu m5 = new JMenu("�л�");
		
		//m1.add(new JMenuItem("�� ����"));
		//JMenuItem m1Open = new JMenuItem("����");
		//m1Open.addActionListener(new OpenActionListener());
		//JMenuItem m1Save = new JMenuItem("����");
		//m1.addSeparator();
		//JMenuItem m1Exit = new JMenuItem("����");
		
		//m1.add(m1Open);
		//m1.add(m1Save);
		//m1.add(m1Exit);
		
		
		//m2.add(new JMenuItem("�⼮ ���� �Է�"));
		//m2.add(new JMenuItem("���� ���� �Է�"));
		//m2.add(new JMenuItem("���� ���� �Է�"));
		//m2.add(new JMenuItem("���� ���� �Է�"));
		//m2.add(new JMenuItem("��ǥ ���� �Է�"));
		//m2.add(new JMenuItem("���� ���� �Է�"));
		//m2.addSeparator();
		//m2.add(new JMenuItem("��Ÿ ���� �Է�"));
		//m2.add(new JMenuItem("�ϰ� ���� �Է�"));
		///////////////////////////////////////////////
		m2Attendance = new JMenuItem("�⼮ ����");
		m2.add(m2Attendance);
		m2Attendance.addActionListener(this);
		//////////////////////////////////////////////�̰Źٲٰ� action�����ΰ����
		m3RatioScore = new JMenuItem("���� ���� ����");
		m3.add(m3RatioScore);
		m3RatioScore.addActionListener(this);
		
			
		m3RatingScore = new JMenuItem("��� �� ��� ����");
		m3.add(m3RatingScore);
		m3RatingScore.addActionListener(this);
		
		m3SumScore = new JMenuItem("�� �հ� ����");
		m3.add(m3SumScore);
		m3SumScore.addActionListener(this);
		
		m3SumAvgScore = new JMenuItem("�� �հ� ��� ����");
		m3.add(m3SumAvgScore);
		m3SumAvgScore.addActionListener(this);
		
		m3grapic = new JMenuItem("�հ� �׷���");
		m3.add(m3grapic);
		m3grapic.addActionListener(this);
		
		//////////////////////////////////////////////
		
		//m3.add(new JMenuItem("��� ���"));
		//m3.add(new JMenuItem("���� ��� ���"));
		//m3.add(new JMenuItem("���� �� ��� ���"));
		//m3.addSeparator();
		//m3.add(new JMenuItem("���� ���� �׷���"));
		
		
		////////////////////////////////////////////////
		m4ApplyRatio = new JMenuItem("���� ���� ����");
		m4.add(m4ApplyRatio);
		m4ApplyRatio.addActionListener(this);
		
		m4ScoreRatio = new JMenuItem("��� ���� ����");
		m4.add(m4ScoreRatio);
		m4ScoreRatio.addActionListener(this);
		///////////////////////////////////////////////
		//m4.add(new JMenuItem("��� ���� ����"));
		
		//m5.add(new JMenuItem("�����л�"));
		
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		//mb.add(m5);
		
		//m3�� ����
		setJMenuBar(mb);
	}
	public void setTemp(int _attendanceRatio,int _midscoreRatio,int _finalscoreRatio,int _homeworkRatio,int _quizRatio,int _announceRatio,int _reportRatio,int _otherRatio)
	{
		attendanceRatio = _attendanceRatio;
		midscoreRatio = _midscoreRatio;
		finalscoreRatio =_finalscoreRatio;
		homeworkRatio = _homeworkRatio ;
		quizRatio = _quizRatio;
		announceRatio = _announceRatio;
		reportRatio = _reportRatio;
		otherRatio =_otherRatio;
	}
	//////////////////////////////////////////
	
	public void setScoreRatio(int _aascoreRatio,int _ascoreRatio,int _bbscoreRatio,int _bscoreRatio,int _ccscoreRatio,int _cscoreRatio,int _ddscoreRatio,int _dscoreRatio)
	{
		aascoreRatio = _aascoreRatio;
		ascoreRatio = _ascoreRatio;
		bbscoreRatio =_bbscoreRatio;
		bscoreRatio = _bscoreRatio ;
		ccscoreRatio = _ccscoreRatio;
		cscoreRatio = _cscoreRatio;
		ddscoreRatio = _ddscoreRatio;
		dscoreRatio =_dscoreRatio;
	}
	//////////////////////////////////////////
	
	public static void main(String[] args) 
	{
		
		
		//new Student_List();
	}

	@Override 
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()== m2Attendance)
		{
			new ApplyAttendanceRatio(this);
		}
		
		if(e.getSource()== m4ApplyRatio)
		{
			new ApplyRatio(this);
		}
		////////////////////////////////// ------------��� ���� ����
		if(e.getSource()== m4ScoreRatio)
		{
			new ApplyScoreRatio(this);
		}
		/////////////////////////////////
		if(e.getSource()== m3RatioScore)
		{
			
			new OpenIndi(this,attendanceRatio,midscoreRatio,finalscoreRatio,homeworkRatio,quizRatio,announceRatio,reportRatio,otherRatio);
		}
		
		if(e.getSource()== m3SumScore)
		{
			new OpenSum(this,dao);
		}
		
		if(e.getSource()== m3RatingScore) /////////////////
		{
			new OpenRating(this,dao,aascoreRatio, ascoreRatio, bbscoreRatio, bscoreRatio, ccscoreRatio, cscoreRatio, ddscoreRatio, dscoreRatio);
		}
		
		if(e.getSource()==btnInsert)// btnInsert�� �ۺ�����
		{
			new StudentProc(this); // this ������ �����Ű�°��� List�� StProc��
		}
		//////////////////////////////////
		if(e.getSource()== m3SumAvgScore)
		{
			new OpenSumAvgScore(this,dao);
		}
		
		if(e.getSource() == m3grapic)
		{
			new GraphSum(this,dao);
		}
	}
	

	@Override
	public void mouseClicked(MouseEvent e) 
	{

		int r = jTable.getSelectedRow();
		String id = (String)jTable.getValueAt(r, 0);
		StudentProc stu = new StudentProc(id,this);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void setDAO()
	{
		dao = new StudentDAO(attendanceRatio,midscoreRatio,finalscoreRatio,homeworkRatio,quizRatio,announceRatio,reportRatio,otherRatio);
	}
	
	
}
