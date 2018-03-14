package com.zl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import com.zl.util.ConfigManager;

//数据库操作的基类
public class BaseDao {
	// 声明全局的变量
	protected Connection con;
	protected PreparedStatement pstmt;
	protected ResultSet rs;

	// 获得连接的方法
	public boolean getConnection() {
		String driver = ConfigManager.getInstance().getString("jdbc.driver");
		String url = ConfigManager.getInstance().getString(
				"jdbc.connection.url");
		String user = ConfigManager.getInstance().getString(
				"jdbc.connection.user");
		String password = ConfigManager.getInstance().getString(
				"jdbc.connection.password");
		try {
			Class.forName(driver); // 加载驱动
			con = DriverManager.getConnection(url, user, password);// 获得连接
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 增删改(sql语句里的？个数也不确定/不确定参数的类型，用基类object，个数不确定，用数组)
	public int update(String sql, Object[] params) {
		int updateRows = 0;
		if (getConnection()) {
			try {
				pstmt = con.prepareStatement(sql);
				// 填充占位符
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

	// 查询所有
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

	// 关闭资源 释放资源的顺序
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
