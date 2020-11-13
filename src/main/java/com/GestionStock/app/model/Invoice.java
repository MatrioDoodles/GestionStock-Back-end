package com.GestionStock.app.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="invoice")
public class Invoice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 418548089982799376L;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_INVOICE", unique = true)
	private long id;
	private Date creation_date;
	private Date pay_date;
	private String total;
	private long tenantid;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_user")
	private User user;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_company")
	private Company company;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_client")
	private Client client;
	@OneToOne(mappedBy = "invoice",fetch = FetchType.EAGER)
	@JoinColumn(name="id_order")
	private Order order;
	 
	
	
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	@JsonIgnore
	public User getUser() {
		return user;
	}
	@JsonIgnore
	public void setUser(User user) {
		this.user = user;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	public Date getPay_date() {
		return pay_date;
	}
	public void setPay_date(Date pay_date) {
		this.pay_date = pay_date;
	}
	public long getTenantid() {
		return tenantid;
	}
	public void setTenantid(long tenant_id) {
		this.tenantid = tenant_id;
	}
	
}
