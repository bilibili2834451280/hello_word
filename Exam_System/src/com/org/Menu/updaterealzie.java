package com.org.Menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class updaterealzie implements ALLinterface{
	public void updateinfo(real INFO)// ����
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = openandclose.getConnection();
			
			String sql = "update  problem set pro_detail=?," // ��Ŀ
					+ "pro_ansno=?,"// ϰ��𰸱��
					+ "pro_keyw=?,"// �ؼ���
					+ "pro_dif=?,"// �Ѷ�ϵ��
					+ "cha_no=?,"//�����½ڱ��
					+ "cha_title=?,"//�����½ڱ���
					+ "cha_mpoint=?,"//�����½�Ҫ��
					+ "pro_type=?"//ϰ������
					+ "where pro_no=?";//����

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, INFO.getpro_detail());
			pstmt.setString(2, INFO.getpro_ansno());
			pstmt.setString(3, INFO.getpro_keyw());
			pstmt.setString(4, INFO.getpro_dif());
			pstmt.setString(5, INFO.getcha_no());
			pstmt.setString(6,INFO.getcha_title());
			pstmt.setString(7,INFO.getcha_mpoint());
			pstmt.setString(8,INFO.getpro_type());
			pstmt.setString(9, INFO.getpro_no());
			pstmt.executeUpdate();// ���뵽���ݿ�
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			openandclose.closeStatement(pstmt);
			openandclose.closeConnection(conn);
			
		}
	}

	@Override
	public real getinfobypro_no(String NO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean check(String no) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int Insert(String pro_no, String pro_detail, String pro_ansno,
			String pro_keyw, String pro_dif, String cha_no, String cha_title,
			String cha_mpoString, String pro_type, String lssb) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String no) {
		// TODO Auto-generated method stub
		return 0;
	}




}

