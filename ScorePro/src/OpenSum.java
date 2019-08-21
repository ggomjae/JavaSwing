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

public class OpenSum extends JFrame implements ActionListener
{
	StudentDAO dao;
	Vector v;
	Vector cols;
	JTable jTable;
	JScrollPane pane;
	DefaultTableModel model;
	
	public OpenSum(Student_List sList,StudentDAO _temp)
	{
		super("총 합계 점수");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width/5)-(this.getWidth()/5), (dim.height/5)-(this.getHeight()/5));
		
		dao = _temp;
		v = dao.getSUMInformation(); // ---- 이부분
		cols = getColumn();
		
		model = new DefaultTableModel(v,cols);
		jTable = new JTable(model);
		pane = new JScrollPane(jTable);
		add(pane);
		/////////////////////////////////////////////////////////
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	
	public Vector getColumn() 
	{
		Vector col = new Vector();
		col.add("학번");
		col.add("이름");
		col.add("총 합계 점수");
		
		
		return col;
	}

}
