package com.org.Menu;
import java.util.List;
public interface ALLinterface {
	real getinfobypro_no(String NO);
	void updateinfo(real INFO);
	boolean check(String no);
	int Insert(String pro_no,String pro_detail,String pro_ansno,String pro_keyw,
			String pro_dif,String cha_no,String cha_title,String cha_mpoString,String pro_type,String lssb);
	int delete(String no);
}
