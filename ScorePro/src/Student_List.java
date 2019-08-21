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
	int attendanceRatio = 10 ;//디폴트값
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
	
	
	StudentDAO dao = new StudentDAO(); //////// 이게 바뀌는거다.
	
	public Student_List() 
	{ 
		super("학생관리");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width/5)-(this.getWidth()/5), (dim.height/5)-(this.getHeight()/5));
		//StudentDAO dao = new StudentDAO();
		StudentDAO dao = new StudentDAO(); 
		v = dao.getStudentList(); // 현재 DB를 갖고오는거네.
		//System.out.println("v="+v);
		cols = getColumn();
		
		model = new DefaultTableModel(v,cols);
		
		jTable = new JTable(model);
		pane = new JScrollPane(jTable);
		add(pane);
		
		pbtn1 = new JPanel();
		pbtn2 = new JPanel();
		btnInsert = new JButton("학생등록");
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
		col.add("학번");
		col.add("이름");
		col.add("출결");
		col.add("중간");
		col.add("기말");
		col.add("과제");
		col.add("퀴즈");
		col.add("발표");
		col.add("보고서");
		col.add("기타");
		
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
		JMenu m1 = new JMenu("파일");
		JMenu m2 = new JMenu("입력");
		JMenu m3 = new JMenu("실행");
		JMenu m4 = new JMenu("설정");
		JMenu m5 = new JMenu("학생");
		
		//m1.add(new JMenuItem("새 파일"));
		//JMenuItem m1Open = new JMenuItem("열기");
		//m1Open.addActionListener(new OpenActionListener());
		//JMenuItem m1Save = new JMenuItem("저장");
		//m1.addSeparator();
		//JMenuItem m1Exit = new JMenuItem("종료");
		
		//m1.add(m1Open);
		//m1.add(m1Save);
		//m1.add(m1Exit);
		
		
		//m2.add(new JMenuItem("출석 점수 입력"));
		//m2.add(new JMenuItem("시험 점수 입력"));
		//m2.add(new JMenuItem("과제 점수 입력"));
		//m2.add(new JMenuItem("퀴즈 점수 입력"));
		//m2.add(new JMenuItem("발표 점수 입력"));
		//m2.add(new JMenuItem("보고서 점수 입력"));
		//m2.addSeparator();
		//m2.add(new JMenuItem("기타 점수 입력"));
		//m2.add(new JMenuItem("일괄 점수 입력"));
		///////////////////////////////////////////////
		m2Attendance = new JMenuItem("출석 수정");
		m2.add(m2Attendance);
		m2Attendance.addActionListener(this);
		//////////////////////////////////////////////이거바꾸고 action쪽으로가면돼
		m3RatioScore = new JMenuItem("비율 적용 점수");
		m3.add(m3RatioScore);
		m3RatioScore.addActionListener(this);
		
			
		m3RatingScore = new JMenuItem("등급 및 등수 점수");
		m3.add(m3RatingScore);
		m3RatingScore.addActionListener(this);
		
		m3SumScore = new JMenuItem("총 합계 점수");
		m3.add(m3SumScore);
		m3SumScore.addActionListener(this);
		
		m3SumAvgScore = new JMenuItem("총 합계 평균 점수");
		m3.add(m3SumAvgScore);
		m3SumAvgScore.addActionListener(this);
		
		m3grapic = new JMenuItem("합계 그래프");
		m3.add(m3grapic);
		m3grapic.addActionListener(this);
		
		//////////////////////////////////////////////
		
		//m3.add(new JMenuItem("등급 계산"));
		//m3.add(new JMenuItem("총점 평균 계산"));
		//m3.add(new JMenuItem("총점 및 등급 계산"));
		//m3.addSeparator();
		//m3.add(new JMenuItem("점수 분포 그래프"));
		
		
		////////////////////////////////////////////////
		m4ApplyRatio = new JMenuItem("점수 비율 설정");
		m4.add(m4ApplyRatio);
		m4ApplyRatio.addActionListener(this);
		
		m4ScoreRatio = new JMenuItem("등급 비율 설정");
		m4.add(m4ScoreRatio);
		m4ScoreRatio.addActionListener(this);
		///////////////////////////////////////////////
		//m4.add(new JMenuItem("등급 비율 설정"));
		
		//m5.add(new JMenuItem("수강학생"));
		
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		//mb.add(m5);
		
		//m3로 시작
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
		////////////////////////////////// ------------등급 비율 적용
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
		
		if(e.getSource()==btnInsert)// btnInsert는 밖변수임
		{
			new StudentProc(this); // this 이유는 연결시키는거임 List와 StProc과
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
