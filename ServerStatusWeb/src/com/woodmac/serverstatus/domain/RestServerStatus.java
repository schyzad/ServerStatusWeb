package com.woodmac.serverstatus.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestServerStatus {

	private static final Logger logger = LoggerFactory.getLogger(RestServerStatus.class);
	
	public static final String DATE_FORMAT = "dd-MM-yyyy HH:mm:SS";
	
	private String server;
	private String tag;
	private String created; 
	private String value;
	
	
	
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	
	public boolean validate(){
		if(server == null || server.trim().equals("")){
			logger.error("Error in ServerName Passed.");
			return false;
		}
		if(tag == null || tag.trim().equals("")){
			logger.error("Error in Tag Passed.");
			return false;
		}
		if(value == null || value.trim().equals("")){
			logger.error("Error in Value Passed.");
			return false;
		}
		try {
			new SimpleDateFormat(DATE_FORMAT).parse(created);
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error("Error in Date Passed.");
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RestServerStatus [server=");
		builder.append(server);
		builder.append(", tag=");
		builder.append(tag);
		builder.append(", created=");
		builder.append(created);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
