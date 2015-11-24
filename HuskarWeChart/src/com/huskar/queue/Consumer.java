package com.huskar.queue;

public class Consumer {

	//private int num = 0;
	//private String content="";
	//private boolean isServiced = false;
	//private Waiter waiter;
	private String nickName="no nickname";
	private String nameID = "";
	public Consumer(String id){
		this.nameID = id;
	}
	public void setNickName(String nname){
		this.nickName = nname;
	}
	public String getNickName(){
		return this.nickName;
	}
	public String getNameID(){
		return this.nameID;
	}
	public boolean sendMessage(){
		return false;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj!=null){
			Consumer consumer = (Consumer) obj;
			if(consumer!=null){
				if(consumer.nameID == this.nameID){
					return true;
				}
			}
		}
		return false;
	}
}
