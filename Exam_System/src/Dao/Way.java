package Dao;

import Shixain.*;

public interface Way {
	int login(String no,String password);//登陆判断函数
	void zhuceofStudent(Student s);//学生注册
	void zhuceofTeacher(Teacher t);//老师注册
	boolean massagestupipei(String no,String name);//忘记密码学生信息匹配
	boolean massageteapipei(String no,String name);//忘记密码老师信息匹配
	String findstupassword(String no);//寻找学生密码
	String findteapassword(String no);//寻找老师密码
	boolean updatestupwd(String no,String op,String np);//修改学生密码信息匹配
	boolean updateteapwd(String no,String op,String np);//修改老师密码信息匹配
	void updatestuwork(String no,String np);//修改学生密码
	void updateteawork(String no,String np);//修改老师密码
	boolean checkzhuce(String no);//注册是否已存在账号检查

}
