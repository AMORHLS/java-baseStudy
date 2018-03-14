package com.zl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import com.zl.util.ConfigManager;

//���ݿ�����Ļ���
public class BaseDao {
	// ����ȫ�ֵı���
	protected Connection con;
	protected PreparedStatement pstmt;
	protected ResultSet rs;

	// ������ӵķ���
	public boolean getConnection() {
		String driver = ConfigManager.getInstance().getString("jdbc.driver");
		String url = ConfigManager.getInstance().getString(
				"jdbc.connection.url");
		String user = ConfigManager.getInstance().getString(
				"jdbc.connection.user");
		String password = ConfigManager.getInstance().getString(
				"jdbc.connection.password");
		try {
			Class.forName(driver); // ��������
			con = DriverManager.getConnection(url, user, password);// �������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// ��ɾ��(sql�����ģ�����Ҳ��ȷ��/��ȷ�����������ͣ��û���object��������ȷ����������)
	public int update(String sql, Object[] params) {
		int updateRows = 0;
		if (getConnection()) {
			try {
				pstmt = con.prepareStatement(sql);
				// ���ռλ��
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);
				}
				updateRows = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return updateRows;
	}

	// ��ѯ����
	public ResultSet queryAll(String sql, Object[] params) {
		this.getConnection();	
		try {
				pstmt = con.prepareStatement(sql);
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);
				}
				rs=pstmt.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
		}
		return rs;
	}

	// �ر���Դ �ͷ���Դ��˳��
	public boolean closeResource() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
}
