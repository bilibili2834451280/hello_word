package Dao;

import Shixain.*;

public interface Way {
	int login(String no,String password);//��½�жϺ���
	void zhuceofStudent(Student s);//ѧ��ע��
	void zhuceofTeacher(Teacher t);
	boolean massagestupipei(String no,String name);//����������Ϣƥ��
	boolean massageteapipei(String no,String name);
	String findstupassword(String no);//Ѱ������
	String findteapassword(String no);
	boolean updatestupwd(String no,String op,String np);
	boolean updateteapwd(String no,String op,String np);
	void updatestuwork(String no,String np);
	void updateteawork(String no,String np);

}
