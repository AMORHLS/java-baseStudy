package com.zl.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*��ȡ�����ļ�   ������*/
//������û�ֻ����һ��ConfigManager:����ģʽ
public class ConfigManager {
	private static ConfigManager configManager;
	private static Properties properties;

	// ���췽��˽�У����˾Ͳ������new����
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
	 * ����ģʽ�����췽��˽�л�  �����ṩΨһ�ķ���������ģʽ��
	 * �����̲߳���ȫ�������ڵ��õĹ����У�û�����������������ø÷�������������ͬ����synchronized
	 * static�������췽��˽�л��󣬱��˾Ͳ���new�����ˣ���static����ͨ������������
	 */
	public synchronized static ConfigManager getInstance() {
		if (configManager == null) {
			configManager = new ConfigManager();
		}
		return configManager;
	}

	// ���ݼ�����ȡֵ
	public String getString(String key) {
		//getProperty����һ������Ӧ��String ֵ
		return properties.getProperty(key);
	}

}
