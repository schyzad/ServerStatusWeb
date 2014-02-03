package com.woodmac.serverstatus.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Server")
public class Server {
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private Integer id;

	@Column(name="NAME")
	private String name;

	public Server(){
	}
	
	public Server(String name){
		this.name = name;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
