import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GraphSum
{
	int[] array;
	int[] range= new int[20];
	
	public GraphSum(Student_List sList,StudentDAO _temp)
	{
		
		
		JFrame frame = new JFrame("총합 그래프");
		frame.setLocation(1000, 200);
		frame.setPreferredSize(new Dimension(1000, 600));
		Container contentPane = frame.getContentPane();
		array = _temp.getGraph();
		for(int index = 0 ; array[index]!=0; ++index)
		{
			range[array[index]/10]++ ;
		}
		DrawingPanel drawingPanel = new DrawingPanel();
		contentPane.add(drawingPanel, BorderLayout.CENTER);
		// 그래프를 그릴 패널
		frame.setResizable(false);
		JPanel controlPanel = new JPanel();
		
		
		JButton button = new JButton("그래프 그리기");
		
	
		controlPanel.add(button);
		
		contentPane.add(controlPanel, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		button.addActionListener(new DrawActionListener(range,drawingPanel));
		// "그래프 그리기" 버튼을 눌렀을때 작동 할 리스터등록
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String args[])
	{
		//
	}

	private static void setResizable(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
}

//그래피를 그리는 패널 클래스

class DrawingPanel extends JPanel 
{
	int A1, A2, A3,A4, A5, A6,A7, A8, A9,A10, A11, A12;

	public void paint(Graphics g) 
	{
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawLine(50, 450, 950, 450); // 맨밑에 있는 줄
		for (int cnt = 1; cnt < 22; cnt++)  // 가로 줄
		{
			g.drawString(cnt * 1 + " ", 25, 475 - 20 * (cnt+1));
			g.drawLine(50, 450 - 20 * cnt, 950, 450 - 20 * cnt);
		}
		
		g.drawLine(50, 20, 50, 450); //세로 줄
		g.drawString("0점", 80, 470); // 과목 위치
		g.drawString("10점", 160, 470);
		g.drawString("20점", 240, 470);
		g.drawString("30점", 320, 470);
		g.drawString("40점", 400, 470);
		g.drawString("50점", 480, 470);
		g.drawString("60점", 560, 470);
		g.drawString("70점", 640, 470);
		g.drawString("80점", 720, 470);
		g.drawString("90점", 800, 470);
		g.drawString("100점", 880, 470);
		g.setColor(Color.red);
		 
		if (A1 > 0)
			g.fillRect(80, 450 -A1 * 21, 10, A1 * 21);   
		if (A2 > 0)
			g.fillRect(160, 450 - A2 * 21, 10, A2 * 21); 
		if (A3 > 0)
			g.fillRect(240, 450 - A3 * 21, 10, A3 * 21);
		if (A4 > 0)
			g.fillRect(320, 450 - A4 * 21, 10, A4 * 21);   
		if (A5 > 0)
			g.fillRect(400, 450 - A5 * 21, 10, A5 * 21); 
		if (A6 > 0)
			g.fillRect(480, 450 - A6 * 21, 10, A6 * 21);
		if (A7 > 0)
			g.fillRect(560, 450 - A7 * 21, 10, A7 * 21);   
		if (A8 > 0)
			g.fillRect(640, 450 - A8 * 21, 10, A8 * 21); 
		if (A9 > 0)
			g.fillRect(720, 450 - A9 * 21, 10, A9 * 21);
		if (A10 > 0)
			g.fillRect(800, 450 - A10 * 21, 10, A10 * 21);   
		if (A11 > 0)
			g.fillRect(880, 450 - A11 * 21, 10, A11 * 21); 
		
	}
	

	void setScores(int A1, int A2, int A3,int A4, int A5, int A6,int A7, int A8, int A9,int A10, int A11)
	{
		this.A1 = A1;
		this.A2 = A2;
		this.A3 = A3;
		this.A4 = A4;
		this.A5 = A5;
		this.A6 = A6;
		this.A7 = A7;
		this.A8 = A8;
		this.A9 = A9;
		this.A10 = A10;
		this.A11 = A11;
		}
}

//버튼 눌렀을때 동작하는 리스너
class DrawActionListener implements ActionListener 
{
	
	DrawingPanel drawingPanel;
	int[] _temp = new int[20];
	
	
	DrawActionListener(int[] temp, DrawingPanel drawingPanel) 
	{
		_temp = temp;
		this.drawingPanel = drawingPanel;
	}

	public void actionPerformed(ActionEvent e) { //   <-------여기에 점수기입하면된다.
		try 
		{
			int A1 = _temp[0];
			int A2 = _temp[1];
			int A3 = _temp[2];
			int A4 = _temp[3];
			int A5 = _temp[4];
			int A6 = _temp[5];
			int A7 = _temp[6];
			int A8 = _temp[7];
			int A9 = _temp[8];
			int A10 = _temp[9];
			int A11 = _temp[10];
			
			drawingPanel.setScores(A1, A2, A3,A4, A5, A6,A7, A8, A9,A10, A11);
			drawingPanel.repaint();
		} catch (NumberFormatException nfe)
		{
			JOptionPane.showMessageDialog(drawingPanel, "잘못된 숫자 입력입니다", "에러메시지", JOptionPane.ERROR_MESSAGE);
		}
	}
}