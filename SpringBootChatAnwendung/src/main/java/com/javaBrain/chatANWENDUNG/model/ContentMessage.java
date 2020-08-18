package com.javaBrain.chatANWENDUNG.model;



public class ContentMessage {


	private  long id;
	private String content;
	private String sender;
	public ContentMessage(){
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ContentMessage(String content, String sender){
		this.content=content;
		this.sender=sender;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
}
