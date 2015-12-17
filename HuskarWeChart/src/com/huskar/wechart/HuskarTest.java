package com.huskar.wechart;

import com.huskar.queue.Consumer;
import com.huskar.queue.QueueCore;

/**
* @author Huskar
* @version time:2015年11月24日 下午5:36:10
* 
*/
public class HuskarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Consumer consumer = new Consumer("1111");
		Consumer consumer2 = new Consumer("1111");
		Consumer consumer3 = new Consumer("3333");
		int num = QueueCore.getInstance().addConsumer(consumer);
		System.out.println(num);
		num = QueueCore.getInstance().addConsumer(consumer2);
		//int num2 = QueueCore.getInstance().addConsumer(consumer2);
		//int num3 = QueueCore.getInstance().addConsumer(consumer3);
		System.out.println(num);
		//System.out.println(num2);
		//System.out.println(num3);
		//System.out.println(QueueCore.getInstance().query(consumer3));
		System.out.println(QueueCore.getInstance().query(consumer2));
		//System.out.println(QueueCore.getInstance().query(consumer2));
		//QueueCore.getInstance().service();
		//System.out.println(QueueCore.getInstance().query(consumer3));
	}

}
