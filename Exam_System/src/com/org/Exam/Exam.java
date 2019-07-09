package com.org.Exam;
public class Exam {
	private String tst_no;
	private String tst_name;
	private String tst_time;
	private String tst_type;
	private String tst_dif;
	private String tst_num;
	private String tst_score;
	private String[] tst_detail;
	public Exam() {};
    public Exam(String no,String name,String time,String type,String dif,String num,String score,String[] detail) {
    	this.tst_no=no;
    	this.tst_name=name;
    	this.tst_time=time;
    	this.tst_type=type;
    	this.tst_dif=dif;
    	this.tst_num=num;
    	this.tst_score=score;
    	this.tst_detail=detail;
    }
    public Exam(String no,String name,String time,String type,String dif,String num,String score) {
    	this.tst_no=no;
    	this.tst_name=name;
    	this.tst_time=time;
    	this.tst_type=type;
    	this.tst_dif=dif;
    	this.tst_num=num;
    	this.tst_score=score;
    }
	public String getTst_no() {
		return tst_no;
	}
	public void setTst_no(String tst_no) {
		this.tst_no = tst_no;
	}
	public String getTst_name() {
		return tst_name;
	}
	public void setTst_name(String tst_name) {
		this.tst_name = tst_name;
	}
	public String getTst_time() {
		return tst_time;
	}
	public void setTst_time(String tst_time) {
		this.tst_time = tst_time;
	}
	public String getTst_type() {
		return tst_type;
	}
	public void setTst_type(String tst_type) {
		this.tst_type = tst_type;
	}
	public String getTst_dif() {
		return tst_dif;
	}
	public void setTst_dif(String tst_dif) {
		this.tst_dif = tst_dif;
	}
	public String getTst_num() {
		return tst_num;
	}
	public void setTst_num(String tst_num) {
		this.tst_num = tst_num;
	}
	public String getTst_score() {
		return tst_score;
	}
	public void setTst_score(String tst_score) {
		this.tst_score = tst_score;
	}
	public String[] getTst_detail() {
		return tst_detail;
	}
	public void setTst_detail(String[] tst_detail) {
		this.tst_detail = tst_detail;
	}
	public String toString(){
		return "Stu [No="+ tst_no +", Name="+ tst_name + ", Time=" + tst_time + ", Type=" + tst_type +", Dif=" + tst_dif +", Num=" + tst_num +", Score=" + tst_score +"]";
	}
}
