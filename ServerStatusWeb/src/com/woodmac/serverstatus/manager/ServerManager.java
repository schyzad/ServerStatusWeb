package com.woodmac.serverstatus.manager;

import java.util.Date;
import java.util.List;

import com.woodmac.serverstatus.domain.Server;

public interface ServerManager {
	public void addServerStatus(String serverName,Date timeStamp,String tag,String value);
	
	public List<Server> getServerList();
}
