package com.huskar.wechart;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.huskar.queue.Consumer;
import com.huskar.queue.QueueCore;
import com.huskar.respmessage.Article;
import com.huskar.respmessage.NewsMessage;
import com.huskar.respmessage.TextMessage;
import com.huskar.util.MessageUtil;

public class CoreService {

	public static String processRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		// xml��ʽ����Ϣ����
		String respXml = null;
		// Ĭ�Ϸ��ص��ı���Ϣ����
		String respContent = "δ֪����Ϣ���ͣ�";
		try {
			//message type
			//http://mp.weixin.qq.com/wiki/17/fc9a27730e07b9126144d9c96eaf51f9.html
			
			
			// ����parseXml��������������Ϣ
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			// ���ͷ��ʺ�
			String fromUserName = requestMap.get("FromUserName");
			// ������΢�ź�
			String toUserName = requestMap.get("ToUserName");
			// ��Ϣ����
			String msgType = requestMap.get("MsgType");

			// �ظ��ı���Ϣ
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

			// �ı���Ϣ
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				//respContent = "�����͵����ı���Ϣ��";
				//Content
				String content = requestMap.get("Content");
				if(content.equals("huskar")){
					respContent = "Diaowei welcome!"; 
				}else if(content.equals("xuesong")){
					respContent = "Xuesong welcome!";
				}else if(content.equals("monking")){
					respContent = "Yan welcome";
				}else if(content.equals("queue")){
					
				}else if(content.equals("query")){
					
				}else if(content.equals("1")){//require
					Consumer consumer = new Consumer(fromUserName);
					int num = QueueCore.getInstance().addConsumer(consumer);
					if(num==-1){
						respContent = "You are already in queue!";
					}else{
						respContent = "Add to queue sucess, your Num is "+num;
					}
				}else if(content.equals("2")){//query
					Consumer consumer = new Consumer(fromUserName);
					int num = QueueCore.getInstance().query(consumer);
					respContent = "Your Num is "+ num;
				}
				else if(content.startsWith("testimg")){
					 String str = content.substring(7);
					 if(str.equals("")){
						 str = "Areyoukiddingme";
					 }
					 Article article = new Article();
					 article.setTitle("QRCODE TEST!!");
					// article.setPicUrl("http://huskar.aliapp.com/86.jpg");
					 article.setPicUrl("http://huskar.aliapp.com/huskar?name="+str+"&size=max");
					    article.setUrl("http://huskar.aliapp.com/huskar?name="+str+"&size=max");
					 NewsMessage newsMessage = new NewsMessage();
					 newsMessage.setToUserName(fromUserName);
					 newsMessage.setFromUserName(toUserName);
					 newsMessage.setCreateTime(new Date().getTime());
					 newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
					 newsMessage.setArticleCount(1);
					 List<Article> articleList = new ArrayList<Article>();  
					 articleList.add(article);
					 newsMessage.setArticles(articleList);
					 return MessageUtil.messageToXml(newsMessage);
				}
				else
				{
					respContent = "����say what��";
				}
				
			}
			// ͼƬ��Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "�����͵���ͼƬ��Ϣ��";
				//String url = requestMap.get("PicUrl");
				
			}
			// ������Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "�����͵���������Ϣ��";
			}
			// ��Ƶ��Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
				respContent = "�����͵�����Ƶ��Ϣ��";
			}
			// ����λ����Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "�����͵��ǵ���λ����Ϣ��";
			}
			// ������Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "�����͵���������Ϣ��";
			}
			// �¼�����
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// �¼�����
				String eventType = requestMap.get("Event");
				// ��ע
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = "ɧ�� ����������  ������monking����xuesong��";
				}
				// ȡ����ע
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO ȡ�����ĺ��û��������յ������˺ŷ��͵���Ϣ����˲���Ҫ�ظ�
				}
				// ɨ���������ά��
				else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
					// TODO ����ɨ���������ά���¼�
				}
				// �ϱ�����λ��
				else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
					// TODO �����ϱ�����λ���¼�
				}
				// �Զ���˵�
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// TODO ����˵�����¼�
				}
			}
			// �����ı���Ϣ������
			//respContent = respContent +";name:"+ fromUserName; 
			
			textMessage.setContent(respContent);
			// ���ı���Ϣ����ת����xml
			respXml = MessageUtil.messageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respXml;
	}

}
