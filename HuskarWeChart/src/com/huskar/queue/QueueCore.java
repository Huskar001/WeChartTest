package com.huskar.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCore {
	private static QueueCore mQueueCore;
	private Queue<Consumer> ConsumerList_before = new LinkedList<Consumer>();
	private Queue<Consumer> ConsumerList_after = new LinkedList<Consumer>();
	private QueueCore(){
	}
	public static QueueCore getInstance(){
		if(mQueueCore!=null){
			mQueueCore = new QueueCore();
		}
		return mQueueCore;
	}
	public void reset(){
		ConsumerList_before.clear();
		ConsumerList_after.clear();
	}
	
	//add to last
	public int addConsumer(Consumer consumer){
		if(ConsumerList_before.contains(consumer)){
			return -1;
		}
		ConsumerList_before.offer(consumer);
		return ConsumerList_before.size();
	}
	
	public int query(Consumer consumer){
		int i = ((LinkedList<Consumer>) ConsumerList_before).indexOf(consumer);
		return i;
	}
	
	
	public void service(){
		Consumer cm = ConsumerList_before.poll();
		if(cm!=null){
			//cm.sendMessage();
			//cm.......
			ConsumerList_after.offer(cm);
		}
	}
}
