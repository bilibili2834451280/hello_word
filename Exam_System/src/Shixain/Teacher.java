package Shixain;

public class Teacher {
	private String no;//����
	private String password;//����
	private String name;//����
	private String discipline;//רҵ
	private String mail;//����
	Teacher(){}
	Teacher(String n,String p,String nn,String d,String m)
	{
		no=n;
		password=p;
		name=nn;
		discipline=d;
		mail=m;
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
	public void setmail(String n)
	{
		mail=n;
	}
	public String getmail()
	{
		return mail;
	}

}
