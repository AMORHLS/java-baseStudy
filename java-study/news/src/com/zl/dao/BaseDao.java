package com.zl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.zl.util.ConfigManager;

public class BaseDao {
	// �����ʼ��
	protected Connection con;
	protected PreparedStatement ps;
	protected ResultSet rs;

	// ��ȡ����
	public boolean getConnection() {
		// ͨ��ConfigManager����getInstance()������������ͬʱ��������
		// ��ͨ��getString()��������ȡ����valueֵ
		String driver = ConfigManager.getInstance().getString("jdbc.driver");
		String url = ConfigManager.getInstance().getString(
				"jdbc.connection.url");
		String user = ConfigManager.getInstance().getString(
				"jdbc.connection.user");
		String password = ConfigManager.getInstance().getString(
				"jdbc.connection.password");
		try { // ע��Class����ĸ��д
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/*ͨ������Դ��ʽ����ȡ����*/
	public boolean getConnection2(){
		try {
			//��ʼ��������
			Context cxt = new InitialContext();
			//��ȡ���߼����������������Դ����
			DataSource ds = (DataSource)cxt.lookup("java:comp/env/jdbc/news");
			//ͨ������Դ����ȡ����Դ����
			con=ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	// ��ɾ��
	public int executeUpdate(String sql, Object[] params) {
		int updateRows = 0; // Ӱ�������
		this.getConnection();
		try {
			ps = con.prepareStatement(sql);
			// ���ռλ��
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			updateRows = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateRows;
	}

	// ��
	public ResultSet executeQuery(String sql, Object[] params) {
		this.getConnection();
		try {
			ps = con.prepareStatement(sql);
			// ���ռλ��
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			rs = ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	//�飺ͨ������Դ���ӵ�
	public ResultSet executeQuery2(String sql, Object[] params) {
		this.getConnection2();
		try {
			ps = con.prepareStatement(sql);
			// ���ռλ��
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			rs = ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	// �ر���Դ
	public boolean closeResource() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		if (ps != null) {
			try {
				ps.close();
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
