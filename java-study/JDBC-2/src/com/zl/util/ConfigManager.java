package com.zl.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
//读取配置文件的工具类
public class ConfigManager {
	//静态的变量  静态方法
	private static ConfigManager configManger;
	//properties这个类就是加载配置文件的（load方法）
	private static Properties properties;
	
	private ConfigManager() {
		properties = new Properties();
		String configFile ="db.properties";
		//加载配置文件到流中
		/*InputStream in = new FileInputStream(configFile);*/
		//通过这个configManger类的类加载器   把文件读到输入流
		InputStream in  
		=ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
		try {
			
			properties.load(in);
			//关闭流
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//通过单例模式设置实例化的个数  
	/*
	 * 当多线程的时候会存在线程安全的问题，因为要加锁synchronized
	 */
	public synchronized static ConfigManager getInstance(){
		if(configManger==null){
			configManger=new ConfigManager();
		}
		return configManger;
	}
	//根据文件中的键来获得值(给我一个K，返回V)
	public String getString(String key){
		return properties.getProperty(key);
	}
	
	
}
