package com.zl.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.zl.pojo.News;
import com.zl.service.NewsService;
import com.zl.service.impl.NewsServiceImpl;
//�û��������ŵĴ���Servlet�������û����ύ���������ݣ�����service�ķ��������ű��浽���ݿ⣬��ת����Ӧҳ��
public class AddServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);//����д��
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�������ӵ�������Ϣ�������ú�̨��������������Ϣ�������ݿ�
		request.setCharacterEncoding("utf-8");
		boolean bRet = false;
		boolean bUpload = false;
		String uploadFileName = "";
		String fieldName = "";
		News news = new News();
		news.setCreateDate(new Date());
		//��������֮ǰ���ж����������Ƿ�Ϊ�ļ��ϴ�����
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		//ָ���ϴ�λ��
		String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");
		
		File saveDir = new File(uploadFilePath);  
		//���Ŀ¼�����ڣ��ʹ���Ŀ¼  
		if(!saveDir.exists()){  
		    saveDir.mkdir();  
		}  
		
		if(isMultipart){
			//�����ļ��ϴ������� 
			FileItemFactory factory = new DiskFileItemFactory(); // ʵ����һ��Ӳ���ļ�����,���������ϴ����ServletFileUpload
			ServletFileUpload upload = new ServletFileUpload(factory); // �����Ϲ���ʵ�����ϴ����
			try{
				//���������
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				while(iter.hasNext()){
					FileItem item = (FileItem)iter.next();
					if(item.isFormField()){// �������ͨ���ؼ� 
						fieldName = item.getFieldName();// ��ø��ֶ�����
						if(fieldName.equals("title")){
							news.setTitle(item.getString("UTF-8"));//��ø��ֶ�ֵ 
						}else if(fieldName.equals("categoryId")){
							news.setCategoryId(Integer.parseInt(item.getString()));
						}else if(fieldName.equals("summary")){
							news.setSummary(item.getString("UTF-8"));
						}else if(fieldName.equals("newscontent")){
							news.setContent(item.getString("UTF-8"));
						}else if(fieldName.equals("author")){
							news.setAuthor(item.getString("UTF-8"));
						}
					}else{// ���Ϊ�ļ���
						String fileName = item.getName();// ����ļ���(ȫ·��)
						if(fileName != null && !fileName.equals("")){
							File fullFile = new File(fileName);
							File saveFile = new File(uploadFilePath,fullFile.getName());//���ļ����浽ָ����·��
							item.write(saveFile);
							uploadFileName = fullFile.getName();
							news.setPicPath(uploadFileName);
							bUpload = true;
						
						}
					
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}	
		System.out.println("�ϴ��ɹ�֮����ļ�����" + news.getPicPath());
		//���ú�̨�ķ�������������Ϣ�������ݿ���
		NewsService newsService = new NewsServiceImpl();
		bRet = newsService.addNews(news);
		if(bRet)
			response.sendRedirect("/news/jsp/admin/newsDetailList.jsp");//��ͬ������ģ�ע��·��д��
			//request.getRequestDispatcher("/jsp/admin/newsDetailCreateSimple.jsp").forward(request, response);
		else
			response.sendRedirect("/news/jsp/admin/newsDetailCreateSimple.jsp");
		
	}


}
