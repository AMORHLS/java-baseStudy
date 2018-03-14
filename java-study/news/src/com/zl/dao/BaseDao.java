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
	// 对象初始化
	protected Connection con;
	protected PreparedStatement ps;
	protected ResultSet rs;

	// 获取连接
	public boolean getConnection() {
		// 通过ConfigManager调用getInstance()方法构造对象的同时加载驱动
		// 再通过getString()方法来获取对象value值
		String driver = ConfigManager.getInstance().getString("jdbc.driver");
		String url = ConfigManager.getInstance().getString(
				"jdbc.connection.url");
		String user = ConfigManager.getInstance().getString(
				"jdbc.connection.user");
		String password = ConfigManager.getInstance().getString(
				"jdbc.connection.password");
		try { // 注意Class首字母大写
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
	
	/*通过数据源方式来获取连接*/
	public boolean getConnection2(){
		try {
			//初始化上下文
			Context cxt = new InitialContext();
			//获取与逻辑名称相关联的数据源对象
			DataSource ds = (DataSource)cxt.lookup("java:comp/env/jdbc/news");
			//通过数据源来获取数据源对象
			con=ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	// 增删改
	public int executeUpdate(String sql, Object[] params) {
		int updateRows = 0; // 影响的行数
		this.getConnection();
		try {
			ps = con.prepareStatement(sql);
			// 填充占位符
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			updateRows = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateRows;
	}

	// 查
	public ResultSet executeQuery(String sql, Object[] params) {
		this.getConnection();
		try {
			ps = con.prepareStatement(sql);
			// 填充占位符
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			rs = ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	//查：通过数据源连接的
	public ResultSet executeQuery2(String sql, Object[] params) {
		this.getConnection2();
		try {
			ps = con.prepareStatement(sql);
			// 填充占位符
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			rs = ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	// 关闭资源
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
