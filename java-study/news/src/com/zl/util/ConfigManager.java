package com.zl.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*读取属性文件   工具类*/
//如何让用户只创建一个ConfigManager:单例模式
public class ConfigManager {
	private static ConfigManager configManager;
	private static Properties properties;

	// 构造方法私有，别人就不能随便new对象
	private ConfigManager() {
		properties = new Properties();
		String configFile = "db.properties";
		try {
			/* InputStream in = new FileInputStream(configFile); */
			InputStream in = ConfigManager.class.getClassLoader()
					.getResourceAsStream(configFile);
			properties.load(in);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 单例模式：构造方法私有化  程序提供唯一的方法（懒汉模式）
	 * 可能线程不安全（方法在调用的过程中，没结束，别人又来调用该方法），加锁（同步）synchronized
	 * static：当构造方法私有化后，别人就不能new对象了，加static可以通过类名来调用
	 */
	public synchronized static ConfigManager getInstance() {
		if (configManager == null) {
			configManager = new ConfigManager();
		}
		return configManager;
	}

	// 根据键来获取值
	public String getString(String key) {
		//getProperty返回一个键对应的String 值
		return properties.getProperty(key);
	}

}
