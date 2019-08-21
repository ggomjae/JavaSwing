import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;

public class StudentProc extends JFrame implements ActionListener
{
	
	JPanel p;
	JTextField tfid,tfname,tfattendance,tfmidscore ,tffinalscore , tfhomework ,tfquiz , tfannouncement , tfreport , tfother;
	JButton btnInsert, btnCancel, btnUpdate, btnDelete;
	
	
	
	GridBagLayout gb;
	GridBagConstraints gbc;
	Student_List sList;
	
	public StudentProc()  // 학생등록시 
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width/5)-(this.getWidth()/5), (dim.height/5)-(this.getHeight()/5));
		createUI();
		btnUpdate.setEnabled(false);
		btnUpdate.setVisible(false);
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);
		
	}
	
	public StudentProc(Student_List sList)
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width/5)-(this.getWidth()/5), (dim.height/5)-(this.getHeight()/5));
		createUI();
		btnUpdate.setEnabled(false);
		btnUpdate.setVisible(false);
		btnDelete.setEnabled(false); 
		btnDelete.setVisible(false);
		this.sList = sList;
	}
	
	public StudentProc(String id,Student_List sList) //////// 마우스 클릭시 
	{
		createUI();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width/5)-(this.getWidth()/5), (dim.height/5)-(this.getHeight()/5));
		btnInsert.setEnabled(false);
		btnInsert.setVisible(false);
		//////////////////////////////////
		//btnUpdate.setEnabled(false);
		//btnUpdate.setVisible(false);
		//btnDelete.setEnabled(false); 
		//btnDelete.setVisible(false);
		///////////////////////////////
		this.sList = sList;
		
		//System.out.println("id=" + id);
		
		StudentDAO dao = new StudentDAO();
		StudentDTO vStu = dao.getStudentDTO(id);
		viewData(vStu);

	}
	
	
	private void createUI()
	{

		this.setTitle("학생정보");
		gb = new GridBagLayout();
		setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		JLabel bid = new JLabel("학번  ");
		tfid = new JTextField(10);
		gbAdd(bid,0,0,1,1);
		gbAdd(tfid,1,0,3,1);
		
		JLabel bname = new JLabel("이름  ");
		tfname = new JTextField(10);
		gbAdd(bname,0,1,1,1);
		gbAdd(tfname,1,1,3,1);
		
		JLabel battendance = new JLabel("출석  ");
		tfattendance = new JTextField(10);
		gbAdd(battendance,0,2,1,1);
		gbAdd(tfattendance,1,2,3,1);
		
		JLabel bmidscore = new JLabel("중간점수  ");
		tfmidscore = new JTextField(10);
		gbAdd(bmidscore,0,3,1,1);
		gbAdd(tfmidscore,1,3,3,1);
		
		JLabel bfinalscore = new JLabel("기말점수  ");
		tffinalscore = new JTextField(10);
		gbAdd(bfinalscore,0,4,1,1);
		gbAdd(tffinalscore,1,4,3,1);
		
		JLabel bhomework = new JLabel("과제  ");
		tfhomework = new JTextField(10);
		gbAdd(bhomework,0,5,1,1);
		gbAdd(tfhomework,1,5,3,1);
		
		JLabel bquiz = new JLabel("퀴즈  ");
		tfquiz = new JTextField(10);
		gbAdd(bquiz,0,6,1,1);
		gbAdd(tfquiz,1,6,3,1);
		
		JLabel bannouncement = new JLabel("발표  ");
		tfannouncement = new JTextField(10);
		gbAdd(bannouncement,0,7,1,1);
		gbAdd(tfannouncement,1,7,3,1);
		
		JLabel breport = new JLabel("보고서  ");
		tfreport = new JTextField(10);
		gbAdd(breport,0,8,1,1);
		gbAdd(tfreport,1,8,3,1);
		
		JLabel bother = new JLabel("기타  ");
		tfother = new JTextField(10);
		gbAdd(bother,0,9,1,1);
		gbAdd(tfother,1,9,3,1);
		
		
		JPanel pButton = new JPanel();
		btnInsert = new JButton("추가"); //
		btnUpdate = new JButton("수정");
		btnDelete = new JButton("삭제");
		btnCancel = new JButton("취소"); //
		pButton.add(btnInsert); //
		pButton.add(btnUpdate);
		pButton.add(btnDelete);
		pButton.add(btnCancel); //
		gbAdd(pButton,1,10,4,1);//
		
		btnInsert.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnCancel.addActionListener(this);
		
		setSize(400,1200);
		setVisible(true);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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

	private void viewData(StudentDTO vStu) 
	{
		String id = vStu.getid();  
		String name = vStu.getname();
		String attendance = vStu.getattendance();
		String midscore = vStu.getmidscore();
		String finalscore = vStu.getfinalscore();  
		String homework = vStu.gethomework();
		String quiz = vStu.getquiz();
		String announcement = vStu.getannouncement();
		String report = vStu.getreport();
		String other = vStu.getother();
		
		tfid.setText(id);             //-----------> 클릭하면 결국 보여지는것
		tfid.setEditable(false);
		
		tfname.setText(name); 
		tfname.setEditable(false);
		
		tfattendance.setText(attendance);
		tfattendance.setEditable(false);
		
		tfmidscore.setText(midscore);
		//tfmidscore.setEditable(false);
		
		tffinalscore.setText(finalscore);      
		//tffinalscore.setEditable(false); /////////////////////////////// 이부분이 사용못하게하는
		
		tfhomework.setText(homework);
		//tfhomework.setEditable(false);
		
		tfquiz.setText(quiz);
		//tfquiz.setEditable(false);
		
		tfannouncement.setText(announcement);
		//tfannouncement.setEditable(false);
		
		tfreport.setText(report);
		//tfreport.setEditable(false);
		
		tfother.setText(other);
		//tfother.setEditable(false);
	}
	


	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new StudentProc();
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnInsert)
		{
			insertStudent();
			//System.out.println("insertStudent() 호출종료");
		}
		else if(ae.getSource()==btnCancel)
		{
			this.dispose();
		}
		else if(ae.getSource()==btnUpdate)
		{
			UpdateStudent();
		}
		else if(ae.getSource()==btnDelete)
		{
			int x = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?","삭제",JOptionPane.YES_NO_OPTION);
			
			if(x==JOptionPane.OK_OPTION) 
			{
				deleteStudent();
			}
			else 
			{
				JOptionPane.showMessageDialog(this, "삭제를 취소하였습니다.");
			}
		}
		sList.jTableRefresh();
	}
	
	
    // 버튼 누르고 그 버튼의 눌렀을때 action 함수에 insertStudent() 불러짐
	private void insertStudent() 
	{
		StudentDTO dto = getViewData();
		StudentDAO dao = new StudentDAO();
		boolean ok = dao.insertStudent(dto);
		
		if(ok)
		{
			JOptionPane.showMessageDialog(this, "등록이 완료되었습니다."); // 그냥딱뜨게
			dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "등록이 실패되었습니다.");
		}
	}

	private StudentDTO getViewData() // 
	{	
		StudentDTO dto = new StudentDTO();
		
		String id = tfid.getText();
		String name = tfname.getText();       
		String attendance = tfattendance.getText();
		String finalscore = tffinalscore.getText();
		String homework = tfhomework.getText();
		String quiz = tfquiz.getText();       
		String announcement = tfannouncement.getText();
		String report = tfreport.getText();
		String midscore = tfmidscore.getText();
		String other = tfother.getText();
		
		dto.setid(id);          
		dto.setname(name);
		dto.setattendance(attendance);
		dto.setfinalscore(finalscore);
		dto.sethomework(homework);          
		dto.setquiz(quiz);
		dto.setannouncement(announcement);
		dto.setreport(report);
		dto.setmidscore(midscore);
		dto.setother(other);
		
		return dto;
	}

	private void UpdateStudent() 
	{
		StudentDTO dto = getViewData();
		StudentDAO dao = new StudentDAO();
		boolean ok = dao.updateStudent(dto);
		
		if(ok)
		{
			JOptionPane.showMessageDialog(this, "수정되었습니다.");
			this.dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "수정 실패 : 값을 확인하세요");
		}
	}

	private void deleteStudent() 
	{
		String id = tfid.getText();     
		StudentDAO dao = new StudentDAO();
		boolean ok = dao.deleteStudent(id);
		
		if(ok) 
		{
			JOptionPane.showMessageDialog(this, "삭제완료");
			dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "삭제실패");
		}
		
	}
}
