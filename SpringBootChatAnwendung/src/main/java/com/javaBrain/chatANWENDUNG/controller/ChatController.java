package com.javaBrain.chatANWENDUNG.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaBrain.chatANWENDUNG.model.ChatAnwendung;
import com.javaBrain.chatANWENDUNG.model.ContentMessage;
import com.javaBrain.chatANWENDUNG.service.ServiceChat;





@Controller
public class ChatController {
	
 
	@Autowired
	private ServiceChat service;
	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
	@MessageMapping("/chat.anmelden")
	@SendTo("/topic/public")
	public ChatAnwendung anmelden(@Payload ChatAnwendung chatMessage, SimpMessageHeaderAccessor headerAccessor) {
	
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}

	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatAnwendung sendMessage(@Payload ChatAnwendung chatMessage) {
		ContentMessage message=new ContentMessage(chatMessage.getContent(), chatMessage.getSender());
		message.setId(service.getListOfContent().size()+1);
		service.getListOfContent().add(message);
		logger.info("list",service.getListOfContent());
		return chatMessage;
	}
	@GetMapping("/nachrichten")
	public String schowAlleNachrichten(Model model) {
		List<ContentMessage> list=service.getContent();
		model.addAttribute("list", list);
		
		return "table";
	}

	@RequestMapping("/conversation")
	public String getConversation() {
		
		return "redirect:/";
	}
}
