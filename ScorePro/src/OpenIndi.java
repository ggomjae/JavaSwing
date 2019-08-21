import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class OpenIndi extends JFrame implements ActionListener
{
	DefaultTableModel model;
	Vector v;
	Vector cols;
	JTable jTable;
	JScrollPane pane;
	//int temp;
	Student_List sList;
	StudentDAO dao; ///////////////////////////  ---- ���߿� �հ� ���� 
	public OpenIndi(Student_List sList,int attendanceRatio,int midscoreRatio,int finalscoreRatio,int homeworkRatio,int quizRatio,int announceRatio,int reportRatio,int otherRatio)
	{
		super("���� ���� ����");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width/5)-(this.getWidth()/5), (dim.height/5)-(this.getHeight()/5));
		this.sList = sList;
		
		//////////////////////////////////////////////////////////
		dao = new StudentDAO(attendanceRatio,midscoreRatio,finalscoreRatio,homeworkRatio,quizRatio,announceRatio,reportRatio,otherRatio);
		v = dao.getRatioInformation(); // ---- �̺κ�
		cols = getColumn();
		
		model = new DefaultTableModel(v,cols);
		jTable = new JTable(model);
		pane = new JScrollPane(jTable);
		add(pane);
		/////////////////////////////////////////////////////////
		setSize(1500,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		
		
	}

}
