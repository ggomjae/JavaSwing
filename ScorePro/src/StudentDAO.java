import java.sql.*;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class StudentDAO 
{
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/stu?&characterEncoding=UTF-8&serverTimezone=UTC";
	
	private static final String USER = "student_manager";
	private static final String PASS = "2018db";
	
	int count = 0 ; 
	int count_two = 0;
	int attendanceRatio =10;
	int midscoreRatio = 10;
	int finalscoreRatio = 10;
	int homeworkRatio = 10;
	int quizRatio = 10;
	int announceRatio = 10;
	int reportRatio = 10;
	int otherRatio = 10;
	
	
	
	double[] studentSumScore; 
	
	String[] idarray= new String[50];
	String[] namearray = new String[50];
	String[] resultSumarray = new String[50];
	double[] resultSumInt = new double[50];
	double sumScore = 0.0;
	
	
	Student_List sList;
	
	public StudentDAO() 
	{
		
	}
	public StudentDAO(int _attendanceRatio,int _midscoreRatio,int _finalscoreRatio,int _homeworkRatio,int _quizRatio,int _announceRatio,int _reportRatio,int _otherRatio) 
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
	
	public StudentDAO(Student_List sList)
	{
		this.sList = sList;
		System.out.println("DAO => " + sList);
	}
	
	public Connection getConn() 
	{
		Connection con = null;
		
		try
		{
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASS);
			
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return con;
	}
	
	public StudentDTO getStudentDTO(String id)  // DTO를 출력
	{
		StudentDTO dto = new StudentDTO();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			con = getConn();
			String sql = "select * from student where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id); //해당 DTO를 출력
			
			rs = ps.executeQuery(); 
			
			if(rs.next())
			{
				dto.setid(rs.getString("id")); 
				dto.setname(rs.getString("name"));
				dto.setattendance(rs.getString("attendance"));
				dto.setfinalscore(rs.getString("finalscore"));
				dto.sethomework(rs.getString("homework"));
				dto.setquiz(rs.getString("quiz"));
				dto.setannouncement(rs.getString("announcement"));
				dto.setmidscore(rs.getString("midscore"));
				dto.setreport(rs.getString("report"));
				dto.setother(rs.getString("other"));
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public Vector getStudentList() 
	{
		Vector data = new Vector();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			con = getConn();
			String sql = "select * from student order by name asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				
				String id = rs.getString("id");
				String name = rs.getString("name");
				String attendance = rs.getString("attendance");
				String midscore = rs.getString("midscore");
				String finalscore = rs.getString("finalscore");
				String homework = rs.getString("homework");
				String quiz = rs.getString("quiz");
				String announcement = rs.getString("announcement");
				String report = rs.getString("report");
				String other = rs.getString("other");
			
				Vector<String> row = new Vector();
				row.add(id);
				row.add(name);
				row.add(attendance);
				row.add(midscore);
				row.add(finalscore);
				row.add(homework);
				row.add(quiz);
				row.add(announcement);
				row.add(report);               // 점수임. 즉, 보고서 점수. 3개다 바뀜
				row.add(other);                // while 이기때문
				
				data.add(row);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	////////////////////////////////////////////////////////////////////////////////
	
	
	public Vector getRatioInformation()
	{
		Vector data = new Vector();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			con = getConn();
			String sql = "select * from student order by name asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				
				String id = rs.getString("id");
				String name = rs.getString("name");
				String attendance = rs.getString("attendance");
				String midscore = rs.getString("midscore");
				String finalscore = rs.getString("finalscore");
				String homework = rs.getString("homework");
				String quiz = rs.getString("quiz");
				String announcement = rs.getString("announcement");
				String report = rs.getString("report");
				String other = rs.getString("other");
				//////////////////////////////////////////////////////////////////  int To string 된다.
			
				attendance= multiplication(attendance ,attendanceRatio);
				midscore= multiplication(midscore , midscoreRatio);
				finalscore= multiplication(finalscore ,finalscoreRatio);
				homework= multiplication(homework , homeworkRatio);
				quiz= multiplication(quiz , quizRatio);
				announcement= multiplication(announcement, announceRatio);
				report= multiplication(report , reportRatio);
				other = multiplication(other , otherRatio);                             // 정수일때 무엇인가 행동해야함 + 라던지 X 라던지
				
				/////////////////////////////////////////////////////////////////
				Vector<String> row = new Vector();
				row.add(id);
				row.add(name);
				row.add(attendance);
				row.add(midscore);
				row.add(finalscore);
				row.add(homework);
				row.add(quiz);
				row.add(announcement);
				row.add(report);               
				row.add(other);                
				
				data.add(row);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	///////////////////////////////grah///////////////////////////////
	public int[] getGraph()
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int[] grapArray = new int[100];
		int con_count = 0;
		try 
		{
			con = getConn();
			String sql = "select * from student order by name asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				sumScore = 0;
				String id = rs.getString("id");
				String name = rs.getString("name");
				String attendance = rs.getString("attendance");
				String midscore = rs.getString("midscore");
				String finalscore = rs.getString("finalscore");
				String homework = rs.getString("homework");
				String quiz = rs.getString("quiz");
				String announcement = rs.getString("announcement");
				String report = rs.getString("report");
				String other = rs.getString("other");
				//////////////////////////////////////////////////////////////////  int To string 된다.
				
				attendance= multiplication(attendance ,attendanceRatio);
				midscore= multiplication(midscore , midscoreRatio);
				finalscore= multiplication(finalscore ,finalscoreRatio);
				homework= multiplication(homework , homeworkRatio);
				quiz= multiplication(quiz , quizRatio);
				announcement= multiplication(announcement, announceRatio);
				report= multiplication(report , reportRatio);
				other = multiplication(other , otherRatio);                             // 정수일때 무엇인가 행동해야함 + 라던지 X 라던지
				grapArray[con_count++] = (int)sumScore;
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return grapArray;
	}
	
	/////////////////////////SUM INFORMATION ///////////////////////////////////////
	public Vector getSUMInformation()
	{
		Vector data = new Vector();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			con = getConn();
			String sql = "select * from student order by name asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				sumScore = 0;
				String id = rs.getString("id");
				String name = rs.getString("name");
				String attendance = rs.getString("attendance");
				String midscore = rs.getString("midscore");
				String finalscore = rs.getString("finalscore");
				String homework = rs.getString("homework");
				String quiz = rs.getString("quiz");
				String announcement = rs.getString("announcement");
				String report = rs.getString("report");
				String other = rs.getString("other");
				//////////////////////////////////////////////////////////////////  int To string 된다.
				
				attendance= multiplication(attendance ,attendanceRatio);
				midscore= multiplication(midscore , midscoreRatio);
				finalscore= multiplication(finalscore ,finalscoreRatio);
				homework= multiplication(homework , homeworkRatio);
				quiz= multiplication(quiz , quizRatio);
				announcement= multiplication(announcement, announceRatio);
				report= multiplication(report , reportRatio);
				other = multiplication(other , otherRatio);                             // 정수일때 무엇인가 행동해야함 + 라던지 X 라던지
				
				String resultSum = Double.toString(sumScore);
				/////////////////////////////////////////////////////////////////
				Vector<String> row = new Vector();
				row.add(id);
				row.add(name);
				row.add(resultSum);         
				
				data.add(row);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	/////////////////////////////////////// 총 합계 평균 내는 
	public Vector getSUMAVGInformation()
	{
		Vector data = new Vector();
		count_two = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			con = getConn();
			String sql = "select * from student order by name asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			double avgSum =0 ;
			
			while(rs.next())
			{
				sumScore = 0;
				String id = rs.getString("id");
				String name = rs.getString("name");
				String attendance = rs.getString("attendance");
				String midscore = rs.getString("midscore");
				String finalscore = rs.getString("finalscore");
				String homework = rs.getString("homework");
				String quiz = rs.getString("quiz");
				String announcement = rs.getString("announcement");
				String report = rs.getString("report");
				String other = rs.getString("other");
				//////////////////////////////////////////////////////////////////  int To string 된다.
				
				attendance= multiplication(attendance ,attendanceRatio);
				midscore= multiplication(midscore , midscoreRatio);
				finalscore= multiplication(finalscore ,finalscoreRatio);
				homework= multiplication(homework , homeworkRatio);
				quiz= multiplication(quiz , quizRatio);
				announcement= multiplication(announcement, announceRatio);
				report= multiplication(report , reportRatio);
				other = multiplication(other , otherRatio);                             // 정수일때 무엇인가 행동해야함 + 라던지 X 라던지
				avgSum += sumScore;
				
				String resultSum = Double.toString(sumScore);
				/////////////////////////////////////////////////////////////////
				//Vector<String> row = new Vector();
				//row.add(id);
				//row.add(name);
				//row.add(resultSum);         
				//count++;
				count_two++;
				
			}
			avgSum = avgSum/count_two;
			avgSum = Double.parseDouble(String.format("%.2f",avgSum));

			String avgSumString = Double.toString(avgSum);
			Vector<String> row = new Vector();
			row.add(avgSumString);
			data.add(row);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	/////////////////////////////////////
	public Vector getRATINGInformation(int _aascoreRatio,int _ascoreRatio,int _bbscoreRatio,int _bscoreRatio,int _ccscoreRatio,int _cscoreRatio,int _ddscoreRatio,int _dscoreRatio)
	{
		Vector data = new Vector();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			con = getConn();
			String sql = "select * from student order by name asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			
			while(rs.next())
			{
				sumScore = 0;
				String id = rs.getString("id");
				String name = rs.getString("name");
				String attendance = rs.getString("attendance");
				String midscore = rs.getString("midscore");
				String finalscore = rs.getString("finalscore");
				String homework = rs.getString("homework");
				String quiz = rs.getString("quiz");
				String announcement = rs.getString("announcement");
				String report = rs.getString("report");
				String other = rs.getString("other");
				//////////////////////////////////////////////////////////////////  int To string 된다.
				
				attendance= multiplication(attendance ,attendanceRatio);
				midscore= multiplication(midscore , midscoreRatio);
				finalscore= multiplication(finalscore ,finalscoreRatio);
				homework= multiplication(homework , homeworkRatio);
				quiz= multiplication(quiz , quizRatio);
				announcement= multiplication(announcement, announceRatio);
				report= multiplication(report , reportRatio);
				other = multiplication(other , otherRatio);                             // 정수일때 무엇인가 행동해야함 + 라던지 X 라던지
				
				String resultSum = Double.toString(sumScore);
				/////////////////////////////////////////////////////////////////
				//Vector<String> row = new Vector();
				//row.add(id);
				
				idarray[count] = id;
				//row.add(name);
				namearray[count] = name;
				//row.add(resultSum);         
				resultSumarray[count] = resultSum;
				//resultSumInt[count] = sumScore;
				count++;
				//data.add(row);
				
			}
			//////////////////////////통계내기///////////////////////////////////////
			changeToint();
			sortScore(count);
			/////////////////////////////////////////////////////////////////
			//  double stand = (count * 30)/100.0  // 30은 적용 점수
			//////////////////////////////////////////////////////////
			
			int scoreResult = _aascoreRatio;
			double standA = (count * scoreResult)/100.0;
			
			scoreResult += _ascoreRatio;
			double standA0 = (count * scoreResult)/100.0;
			
			scoreResult += _bbscoreRatio;
			double standB = (count * scoreResult)/100.0;
			
			scoreResult += _bscoreRatio;
			double standB0 = (count * scoreResult)/100.0;
			
			scoreResult += _ccscoreRatio;
			double standC = (count * scoreResult)/100.0;
			
			scoreResult += _cscoreRatio;
			double standC0 = (count * scoreResult)/100.0;
			
			scoreResult += _ddscoreRatio;
			double standD = (count * scoreResult)/100.0;
			
			scoreResult += _dscoreRatio;
			double standD0 = (count * scoreResult)/100.0;
			//////////////////////////////////////////////////////////
			for(int index = count-1 ; index >= 0; --index)
			{
				Vector<String> row = new Vector();
				row.add(idarray[index]);
				row.add(namearray[index]);
				row.add(count-index+"등");
				///////////////////////////////
				if(count-index <= standA )
				{
					row.add("A+");
				}
				else if(count-index <= standA0 )
				{
					row.add("AO");
				}
				
				else if(count-index <= standB )
				{
					row.add("B+");
				}
				
				else if(count-index <= standB0 )
				{
					row.add("BO");
				}
				
				else if(count-index <= standC)
				{
					row.add("C+");
				}
				
				else if(count-index <= standC0 )
				{
					row.add("C0");
				}
				
				else if(count-index <= standD )
				{
					row.add("D+");
				}
				
				else if(count-index <= standD0 )
				{
					row.add("D0");
				}
				else
				{
					row.add("F");
				}
				
				/////////////////////////////////
				data.add(row);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		count = 0 ;
		return data;
	}
	
	////////////////////////////////////////////////////////////////////////////////
	public boolean insertStudent(StudentDTO dto) 
	{
		
		boolean ok = false;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try 
		{
			con = getConn();
			String sql = "insert into student(" + "id , name , attendance , midscore , finalscore , homework , quiz , announcement , report , other)" + "values(?,?,?,?,?,?,?,?,?,?)";
			
			ps = con.prepareStatement(sql); 
			ps.setString(1, dto.getid());
			ps.setString(2, dto.getname());
			ps.setString(3, dto.getattendance());
			ps.setString(4, dto.getmidscore());
			ps.setString(5, dto.getfinalscore());
			ps.setString(6, dto.gethomework());
			ps.setString(7, dto.getquiz());
			ps.setString(8, dto.getannouncement());
			ps.setString(9, dto.getreport());
			ps.setString(10, dto.getother());
			
			int r = ps.executeUpdate();
			
			if(r>0) 
			{
				//System.out.println("학생 입력 성공");
				ok = true;
			}
			else
			{
				System.out.println("학생 입력 실패");
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return ok;
	}
	public String multiplication(String _string,int per)////////////////////////< 변수변환
	{
		int a = Integer.parseInt(_string);
		double d = (a*per)/(double)100;
		sumScore += d;
		_string = Double.toString(d);
		return _string;
	}
	public boolean updateStudent(StudentDTO vStu) 
	{
		//System.out.println("dto = " + vStu.toString()); 
		boolean ok = false;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try
		{
			con = getConn();  
			String sql = "update student set  midscore=?, finalscore=?, homework=?, quiz=?, announcement=?, report=?, other=?" + "where id=?";
			/////
			ps = con.prepareStatement(sql);
			
			//ps.setString(1, vStu.getid());//
			//ps.setString(2, vStu.getname());
			//ps.setString(3, vStu.getattendance());
			ps.setString(1, vStu.getmidscore());
			ps.setString(2, vStu.getfinalscore());
			ps.setString(3, vStu.gethomework());
			ps.setString(4, vStu.getquiz());
			ps.setString(5, vStu.getannouncement());
			ps.setString(6, vStu.getreport());
			ps.setString(7, vStu.getother());
			ps.setString(8, vStu.getid());
			int r = ps.executeUpdate();
			
			if(r>0) ok = true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ok;
	}
	/////////////////////////////////////////////////2018-12-04 출석을 업데이트 시키는.데이터베이스
	public boolean updateAb(StudentDTO vStu)
	{
	boolean ok = false;
	
	Connection con = null;
	PreparedStatement ps = null;
	
	try
	{
		con = getConn();  
		String sql = "update student set  attendance=? " + "where id=?";
		/////
		ps = con.prepareStatement(sql);
		
		
		ps.setString(1, vStu.getattendance());
		ps.setString(2, vStu.getid());
		
			
		int r = ps.executeUpdate();
		
		if(r>0) ok = true;
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return ok;
}
	/////////////////////////////////////////
	public void changeToint()
	{
		for(int index =0 ; index < count; ++index)
		{
			resultSumInt[index] = Double.parseDouble(resultSumarray[index]);
		}
	}
	//////////////////////////////////////////////////////////////////
	public void sortScore(int _count)
	{
		for(int index =0 ; index < count ;++index)
		{
			double min = resultSumInt[index];
			int temp = index;
			double changeNumber ;
			String changeString;
			
			for(int Inindex =index+1 ; Inindex < count; ++Inindex)
			{
				if(min > resultSumInt[Inindex])
				{
					min = resultSumInt[Inindex];
					temp = Inindex;
				}
			}
			
			
			changeNumber = resultSumInt[index];
			resultSumInt[index] = resultSumInt[temp];
			resultSumInt[temp] = changeNumber;
			
			changeString = idarray[index];
			idarray[index] = idarray[temp];
			idarray[temp] = changeString;
			
			changeString = namearray[index];
			namearray[index] = namearray[temp];
			namearray[temp] = changeString;
			
			changeString = resultSumarray[index];
			resultSumarray[index] = resultSumarray[temp];
			resultSumarray[temp] = changeString;
			
			//////////////////////////////////////////
		}
	}
	
	
	/////////////////////////////////////////
	public boolean deleteStudent(String id)
	{
		boolean ok = false;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try
		{
			con = getConn();
			String sql = "delete from student where id=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			int r = ps.executeUpdate();
			
			if(r>0) ok = true;
			
		}
		catch(Exception e)
		{
			System.out.println(e+"->오류 발생!");;
		}
		return ok;
	}
	
	public void stuSelectAll(DefaultTableModel model) 
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try
		{
			con = getConn();
			String sql = "select * from student order by name asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			for(int i =0;i<model.getRowCount();)
			{
				model.removeRow(0);
			}
			
			while(rs.next()) 
			{                              
				Object data[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)};
				
				model.addRow(data);
			}
		} 
		catch(SQLException e)
		{
			System.out.println(e + "=> userSelectAll fail");
		}
		finally 
		{
			if(rs !=null)
				try {
					rs.close();
				}catch(SQLException e2) {
					e2.printStackTrace();
				}
				
			if(ps !=null)
				try {
					ps.close();
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			if(con !=null)
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
		}
		
	}


}
