package com.huskar.wechart;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huskar.util.ALiyunUtil;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;  
import com.google.zxing.EncodeHintType;  
import com.google.zxing.MultiFormatWriter;  
import com.google.zxing.WriterException;  
import com.google.zxing.client.j2se.MatrixToImageWriter;  
import com.google.zxing.common.BitMatrix;   

public class HuskarServlet extends HttpServlet {

	String testimg = "http://huskar.aliapp.com/86.jpg";
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		 try {
//		//	download();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return;
//		}
		String name = req.getParameter("name");
		String size = req.getParameter("size");
		//System.out.println("name="+name);
		
		int width  = 400;
		int height = 400;
		if(size!=null){
			if(size.equals("max")){
				width = 600;
				height = 600;
			}
		}
		
		String format = "png";// 图像类型  
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();  
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");  
        BitMatrix bitMatrix = null;
		try {
			bitMatrix = new MultiFormatWriter().encode(name,  
			        BarcodeFormat.QR_CODE, width, height, hints);
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 生成矩阵  
		resp.setContentType("image/jpg;charset=GB2312");
		OutputStream os = resp.getOutputStream();
        //MatrixToImageWriter.writeToPath(bitMatrix, format, path);// 输出图像  
        MatrixToImageWriter.writeToStream(bitMatrix, format, os);
		
		os.flush();
		os.close();
//		byte data[] =  ALiyunUtil.get("/huskar.jpg");
		
		
//		String imagePath = "/86.jpg";
//		FileInputStream fis = new FileInputStream(imagePath);
//		int size = fis.available(); // 得到文件大小
//		byte data[] = new byte[size];
//		fis.read(data); // 读数据
//		fis.close();
		
//		resp.setContentType("image/jpg;charset=GB2312"); // 设置返回的文件类型
//		OutputStream os = resp.getOutputStream();
//		os.write(data);
//		os.flush();
//		os.close();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	
	
	private void download() throws Exception{
	     URL url = new URL(testimg);  
	        // 打开连接  
	        URLConnection con = url.openConnection();  
	        //设置请求超时为5s  
	        con.setConnectTimeout(5*1000);  
	        // 输入流  
	        InputStream is = con.getInputStream();  
			byte data[] = input2byte(is);
			ALiyunUtil.save(data, "/huskar.jpg");
	}
	
	 public static final InputStream byte2Input(byte[] buf) {  
	        return new ByteArrayInputStream(buf);  
	    }  
	  
	    public static final byte[] input2byte(InputStream inStream)  
	            throws IOException {  
	        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();  
	        byte[] buff = new byte[100];  
	        int rc = 0;  
	        while ((rc = inStream.read(buff, 0, 100)) > 0) {  
	            swapStream.write(buff, 0, rc);  
	        }  
	        byte[] in2b = swapStream.toByteArray();  
	        return in2b;  
	    }  
	/**
	 * 
	 */
	private static final long serialVersionUID = 5400758316966397051L;

}
