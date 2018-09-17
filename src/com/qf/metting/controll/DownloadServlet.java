package com.qf.metting.controll;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.qf.metting.pojo.Download;
import com.qf.metting.pojo.User;
import com.qf.metting.service.impl.IDownloadService;
import com.qf.metting.utils.BeanContainerUtils;
import com.qf.metting.utils.PageUtils;
import com.qf.metting.utils.ParamesObjectUtils;

@MultipartConfig  
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IDownloadService downloadService =null;
	{
		try {
			downloadService = (IDownloadService) BeanContainerUtils.getBean("IDownloadService");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		try {
			Download download = ParamesObjectUtils.getObject(request, Download.class);
			String method = request.getParameter("method");
			jumgmentMethond(request,response,download,method);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private void jumgmentMethond(HttpServletRequest request, HttpServletResponse response, Download download,
			String method) {
		
		if("findDownloadAll".equals(method)) {
			List<Download> downloads = null;
			try {
				downloads = downloadService.findDownloadAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(download ==null) {
				System.out.println("查询文档结果为空");
			}
			request.setAttribute("downloads", downloads);
			try {
				PageUtils.jumpPage(request, response, "/view/document/document.jsp");
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//根据标题查找文档
		else if("findByTitle".equals(method)) {
			List<Download> downloads = null;
			try {
			
				downloads = downloadService.findDownloadByTitle(download.getDownloadTittle());
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(downloads ==null) {
				System.out.println("查询文档结果为空");
			}
			request.setAttribute("downloads", downloads);
			try {
				PageUtils.jumpPage(request, response, "/view/document/document.jsp");
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//初始化修改数据
		else if("findById".equals(method)) {
			Download download2 = null;
			try {
				download2 = downloadService.findDownloadById(download.getDownloadId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("document", download2);
			try {
				PageUtils.jumpPage(request, response, "/view/document/showUpdateDocument.jsp");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		
		//修改文档
		else if("updateDownload".equals(method)) {
			download.setDownloadFile("");
			User user = (User) request.getSession().getAttribute("userLogin");
			download.setUserId(user.getUserId());
			try {
				downloadService.updateDownload(download);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				PageUtils.jumpPage(request, response, "/downs?method=findDownloadAll");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		//删除文档
		else if("deleteDownload".equals(method)) {
			String ids = request.getParameter("ids");
			String[] idsStr = ids.split(",");
			for(String str:idsStr) {
				int downloadId = Integer.parseInt(str);
				try {
					downloadService.deleteDownload(downloadId);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				PageUtils.jumpPage(request, response, "/downs?method=findDownloadAll");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		//上传文档
		else if("upload".equals(method)) {
			download.setDownloadCreateTime(new Date());
			User user = (User) request.getSession().getAttribute("userLogin");
			download.setUserId(user.getUserId());
			
			download.setDownloadFile(uploadFile(request));
			
			try {
				downloadService.addDownload(download);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				PageUtils.jumpPage(request, response, "/downs?method=findDownloadAll");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		//下载文档
		else if("download".equals(method)) {
			int downloadId = Integer.parseInt(request.getParameter("id"));
			Download download2 = null;
			try {
				download2 = downloadService.findDownloadById(downloadId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String realPath = download2.getDownloadFile();
			//获取文件名
			try {
				downloadFile(response, realPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 下载文档
	 * @Title: downloadFile 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param response
	 * @param @param realPath
	 * @param @throws UnsupportedEncodingException
	 * @param @throws FileNotFoundException
	 * @param @throws IOException    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	private void downloadFile(HttpServletResponse response, String realPath)
			throws UnsupportedEncodingException, FileNotFoundException, IOException {
		String fileName = realPath.substring(realPath.lastIndexOf("\\")+1);
		fileName = URLEncoder.encode(fileName, "UTF-8");
		//响应 告诉浏览器以附件形式下载此文件
		response.setHeader("Content-disposition", "attachment;fileName="+fileName);

		FileInputStream fis = new FileInputStream(realPath);
		ServletOutputStream out = response.getOutputStream();
		
		byte[] b = new byte[1024];
		int len;
		while((len = fis.read(b)) != -1){
			out.write(b, 0, len);
		}
		
		fis.close();
	}
	/**
	 * 上传文件
	 * @Title: uploadFile 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param request    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	private String uploadFile(HttpServletRequest request) {
		List<Part> parts = null;
		try {
			parts = (List<Part>) request.getParts();
		} catch (IOException | ServletException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String filePath = null;
		for (Part part : parts) {

			String contentDispoosition = part.getHeader("content-disposition");

			contentDispoosition = contentDispoosition.replaceAll("\"", "");
			// 分割取出文件名
			String[] val = contentDispoosition.split(";");

			String val1 = val[val.length - 1];
	
			String[] val2 = val1.split("\\\\");
			if(val1.contains("filename")) {
				// 直接将文件写入到硬盘
				String fileName = val2[val2.length - 1];
				fileName = fileName.split("=")[1];
				try {
					part.write(request.getRealPath("/upload/" + fileName));
				} catch (IOException e) {
					e.printStackTrace();
				}
				//获得文件地址
				filePath = this.getServletContext().getRealPath("/upload/" + fileName);
			}
		}
		return filePath;
	}

}
