package Dao;

import Shixain.*;

public interface Way {
	int login(String no,String password);//��½�жϺ���
	void zhuceofStudent(Student s);//ѧ��ע��
	void zhuceofTeacher(Teacher t);//��ʦע��
	boolean massagestupipei(String no,String name);//��������ѧ����Ϣƥ��
	boolean massageteapipei(String no,String name);//����������ʦ��Ϣƥ��
	String findstupassword(String no);//Ѱ��ѧ������
	String findteapassword(String no);//Ѱ����ʦ����
	boolean updatestupwd(String no,String op,String np);//�޸�ѧ��������Ϣƥ��
	boolean updateteapwd(String no,String op,String np);//�޸���ʦ������Ϣƥ��
	void updatestuwork(String no,String np);//�޸�ѧ������
	void updateteawork(String no,String np);//�޸���ʦ����
	boolean checkzhuce(String no);//ע���Ƿ��Ѵ����˺ż��

}
