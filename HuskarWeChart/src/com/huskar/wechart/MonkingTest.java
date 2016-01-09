package com.huskar.wechart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.huskar.util.CommonUtil;
import com.huskar.util.HttpTookit;

/**
 * Servlet implementation class MonkingTest
 */
@WebServlet("/MonkingTest")
public class MonkingTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MonkingTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//http://localhost:8080/HuskarWeChart/monking/?huskar=diaowei
		
//		String name = request.getParameter("huskar");
//		String name2 = request.getParameter("name");
//		System.out.println("name="+name);
//		System.out.println("name2="+name2);
		
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("GB2312");
//		String url = request.getPathInfo();
//		url = url.substring(1);
//
//		url = "http://cloud.bmob.cn/8c7926c0799e9754/surl?surl=" + url;
//		String result = HttpTookit.doGet(url, null, "UTF-8", false);
//		System.out.println(result);
//		JSONObject jo;
//		PrintWriter out = response.getWriter();
//		try {
//			jo = new JSONObject(result);
//			JSONArray ja = jo.getJSONArray("results");
//			String type = ja.getJSONObject(0).getString("type");
//			String content = ja.getJSONObject(0).getString("content");
//			
//			// System.out.println("type="+type);
//			 System.out.println("content="+content);
//			if (type.equals("text")) {
//				out.println(content);
//			} else if (type.equals("url")) {
//				response.setContentType("text/html;charset=UTF-8");
//				//response.setCharacterEncoding("GB2312");
//				response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
//				response.setHeader("Location", content);
//			}
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			// e.printStackTrace();
//			out.println("error:" + e.getMessage());
//		}

	}

}
