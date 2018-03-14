package com.zl.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
//��ȡ�����ļ��Ĺ�����
public class ConfigManager {
	//��̬�ı���  ��̬����
	private static ConfigManager configManger;
	//properties�������Ǽ��������ļ��ģ�load������
	private static Properties properties;
	
	private ConfigManager() {
		properties = new Properties();
		String configFile ="db.properties";
		//���������ļ�������
		/*InputStream in = new FileInputStream(configFile);*/
		//ͨ�����configManger����������   ���ļ�����������
		InputStream in  
		=ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
		try {
			
			properties.load(in);
			//�ر���
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//ͨ������ģʽ����ʵ�����ĸ���  
	/*
	 * �����̵߳�ʱ�������̰߳�ȫ�����⣬��ΪҪ����synchronized
	 */
	public synchronized static ConfigManager getInstance(){
		if(configManger==null){
			configManger=new ConfigManager();
		}
		return configManger;
	}
	//�����ļ��еļ������ֵ(����һ��K������V)
	public String getString(String key){
		return properties.getProperty(key);
	}
	
	
}
