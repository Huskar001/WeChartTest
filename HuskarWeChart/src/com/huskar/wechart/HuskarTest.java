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
		int num = QueueCore.getInstance().addConsumer(consumer);
		System.out.println(num);
	}

}
