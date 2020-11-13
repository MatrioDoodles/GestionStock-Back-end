package com.GestionStock.app.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="company")
public class Company implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7945284460297780009L;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_COMPANY", unique = true)
	private long id;
	private String name;
	private String description;
	private String adress;
	private String lang;
	private String logo;
	private String phone;
	private long tenantid;
	@OneToMany(mappedBy = "company",fetch = FetchType.EAGER)
	private Set<Quotation> quotations;
	@OneToMany(mappedBy = "company",fetch = FetchType.EAGER)
	private Set<Invoice> invoices;
	@OneToMany(mappedBy = "company",fetch = FetchType.EAGER)
	private Set<User> users;
	
	
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
	@JsonIgnore
	public Set<User> getUsers() {
		return users;
	}
	@JsonIgnore
	public void setUsers(Set<User> users) {
		this.users = users;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public long getTenantid() {
		return tenantid;
	}
	public void setTenantid(long tenant_id) {
		this.tenantid = tenant_id;
	}

}
