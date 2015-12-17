package com.huskar.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCore {
	private static QueueCore mQueueCore=new QueueCore();;
	private static Queue<Consumer> ConsumerList_before = new LinkedList<Consumer>();
	private static Queue<Consumer> ConsumerList_after = new LinkedList<Consumer>();
	private QueueCore(){
	}
	public static QueueCore getInstance(){
			return mQueueCore;
	}
	public void reset(){
		ConsumerList_before.clear();
		ConsumerList_after.clear();
	}
	
	//add to last
	public int addConsumer(Consumer consumer){
		synchronized(ConsumerList_before){
			if(ConsumerList_before.contains(consumer)){
				return -1;
			}
			ConsumerList_before.offer(consumer);
			return ConsumerList_before.size();
		}
	}
	
	public int query(Consumer consumer){
		synchronized(ConsumerList_before){
			int i = ((LinkedList<Consumer>) ConsumerList_before).indexOf(consumer);
			i++;
			return i;
		}
	}
	
	public boolean isEmpty(){
		return ConsumerList_before.isEmpty();
	}
	public int service(){
		Consumer cm = ConsumerList_before.poll();
		if(cm!=null){
			//cm.sendMessage();
			//cm.......
			ConsumerList_after.offer(cm);
			return 0;
		}else{
			return -1;
		}
	}
}
