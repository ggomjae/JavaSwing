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
	
	public StudentProc()  // �л���Ͻ� 
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
	
	public StudentProc(String id,Student_List sList) //////// ���콺 Ŭ���� 
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

		this.setTitle("�л�����");
		gb = new GridBagLayout();
		setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		JLabel bid = new JLabel("�й�  ");
		tfid = new JTextField(10);
		gbAdd(bid,0,0,1,1);
		gbAdd(tfid,1,0,3,1);
		
		JLabel bname = new JLabel("�̸�  ");
		tfname = new JTextField(10);
		gbAdd(bname,0,1,1,1);
		gbAdd(tfname,1,1,3,1);
		
		JLabel battendance = new JLabel("�⼮  ");
		tfattendance = new JTextField(10);
		gbAdd(battendance,0,2,1,1);
		gbAdd(tfattendance,1,2,3,1);
		
		JLabel bmidscore = new JLabel("�߰�����  ");
		tfmidscore = new JTextField(10);
		gbAdd(bmidscore,0,3,1,1);
		gbAdd(tfmidscore,1,3,3,1);
		
		JLabel bfinalscore = new JLabel("�⸻����  ");
		tffinalscore = new JTextField(10);
		gbAdd(bfinalscore,0,4,1,1);
		gbAdd(tffinalscore,1,4,3,1);
		
		JLabel bhomework = new JLabel("����  ");
		tfhomework = new JTextField(10);
		gbAdd(bhomework,0,5,1,1);
		gbAdd(tfhomework,1,5,3,1);
		
		JLabel bquiz = new JLabel("����  ");
		tfquiz = new JTextField(10);
		gbAdd(bquiz,0,6,1,1);
		gbAdd(tfquiz,1,6,3,1);
		
		JLabel bannouncement = new JLabel("��ǥ  ");
		tfannouncement = new JTextField(10);
		gbAdd(bannouncement,0,7,1,1);
		gbAdd(tfannouncement,1,7,3,1);
		
		JLabel breport = new JLabel("����  ");
		tfreport = new JTextField(10);
		gbAdd(breport,0,8,1,1);
		gbAdd(tfreport,1,8,3,1);
		
		JLabel bother = new JLabel("��Ÿ  ");
		tfother = new JTextField(10);
		gbAdd(bother,0,9,1,1);
		gbAdd(tfother,1,9,3,1);
		
		
		JPanel pButton = new JPanel();
		btnInsert = new JButton("�߰�"); //
		btnUpdate = new JButton("����");
		btnDelete = new JButton("����");
		btnCancel = new JButton("���"); //
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
		
		tfid.setText(id);             //-----------> Ŭ���ϸ� �ᱹ �������°�
		tfid.setEditable(false);
		
		tfname.setText(name); 
		tfname.setEditable(false);
		
		tfattendance.setText(attendance);
		tfattendance.setEditable(false);
		
		tfmidscore.setText(midscore);
		//tfmidscore.setEditable(false);
		
		tffinalscore.setText(finalscore);      
		//tffinalscore.setEditable(false); /////////////////////////////// �̺κ��� �����ϰ��ϴ�
		
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
			//System.out.println("insertStudent() ȣ������");
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
			int x = JOptionPane.showConfirmDialog(this, "���� �����Ͻðڽ��ϱ�?","����",JOptionPane.YES_NO_OPTION);
			
			if(x==JOptionPane.OK_OPTION) 
			{
				deleteStudent();
			}
			else 
			{
				JOptionPane.showMessageDialog(this, "������ ����Ͽ����ϴ�.");
			}
		}
		sList.jTableRefresh();
	}
	
	
    // ��ư ������ �� ��ư�� �������� action �Լ��� insertStudent() �ҷ���
	private void insertStudent() 
	{
		StudentDTO dto = getViewData();
		StudentDAO dao = new StudentDAO();
		boolean ok = dao.insertStudent(dto);
		
		if(ok)
		{
			JOptionPane.showMessageDialog(this, "����� �Ϸ�Ǿ����ϴ�."); // �׳ɵ��߰�
			dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "����� ���еǾ����ϴ�.");
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
			JOptionPane.showMessageDialog(this, "�����Ǿ����ϴ�.");
			this.dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "���� ���� : ���� Ȯ���ϼ���");
		}
	}

	private void deleteStudent() 
	{
		String id = tfid.getText();     
		StudentDAO dao = new StudentDAO();
		boolean ok = dao.deleteStudent(id);
		
		if(ok) 
		{
			JOptionPane.showMessageDialog(this, "�����Ϸ�");
			dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "��������");
		}
		
	}
}
