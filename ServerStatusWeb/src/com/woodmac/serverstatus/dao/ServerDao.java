package com.woodmac.serverstatus.dao;

import java.util.List;

import com.woodmac.serverstatus.domain.Server;

public interface ServerDao {
	
	public List<Server> getServers();
	public Server getServer(Integer id);
	public Server getServer(String name);
	public boolean addServer(Server server);

}
