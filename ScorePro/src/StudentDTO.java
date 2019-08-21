
public class StudentDTO 
{
	
	private String id; 
	private String name;
	private String attendance;
	private String midscore;
	private String finalscore; 
	private String homework;
	private String quiz;
	private String announcement;
	private String report;
	private String other;
	
	
	public String getid() 
	{
		return id;
	}
	public void setid(String id)
	{
		this.id = id;
	}
	
	public String getname() 
	{
		return name;
	}
	public void setname(String name)
	{
		this.name = name;
	}
	
	public String getattendance() 
	{
		return attendance;
	}
	public void setattendance(String attendance)
	{
		this.attendance = attendance;
	}
	
	public String getmidscore() 
	{
		return midscore;
	}
	public void setmidscore(String midscore)
	{
		this.midscore = midscore;
	}
	
	public String getfinalscore() 
	{
		return finalscore;
	}
	public void setfinalscore(String finalscore)
	{
		this.finalscore = finalscore;
	}
	
	public String gethomework() 
	{
		return homework;
	}
	public void sethomework(String homework)
	{
		this.homework = homework;
	}

	public String getquiz() 
	{
		return quiz;
	}
	public void setquiz(String quiz)
	{
		this.quiz = quiz;
	}

	public String getannouncement() 
	{
		return announcement;
	}
	public void setannouncement(String announcement)
	{
		this.announcement = announcement;
	}

	public String getreport() 
	{
		return report;
	}
	public void setreport(String report)
	{
		this.report = report;
	}
	
	public String getother() 
	{
		return other;
	}
	public void setother(String other)
	{
		this.other = other;
	}
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub  //", name = " + name +
		return "StudentDTO [ id = " + id + ", name = " + name + ", attendance = " + attendance + ", midscore = " + midscore + ", finalscore = " + finalscore + ", homework = " + homework + ", quiz = " + quiz + ", announcement = " + announcement + ", report = " + report +", other = " + other + "]";
	}


}
