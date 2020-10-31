package com.GestionStock.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="history")
public class History implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5922683152373562858L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_HISTORY", unique = true)
	private long id;
	private String entity;
	private String action;
	private String subject;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_creating_user")
	private User creating_user;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_last_interacting_user")
	private User last_interacting_user;
	private long tenant_id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public User getCreating_user() {
		return creating_user;
	}
	public void setCreating_user(User creating_user) {
		this.creating_user = creating_user;
	}
	public User getLast_interacting_user() {
		return last_interacting_user;
	}
	public void setLast_interacting_user(User last_interacting_user) {
		this.last_interacting_user = last_interacting_user;
	}
	public long getTenant_id() {
		return tenant_id;
	}
	public void setTenant_id(long tenant_id) {
		this.tenant_id = tenant_id;
	}

}
