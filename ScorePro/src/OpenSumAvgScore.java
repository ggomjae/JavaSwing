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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class OpenSumAvgScore extends JFrame implements ActionListener
{
	StudentDAO dao;
	Vector v;
	Vector cols;
	JTable jTable;
	JScrollPane pane;
	DefaultTableModel model;
	
	public OpenSumAvgScore(Student_List sList,StudentDAO _temp)
	{
		super("ÃÑ ÇÕ°è Æò±Õ Á¡¼ö");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width/5)-(this.getWidth()/5), (dim.height/5)-(this.getHeight()/5));
		
		dao = _temp;
		v = dao.getSUMAVGInformation(); // ---- ÀÌºÎºÐ
		cols = getColumn();
		
		model = new DefaultTableModel(v,cols);
		jTable = new JTable(model);
		pane = new JScrollPane(jTable);
		add(pane);
		///////////////////////////////////////////////////////////
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = jTable.getColumnModel();
		for (int index = 0; index < tcmSchedule.getColumnCount(); index++) 
		{
			tcmSchedule.getColumn(index).setCellRenderer(tScheduleCellRenderer);
		}
		/////////////////////////////////////////////////////////
		setSize(700,150);
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
		col.add("ÇÐ»ýµéÀÇ ÃÑ ÇÕ°è Á¡¼ö Æò±Õ");
		
			
		return col;
	}

}

