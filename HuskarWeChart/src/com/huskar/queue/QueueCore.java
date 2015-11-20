package com.huskar.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCore {
	private QueueCore mQueueCore;
	private Queue<Consumer> ConsumerList_before = new LinkedList<Consumer>();
	private Queue<Consumer> ConsumerList_after = new LinkedList<Consumer>();
	private QueueCore(){
	}
	public QueueCore getInstance(){
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
		ConsumerList_before.offer(consumer);
		return ConsumerList_before.size();
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
