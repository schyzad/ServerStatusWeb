package com.woodmac.serverstatus.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.woodmac.serverstatus.domain.ServerStatus;

@Transactional
@Repository
public class ServerStatusDaoImpl implements ServerStatusDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addServerStatus(ServerStatus status) {
		this.sessionFactory.getCurrentSession().save(status);
	}

}
