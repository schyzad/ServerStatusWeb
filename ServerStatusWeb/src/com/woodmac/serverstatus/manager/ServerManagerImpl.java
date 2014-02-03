package com.woodmac.serverstatus.manager;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woodmac.serverstatus.dao.ServerDao;
import com.woodmac.serverstatus.dao.ServerStatusDao;
import com.woodmac.serverstatus.domain.Server;
import com.woodmac.serverstatus.domain.ServerStatus;

@Service
public class ServerManagerImpl implements ServerManager {

	private static final Logger logger = LoggerFactory.getLogger(ServerManagerImpl.class);
	
	@Autowired
	private ServerDao serverDao;
	
	@Autowired
	private ServerStatusDao serverStatusDao;
	

	@Override
	public void addServerStatus(String serverName, Date timeStamp, String tag, String value) {
		
		Server server = serverDao.getServer(serverName);
		
		if(server == null){
			logger.info(" Server ["+serverName+"] is not present, adding it to the list.");
			serverDao.addServer(new Server(serverName));
			server = serverDao.getServer(serverName);
			logger.info("Server Added ["+server.getName()+"]");
		}else{
			logger.info(" Server ["+serverName+"] is already present in server list.");
		}
		
		ServerStatus status = new ServerStatus();
		status.setServer(server);
		status.setCreatedTimestamp(timeStamp);
		status.setTag(tag);
		status.setValue(value);

		serverStatusDao.addServerStatus(status);
	}

	@Override
	public List<Server> getServerList() {
		
		return serverDao.getServers();
	}

}
