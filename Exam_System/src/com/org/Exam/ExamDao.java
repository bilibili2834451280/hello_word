package com.org.Exam;
public interface ExamDao {
	void insertExam(Exam s1);
	void updateExam(Exam s1);
	void deleteExam(String no1);
	Exam getExamByNo(String no1);
}
