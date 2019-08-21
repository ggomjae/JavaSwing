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

public class OpenRating extends JFrame implements ActionListener
{

	StudentDAO dao;
	Vector v;
	Vector cols;
	JTable jTable;
	JScrollPane pane;
	DefaultTableModel model;
	
	public OpenRating(Student_List sList,StudentDAO _temp,int _aascoreRatio,int _ascoreRatio,int _bbscoreRatio,int _bscoreRatio,int _ccscoreRatio,int _cscoreRatio,int _ddscoreRatio,int _dscoreRatio)
	{
		super("등급 및 등수 점수");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width/5)-(this.getWidth()/5), (dim.height/5)-(this.getHeight()/5));
		
		dao = _temp;
		v = dao.getRATINGInformation(_aascoreRatio, _ascoreRatio, _bbscoreRatio, _bscoreRatio, _ccscoreRatio, _cscoreRatio, _ddscoreRatio, _dscoreRatio); // ---- 이부분
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
	
	public Vector getColumn() 
	{
		Vector col = new Vector();
		col.add("학번");
		col.add("이름");
		col.add("순위");
		col.add("등급 점수");
		
		
		return col;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

}
