package com.huskar.queue;

public class Consumer {

	// private int num = 0;
	// private String content="";
	// private boolean isServiced = false;
	// private Waiter waiter;
	private String nickName = "no nickname";
	private String nameID = "";

	public Consumer(String id) {
		this.nameID = id;
	}

	public void setNickName(String nname) {
		this.nickName = nname;
	}

	public String getNickName() {
		return this.nickName;
	}

	public String getNameID() {
		return this.nameID;
	}

	public boolean sendMessage() {
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (null == obj) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Consumer user = (Consumer) obj;
		if (!nameID.equals(user.nameID)) {
			return false;
		}
		return true;
	}
}
