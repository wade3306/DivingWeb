package Servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import controller.tourController;
import model.tourModel;
import model.tourspotModel;

@MultipartConfig
@WebServlet("/imagesUpload")
public class imagesUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int i=1;
	String path="";
    public imagesUpload() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//新增區//
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		tourController tc=new tourController();
		HttpSession session =request.getSession();
		String [] str=request.getParameter("tourCreateSpot").split(",");
		ArrayList<tourspotModel> a=new ArrayList<tourspotModel>();
		for(int i=0;i<str.length;i++) {
			a.add(new tourspotModel(Integer.parseInt(str[i])));
		}
		tourModel createtour=new tourModel(request.getParameter("tourCreateName"),
				                   		   Integer.parseInt(request.getParameter("tourCreatePrice")),
				                           Integer.parseInt(request.getParameter("tourCreateSize")),
				                           request.getParameter("tourCreateFood"),
				                           request.getParameter("tourCreateMotel"),
				                           request.getParameter("tourCreateTraffic"),
				                           request.getParameter("tourCreateShow"),
				                           Integer.parseInt(session.getAttribute("Num").toString()),
				                           a);
		request.setAttribute("ans", tc.create(createtour));
		//新增區//
		
		//上傳照片區//
		Integer tourNum=tc.readLastTourNum(); //查詢最新tour的num
		String realPath = request.getRealPath("/");  //抓此專案真實路徑
		newFolder(realPath+"image\\tour\\"+tourNum); //創造此tour的照片資料夾
		path=realPath+"image\\tour\\"+tourNum+"\\"; //設定路徑
		System.out.println(path);
//		request.getParts() //lambda跑每一個照片
//		.stream()
//		.filter(part -> !"upload".equals(part.getName()))		
//		.forEach(this::write);
		Part part1=request.getPart("newImage1");
		System.out.println(part1);
		write(part1);
		write(request.getPart("newImage2"));
		write(request.getPart("newImage3"));
		write(request.getPart("newImage4"));
		i=1;
		//上傳照片區//
		request.getRequestDispatcher("storeDetail.html").forward(request, response);
	}
	
	public void write(Part part) {
        
        try(InputStream in = part.getInputStream();  
            OutputStream out = new FileOutputStream(path+(i++)+".jpg")) {
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
        } catch(IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }
	public void newFolder(String path) throws IOException{
	    File dir_file = new File(path);   
	    dir_file.mkdir();
}	
}
