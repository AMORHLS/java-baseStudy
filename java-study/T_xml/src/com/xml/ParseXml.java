package com.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


//ʹ��DOM����XML�ļ�
public class ParseXml {
	//�ղ���Ϣ.xml��Ӧ��Document
	private Document document;
	
	//���DOM�������Document����
	public void getDom(){
		//��ý���������
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//���ݽ�����������ý�����
		DocumentBuilder db=null;
		try {
			db = dbf.newDocumentBuilder();
			//����������ȡDocument����
			document =db.parse("�ղ���Ϣ.xml");//�����ļ�"�ղ���Ϣ.xml"
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//��ȡ�ֻ�Ʒ�Ƽ��ͺ������Ϣ
	public void showInfo(){
		//��DocumentΪ��㣬���õ����е�Brand�ڵ�
		NodeList brands=document.getElementsByTagName("brand");
		//����brand,�����ó�ÿһ��brand�ڵ�
		for (int i = 0; i < brands.getLength(); i++) {
			Node node =brands.item(i);
			Element eleBrand =(Element)node;//����ת��
			String brandName=eleBrand.getAttribute("name");
			System.out.println(brandName);
			//�������ң��ҵ�ÿ��brand���ӽڵ�
			NodeList types = eleBrand.getChildNodes();
			for (int j = 0; j < types.getLength(); j++) {
				Node typeNode = types.item(j);
				if(typeNode.getNodeType()==Node.ELEMENT_NODE){
					Element typeElement=(Element)typeNode;
					System.out.println(typeElement.getAttribute("name"));
				}
			}
		}
	}
	//ΪXML�ļ����Ԫ��
	public void addEle(){
		//����<brand>,�����������
		Element brandElement = document.createElement("brand");
		brandElement.setAttribute("name","����");
		//����type �������note2
		Element tElement=document.createElement("type");
		tElement.setAttribute("name", "NOTE2");
		//��type��Ϊbrand����Ԫ��
		brandElement.appendChild(tElement);
		//��brand�ŵ�phoneInfo��ȥ
		document.getElementsByTagName("phoneInfo").item(0).appendChild(brandElement);
		//���ǵ�����ֻ���ڴ��д��ڣ���Ҫ�־û���Ӳ����ȥ
		saveXml("�ղ���Ϣ.xml");
	}
	//�־û���Ӳ�̷���(ת������Դ--��Ŀ�ĵأ��ղ���Ϣ.xml��
	public void saveXml(String path){
		//ת��������
		TransformerFactory factory = TransformerFactory.newInstance();
		//��������
		factory.setAttribute("indent-number", 4);
		try {
			//ת����
			Transformer transformer=factory.newTransformer();
			//ָ�������ʽ
			transformer.setOutputProperty(OutputKeys.ENCODING,"utf-8");//������ĺ�Ӧ
			//������������
			transformer.setOutputProperty(OutputKeys. INDENT,"YES");
			DOMSource source =new DOMSource(document);
			FileOutputStream out=new FileOutputStream(path);
			StreamResult result =new StreamResult(new OutputStreamWriter(out,"utf-8"));
			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//�޸�Ԫ��
	public void updateEle(){
		//��ȡ���е�brand
		NodeList brands=document.getElementsByTagName("brand");
		for (int i = 0; i < brands.getLength(); i++) {
			Node brand=brands.item(i);
			Element brandElement=(Element)brand;
			brandElement.setAttribute("id", i+" ");
		}
		saveXml("�ղ���Ϣ.xml");//�޸ĺ�ע�Ᵽ��
	}
	//ɾ�� ��Ϊ�ֻ�
	public void deleteEle(){
		//��ȡ���е�brand
		NodeList brands=document.getElementsByTagName("brand");
		for (int i = 0; i < brands.getLength(); i++) {
			Node brand=brands.item(i);
			Element brandElement=(Element)brand;
			if (brandElement.getAttribute("name").equals("��Ϊ")){
				brandElement.getParentNode().removeChild(brandElement);
			}
		}
		saveXml("�ղ���Ϣ.xml");//�޸ĺ�ע�Ᵽ��
	}
	
	public static void main(String[] args) throws Exception {
		ParseXml pd = new ParseXml();
		pd.getDom();
		pd.deleteEle();//ɾ��
		//pd.updateEle();//�޸�
		//pd.addEle();//����
		//�������չʾ��Ϣ
		pd.showInfo();//�鿴
	}
}
