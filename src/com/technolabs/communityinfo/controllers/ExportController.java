package com.technolabs.communityinfo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.technolabs.communityinfo.jms.ExportMessageSender;

@Controller
public class ExportController {
	
	private ExportMessageSender exportMessageSender;
	@Autowired
	public void setExportMessageSender(ExportMessageSender sender){
		this.exportMessageSender = sender;
	}
	
	@RequestMapping("exportMessages")
	public String exportMessages(){
		System.out.println("export request received");
		exportMessageSender.sendExportMessage("New Message");
		return "success";
	}
}
