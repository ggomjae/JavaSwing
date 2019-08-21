import java.awt.BorderLayout;
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

public class ApplyAttendanceRatio extends JFrame implements ActionListener
{
	JPanel p;
	JTextField tflate,tfab,tfid ;
	JButton btnInsert;
	JButton btnBring;
	JPanel pButton;
	GridBagLayout gb;
	GridBagConstraints gbc;
	
	Student_List sList;
	StudentDAO dao;
	StudentDTO vStu;

	private void createUI()
	{
		gb = new GridBagLayout();
		setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		////////////////////////////////////
		JPanel pButton = new JPanel();
		btnInsert = new JButton("적용");
		//btnBring = new JButton("가져오기");
		
		//pButton.add(btnBring);
		pButton.add(btnInsert);
		gbAdd(pButton,1,10,4,1);
		btnInsert.addActionListener(this);
		//btnBring.addActionListener(this);
		//////////////////////////////////////
		JLabel bid = new JLabel("학번 :");
		tfid = new JTextField(10);
		gbAdd(bid,0,1,1,1);
		gbAdd(tfid,1,1,3,1);
		
		JLabel blate = new JLabel("지각 횟수 :");
		tflate = new JTextField(10);
		gbAdd(blate,0,2,1,1);
		gbAdd(tflate,1,2,3,1);
		
		JLabel bab = new JLabel("결석  횟수 :");
		tfab = new JTextField(10);
		gbAdd(bab,0,3,1,1);
		gbAdd(tfab,1,3,3,1);
		
		setVisible(true);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public ApplyAttendanceRatio(Student_List sList)
	{
		super("비율 적용");
		JFrame f = new JFrame();
		this.sList = sList;
		///////////////////////////////////
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width/5)-(this.getWidth()/5), (dim.height/5)-(this.getHeight()/5));
		createUI();
		/////////////////////////////////
		
		dao = new StudentDAO();
		
		
		/////////////////////////////////
		setSize(350,200);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args)
	{
		
	}
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnInsert) 
		{
			UpdateStudent();
			sList.jTableRefresh();
		}
		else if(ae.getSource()==btnBring) 
		{
			String id = tfid.getText();
			vStu = dao.getStudentDTO(id);
			
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
	
	
	private StudentDTO getViewData() //  데이터를 다시 List로 되돌리는
	{	
		StudentDTO dto = new StudentDTO();
		int result = 100;
		int _late =  Integer.parseInt(tflate.getText());
		int _ab = Integer.parseInt(tfab.getText());
		
		int tempNumber = _late / 4 ;
		
		if((_ab + tempNumber)>= 4)
		{
			result = 0;
		}
		else
		{
			result -= _ab*10;
			result -= _late*5;
		}
		
		String id = tfid.getText();
		String abs =  Integer.toString(result);
		
		dto.setid(id);
		dto.setattendance(abs);
		
		return dto;
	}
	
	private void UpdateStudent() 
	{
		StudentDTO dto = getViewData();
		StudentDAO dao = new StudentDAO();
		
		boolean ok = dao.updateAb(dto);
		
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
}	