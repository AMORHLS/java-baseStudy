package com.pac;

import java.io.File;
import java.io.IOException;
//�ļ�����
public class FileDemo {
	//�����ļ���createNewFile  ����ͨ������������
	public void create(File file){
		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("�ļ��Ѿ�������");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//�鿴�ļ��������Ϣ
	public void showFileInfo(File file){
		if (file.exists()) {
			//�ļ����ڣ��鿴����Ϣ
			if (file.isFile()) {
				//���ļ�
				System.out.println("���ļ�����"+file.getName());
				System.out.println("�ļ������·��"+file.getPath());
				System.out.println("�ļ��ľ���·��"+file.getAbsolutePath());
				System.out.println("�ļ��Ĵ�С"+file.length()+"�ֽ�");
			}
			if (file.isDirectory()) {
				System.out.println("���ļ���Ŀ¼��");
			}
		}else {
			System.out.println("�ļ�������");
		}
	}
	//ɾ���ļ�
	public void delete(File file){
		if (file.exists()) {
			file.delete();
			System.out.println("�ļ��Ѿ�ɾ����");
		}
	}
	public static void main(String[] args) {
		FileDemo fileDemo = new FileDemo();
		File file = new File("f:/helishi/test.txt");
		//File file = new File("test.txt");
		fileDemo.create(file);
		//����showFileInfo
		fileDemo.showFileInfo(file);
		fileDemo.delete(file);
	}
	
}
