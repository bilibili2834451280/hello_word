package com.org.Menu;

public class real {
	private  String  pro_no;
	private  String pro_detail;
	private  String  pro_ansno;
	private  String  pro_keyw;
	private  String  pro_dif;
	private  String  cha_no;
	private  String  cha_title;
	private  String  cha_mpoint;
	private  String  pro_type;
	private  String  ans_detail;

	public real() {
			super();
		// TODO Auto-generated constructor stub
		}


	public real(String pro_no, String pro_detail,String  pro_ansno,String  pro_keyw,String  pro_dif,String  cha_no,String  cha_title,String  cha_mpoint,String  pro_type,String  ans_detail) {
		super();
		this.pro_no=pro_no;
		this.pro_detail=pro_detail;
		this.pro_ansno=pro_ansno;
		this.pro_keyw=pro_keyw;
		this.pro_dif=pro_dif;
		this.cha_no=cha_no;
		this.cha_title=cha_title;
		this.cha_mpoint=cha_mpoint;
		this.pro_type=pro_type;
		this.ans_detail=ans_detail;
		
	}


	public String getpro_no() {
		return pro_no;
	}
	public void setpro_no(String pro_no) {
		this.pro_no = pro_no;
	}
	public String getpro_detail() {
		return pro_detail;
	}
	public void setpro_detail(String pro_detail) {
		this.pro_detail = pro_detail;
	}
	public String getpro_ansno() {
		return pro_ansno;
	}
	public void setpro_ansno(String pro_ansno) {
		this.pro_ansno = pro_ansno;
	}
	public String getpro_keyw() {
		return pro_keyw;
	}
	public void setpro_keyw(String pro_keyw) {
		this.pro_keyw = pro_keyw;
	}
	public String getcha_no() {
		return cha_no;
	}
	public void setcha_no(String cha_no) {
		this.cha_no = cha_no;
	}
	public String getpro_dif() {
		return pro_dif;
	}
	public void setpro_dif(String pro_dif) {
		this.pro_dif = pro_dif;
	}
	public String getcha_title() {
		return cha_title;
	}
	public void setcha_title(String cha_title) {
		this.cha_title = cha_title;
	}
	
	public String getcha_mpoint() {
		return cha_mpoint;
	}
	public void setcha_mpoint(String cha_mpoint) {
		this.cha_mpoint = cha_mpoint;
	}
	public String getpro_type() {
		return pro_type;
	}
	public void setpro_type(String pro_type) {
		this.pro_type = pro_type;
	}
	public String getans_detail() {
		return ans_detail;
	}
	public void setans_detail(String ans_detail) {
		this.ans_detail= ans_detail;
	}
	@Override
	public String toString() {
			return "info is [pro_no=" + pro_no + ", pro_detail=" + pro_detail + ",pro_ansno=" +pro_ansno+",pro_keyw="+pro_keyw+",pro_dif="+pro_dif+",cha_no="+cha_no+",cha_title="+cha_title+",cha_mpoint="+cha_mpoint+",pro_type="+pro_type+",ans_detail="+ans_detail+"]";
	}

}
