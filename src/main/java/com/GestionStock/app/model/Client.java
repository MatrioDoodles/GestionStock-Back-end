package com.GestionStock.app.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="client")
public class Client implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7642024441151858270L;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_CLIENT", unique = true)
	private long id;
	private String name;
	@Column(name="MAIL", unique = true)
	private String mail;
	private String phone;
	private String adress;
	private Float amount_bought;
	private long tenantid;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_user")
	private User user;
	@OneToMany(mappedBy = "client",fetch = FetchType.EAGER)
	private Set<Order> orders;
	@OneToMany(mappedBy = "client",fetch = FetchType.EAGER)
	private Set<Quotation> quotations;
	@OneToMany(mappedBy = "client",fetch = FetchType.EAGER)
	private Set<Invoice> invoices;
	
	@JsonIgnore
	public User getUser() {
		return user;
	}
	@JsonIgnore
	public void setUser(User user) {
		this.user = user;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public Set<Quotation> getQuotations() {
		return quotations;
	}
	public void setQuotations(Set<Quotation> quotations) {
		this.quotations = quotations;
	}
	public Set<Invoice> getInvoices() {
		return invoices;
	}
	public void setInvoices(Set<Invoice> invoices) {
		this.invoices = invoices;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Float getAmount_bought() {
		return amount_bought;
	}
	public void setAmount_bought(Float amount_bought) {
		this.amount_bought = amount_bought;
	}
	public long getTenantid() {
		return tenantid;
	}
	public void setTenantid(long tenant_id) {
		this.tenantid = tenant_id;
	}
	

}
