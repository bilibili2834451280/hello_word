package com.org.Menu;
import java.util.List;
public interface ALLinterface {
	real getinfobypro_no(String NO);
	void updateinfo1(real INFO);
	void updateinfo2(real INFO);
	boolean check(String no);
	
	int Insert(String pro_no,String pro_detail,String pro_ansno,String pro_keyw,
			String pro_dif,String cha_no,String cha_title,String cha_mpoString,String pro_type,String ANS_NO,String ANS_DETAIL);
	int delete(String no);
	void dataBaseDump(String port,String username,String password,String databasename,String sqlname)throws Exception ;
	void backup(String root,String pwd,String dbName,String filePath);
}
