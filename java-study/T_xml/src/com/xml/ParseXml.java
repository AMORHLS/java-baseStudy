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


//使用DOM解析XML文件
public class ParseXml {
	//收藏信息.xml对应的Document
	private Document document;
	
	//获得DOM树，获得Document对象
	public void getDom(){
		//获得解析器工厂
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//根据解析器工厂获得解析器
		DocumentBuilder db=null;
		try {
			db = dbf.newDocumentBuilder();
			//解析器来获取Document对象
			document =db.parse("收藏信息.xml");//解析文件"收藏信息.xml"
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
	//获取手机品牌及型号相关信息
	public void showInfo(){
		//以Document为起点，先拿到所有的Brand节点
		NodeList brands=document.getElementsByTagName("brand");
		//遍历brand,从中拿出每一个brand节点
		for (int i = 0; i < brands.getLength(); i++) {
			Node node =brands.item(i);
			Element eleBrand =(Element)node;//向下转型
			String brandName=eleBrand.getAttribute("name");
			System.out.println(brandName);
			//继续查找，找到每个brand的子节点
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
	//为XML文件添加元素
	public void addEle(){
		//创建<brand>,添加属性三星
		Element brandElement = document.createElement("brand");
		brandElement.setAttribute("name","三星");
		//创建type 添加属性note2
		Element tElement=document.createElement("type");
		tElement.setAttribute("name", "NOTE2");
		//将type作为brand的子元素
		brandElement.appendChild(tElement);
		//将brand放到phoneInfo中去
		document.getElementsByTagName("phoneInfo").item(0).appendChild(brandElement);
		//这是的三星只在内存中存在！需要持久化到硬盘中去
		saveXml("收藏信息.xml");
	}
	//持久化到硬盘方法(转换器：源--》目的地（收藏信息.xml）
	public void saveXml(String path){
		//转换器工厂
		TransformerFactory factory = TransformerFactory.newInstance();
		//设置缩进
		factory.setAttribute("indent-number", 4);
		try {
			//转换器
			Transformer transformer=factory.newTransformer();
			//指定编码格式
			transformer.setOutputProperty(OutputKeys.ENCODING,"utf-8");//与下面的呼应
			//允许缩进可用
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
	//修改元素
	public void updateEle(){
		//获取所有的brand
		NodeList brands=document.getElementsByTagName("brand");
		for (int i = 0; i < brands.getLength(); i++) {
			Node brand=brands.item(i);
			Element brandElement=(Element)brand;
			brandElement.setAttribute("id", i+" ");
		}
		saveXml("收藏信息.xml");//修改后注意保存
	}
	//删除 华为手机
	public void deleteEle(){
		//获取所有的brand
		NodeList brands=document.getElementsByTagName("brand");
		for (int i = 0; i < brands.getLength(); i++) {
			Node brand=brands.item(i);
			Element brandElement=(Element)brand;
			if (brandElement.getAttribute("name").equals("华为")){
				brandElement.getParentNode().removeChild(brandElement);
			}
		}
		saveXml("收藏信息.xml");//修改后注意保存
	}
	
	public static void main(String[] args) throws Exception {
		ParseXml pd = new ParseXml();
		pd.getDom();
		pd.deleteEle();//删除
		//pd.updateEle();//修改
		//pd.addEle();//增加
		//先添加再展示信息
		pd.showInfo();//查看
	}
}
