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
}
