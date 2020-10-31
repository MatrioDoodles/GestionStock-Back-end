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

@Entity(name="quotation")
public class Quotation implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1216323750927252112L;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_QUOTATION", unique = true)
	private long id;
	private String amount;
	private long tenant_id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_client")
	private Client client;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_company")
	private Company company;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_user")
	private User user;
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public long getTenant_id() {
		return tenant_id;
	}
	public void setTenant_id(long tenant_id) {
		this.tenant_id = tenant_id;
	}

}
