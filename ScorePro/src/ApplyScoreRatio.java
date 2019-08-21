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

public class ApplyScoreRatio extends JFrame implements ActionListener
{
	JPanel p;
	JTextField tfaascore,tfascore ,tfbbscore , tfbscore ,tfccscore , tfcscorement , tfddscore , tfdscore;
	JButton btnInsert;
	
	GridBagLayout gb;
	GridBagConstraints gbc;
	
	Student_List sList;
	StudentDAO dao;
	private void createUI()
	{

		
		
		gb = new GridBagLayout();
		setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		JLabel baascore = new JLabel("A+ ���� :");
		tfaascore = new JTextField(10);
		gbAdd(baascore,0,2,1,1);
		gbAdd(tfaascore,1,2,3,1);
		
		JLabel bascore = new JLabel("A0 ���� :");
		tfascore = new JTextField(10);
		gbAdd(bascore,0,3,1,1);
		gbAdd(tfascore,1,3,3,1);
		
		JLabel bbbscore = new JLabel("B+ ���� :");
		tfbbscore = new JTextField(10);
		gbAdd(bbbscore,0,4,1,1);
		gbAdd(tfbbscore,1,4,3,1);
		
		JLabel bbscore = new JLabel("B0 ���� :");
		tfbscore = new JTextField(10);
		gbAdd(bbscore,0,5,1,1);
		gbAdd(tfbscore,1,5,3,1);
		
		JLabel bccscore = new JLabel("C+ ���� :");
		tfccscore = new JTextField(10);
		gbAdd(bccscore,0,6,1,1);
		gbAdd(tfccscore,1,6,3,1);
		
		JLabel bcscorement = new JLabel("C0 ���� :");
		tfcscorement = new JTextField(10);
		gbAdd(bcscorement,0,7,1,1);
		gbAdd(tfcscorement,1,7,3,1);
		
		JLabel bddscore = new JLabel("D+ ���� :");
		tfddscore = new JTextField(10);
		gbAdd(bddscore,0,8,1,1);
		gbAdd(tfddscore,1,8,3,1);
		
		JLabel bdscore = new JLabel("D0 ���� :");
		tfdscore = new JTextField(10);
		gbAdd(bdscore,0,9,1,1);
		gbAdd(tfdscore,1,9,3,1);
		
		JPanel pButton = new JPanel();
		btnInsert = new JButton("����");
		pButton.add(btnInsert);
		gbAdd(pButton,1,10,4,1);
		btnInsert.addActionListener(this);
		
		setVisible(true);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public ApplyScoreRatio(Student_List sList)
	{
		super("���� ����");
		JFrame f = new JFrame();
		this.sList = sList;
		///////////////////////////////////
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width/5)-(this.getWidth()/5), (dim.height/5)-(this.getHeight()/5));
		createUI();
		
		///////////////////////////////////
		setSize(350,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//new ApplyRatio();
	}
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnInsert)
		{
			apply();
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
	////////////////////////////////////���⼭ ���� ����//////////////////////////////////////
	private void apply() 
	{
		String aascore = tfaascore.getText();
		String bbscore = tfbbscore.getText();
		String bscore = tfbscore.getText();
		String ccscore = tfccscore.getText();       
		String cscorement = tfcscorement.getText();
		String ddscore = tfddscore.getText();
		String ascore = tfascore.getText();
		String dscore = tfdscore.getText();
		
		int _aascoreRatio= Integer.parseInt(aascore);
		int _ascoreRatio = Integer.parseInt(ascore);
		int _bbscoreRatio = Integer.parseInt(bbscore);
		int _bscoreRatio = Integer.parseInt(bscore);
		int _ccscoreRatio = Integer.parseInt(ccscore);
		int _cscoreRatio = Integer.parseInt(cscorement);
		int _ddscoreRatio = Integer.parseInt(ascore);
		int _dscoreRatio = Integer.parseInt(dscore);
		
		sList.setScoreRatio(_aascoreRatio, _ascoreRatio, _bbscoreRatio, _bscoreRatio, _ccscoreRatio, _cscoreRatio, _ddscoreRatio, _dscoreRatio);
		//sList.setDAO();
		
		JOptionPane.showMessageDialog(this, "������ �Ϸ�Ǿ����ϴ�."); 
		dispose();
				
	}
	
	

}
	
	


