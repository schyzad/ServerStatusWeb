package com.woodmac.serverstatus.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woodmac.serverstatus.datagrid.JqGridData;
import com.woodmac.serverstatus.domain.RestServerStatus;
import com.woodmac.serverstatus.domain.Server;
import com.woodmac.serverstatus.manager.ServerManager;


@Controller
@RequestMapping("/server")
public class StatusController {
	
	private static final Logger logger = LoggerFactory.getLogger(StatusController.class);
	
	@Autowired
	private ServerManager serverManager;
	
	@RequestMapping(value="/status", method = RequestMethod.POST)
	public @ResponseBody String addServerStatus(@RequestBody RestServerStatus serverStatus) throws ParseException{
		
		// validating request message
		if(! serverStatus.validate()){
			logger.error(" ERROR validating request message");
			return "Not OK - Request body not valid ["+serverStatus.toString()+"]";
		}
		// adding server status
		serverManager.addServerStatus(serverStatus.getServer(), new SimpleDateFormat(RestServerStatus.DATE_FORMAT).parse(serverStatus.getCreated()),serverStatus.getTag(), serverStatus.getValue());
		
		
		return "Ok";
	}
	
	
}
