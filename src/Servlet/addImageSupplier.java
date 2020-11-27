package Servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.websocket.Session;

/**
 * Servlet implementation class imageUploadServlet
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
		maxFileSize = 1024 * 1024 * 50, // 50 MB
		maxRequestSize = 1024 * 1024 * 100) // 100 MB

@WebServlet("/upload.do")
public class addImageSupplier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int i = 1;

	public addImageSupplier() {
		super();
	}



	private String getFilename(Part part) {
		String header = part.getHeader("Content-Disposition");
		String filename = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
		return filename;
	}

	private void writeTo(String filename, Part part) throws IOException, FileNotFoundException {
		InputStream in = part.getInputStream();
		OutputStream out = new FileOutputStream("c:/temp/" + filename);
		byte[] buffer = new byte[1024];
		int length = -1;
		while ((length = in.read(buffer)) != -1) {
			out.write(buffer, 0, length);
		}
		in.close();
		out.close();
	}

	public void uploadImage(HttpServletRequest req, String folder, String filename)
			throws IOException, FileNotFoundException, ServletException {
		Part part = req.getPart("newImage");
		String header = part.getHeader("Content-Disposition");
		String filePath = req.getRealPath("/") + folder + "\\" + filename;
		InputStream in = part.getInputStream();
		OutputStream out = new FileOutputStream(filePath);
		byte[] buffer = new byte[1024];
		int length = -1;
		while ((length = in.read(buffer)) != -1) {
			out.write(buffer, 0, length);
		}
		in.close();
		out.close();
	}

	private void write(Part part) throws IOException {
		String filename = part.getSubmittedFileName();
		try (InputStream in = part.getInputStream(); OutputStream out = new FileOutputStream("c:/temp/" + filename)) {
			byte[] buffer = new byte[1024];
			int length = -1;
			while ((length = in.read(buffer)) != -1) {
				out.write(buffer, 0, length);
			}
		} catch (IOException ex) {
			throw new UncheckedIOException(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getParts().stream().filter(part -> !"upload".equals(part.getName())).forEach(t -> {
			try {
				write(t);
				//request.getRequestDispatcher("storeDetail.html").forward(request, response);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

	}

	public void newFolder(String path) {
		File dir_file = new File(path); /* 路徑跟檔名 */
		dir_file.mkdir();
	}

}
/*
 * String realPath = req.getRealPath("/"); // 獲取專案真實路徑 String tourNum =
 * req.getParameter("tourNum"); // 傳這筆資料新增後的tourNum String imageNum =
 * req.getParameter("imageNum"); // 看這是這筆資料的第幾張圖片，不用加.jpg Part part =
 * req.getPart("newImage" + req.getParameter("imageNum")); //
 * 設置這張照片為newImage+imageNum newFolder(realPath + "tour\\" + tourNum);
 * uploadImage(part, realPath + "tour\\" + tourNum + "\\" + imageNum + ".jpg");
 */