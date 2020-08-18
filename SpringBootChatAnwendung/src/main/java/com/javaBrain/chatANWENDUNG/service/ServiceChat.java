package com.javaBrain.chatANWENDUNG.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.javaBrain.chatANWENDUNG.model.ContentMessage;

@Service
public class ServiceChat {
 
	List<ContentMessage> listOfContent=new ArrayList<>();
	
	public List<ContentMessage> getContent(){
		return listOfContent;
	}

	public List<ContentMessage> getListOfContent() {
		return listOfContent;
	}
	public void setListOfContent(List<ContentMessage> listOfContent) {
		this.listOfContent = listOfContent;
	}
	
}
