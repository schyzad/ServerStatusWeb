package com.woodmac.serverstatus.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.woodmac.serverstatus.domain.Server;


@Transactional
@Repository
public class ServerDaoImpl implements ServerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Server> getServers() {		
		return this.sessionFactory.getCurrentSession().createQuery("from Server").list();
	}

	@Override
	public Server getServer(Integer id) {
		
		return (Server) sessionFactory.getCurrentSession().get(Server.class, id);
	}

	@Override
	public Server getServer(String name) {
		Query query = this.sessionFactory.getCurrentSession().createQuery(" from Server where name = :servername");
		query.setParameter("servername", name);
		return (Server)query.list().get(0);
	}

	@Override
	public boolean addServer(Server server) {		
		this.sessionFactory.getCurrentSession().save(server);		
		return true;
	}

}
