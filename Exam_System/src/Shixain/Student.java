package Shixain;

public class Student {
	private String no;//ѧ��
	private String password;//����
	private String name;//����
	private String discipline;//רҵ
	private String grade; //�꼶
	public Student(){}
	public Student(String n,String p,String nn,String d,String g)
	{
		no=n;
		password=p;
		name=nn;
		discipline=d;
		grade=g;
	}
	public void setname(String n)
	{
		name=n;
	}
	public String getname()
	{
		return name;
	}
	public void setno(String n)
	{
		no=n;
	}
	public String getno()
	{
		return no;
	}
	public void setpassword(String n)
	{
		password=n;
	}
	public String getpassword()
	{
		return password;
	}
	public void setdiscipline(String n)
	{
		discipline=n;
	}
	public String getdiscipline()
	{
		return discipline;
	}
	public void setgrade(String n)
	{
		grade=n;
	}
	public String getgrade()
	{
		return grade;
	}

}
