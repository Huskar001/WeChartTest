package com.huskar.wechart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huskar.queue.Consumer;
import com.huskar.queue.QueueCore;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("GB2312");
		PrintWriter out = response.getWriter();

		String respContent = "";
		Consumer consumer;
		 if(QueueCore.getInstance().isEmpty()){
			 consumer = new Consumer("test");
		 }
		 else{
			 consumer = new Consumer("test"+new Date().getTime());
		 }
		int num = QueueCore.getInstance().addConsumer(consumer);
		if(num==-1){
			respContent = "You are already in queue!";
		}else{
			respContent = "Add to queue sucess, your Num is "+num;
		}
		out.println(respContent);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
