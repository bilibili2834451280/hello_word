package com.org.Exam;

public class Answer_table {
	
	private String ans_no;
	private String ans_detail;
	private String pro_no;
	
	private String pro_dif;
	private String cha_no;
	private String cha_title;
	private String cha_mpiont;
	Answer_table(String []tmp){
		
		ans_no=new String(tmp[0]);
		ans_detail=new String(tmp[1]);
		pro_no=new String(tmp[2]);
		
		pro_dif=new String(tmp[3]);
		cha_no=new String(tmp[4]);
		cha_title=new String(tmp[5]);
		cha_mpiont=new String(tmp[6]);
	}
	
	public String getAns_no() {
		return ans_no;
	}
	public void setAns_no(String ans_no) {
		this.ans_no = ans_no;
	}
	public String getAns_detail() {
		return ans_detail;
	}
	public void setAns_detail(String ans_detail) {
		this.ans_detail = ans_detail;
	}
	public String getPro_no() {
		return pro_no;
	}
	public void setPro_no(String pro_no) {
		this.pro_no = pro_no;
	}
	
	public String getPro_dif() {
		return pro_dif;
	}
	public void setPro_dif(String pro_dif) {
		this.pro_dif = pro_dif;
	}
	
	public String getCha_no() {
		return cha_no;
	}
	public void setCha_no(String cha_no) {
		this.cha_no = cha_no;
	}
	public String getCha_title() {
		return cha_title;
	}
	public void setCha_title(String cha_title) {
		this.cha_title = cha_title;
	}
	public String getCha_mpiont() {
		return cha_mpiont;
	}
	public void setCha_mpiont(String cha_mpiont) {
		this.cha_mpiont = cha_mpiont;
	}
	
}
