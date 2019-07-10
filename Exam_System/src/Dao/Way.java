package Dao;

import Shixain.*;

public interface Way {
	int login(String no,String password);//µÇÂ½ÅĞ¶Ïº¯Êı
	void zhuceofStudent(Student s);//Ñ§Éú×¢²á
	void zhuceofTeacher(Teacher t);
	boolean massagestupipei(String no,String name);//Íü¼ÇÃÜÂëĞÅÏ¢Æ¥Åä
	boolean massageteapipei(String no,String name);
	String findstupassword(String no);//Ñ°ÕÒÃÜÂë
	String findteapassword(String no);
	boolean updatestupwd(String no,String op,String np);
	boolean updateteapwd(String no,String op,String np);
	void updatestuwork(String no,String np);
	void updateteawork(String no,String np);

}
