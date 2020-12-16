package com.GestionStock.app.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name="subscription")
public class Subscription implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6912618284572530466L;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_SUBSCRIPTION", unique = true)
	private long id;
	private String duration;
	private Date starting_date;
	private Date expiring_date;
	private boolean payed;
//	private long products_number;
//	private long warehouses_number;
//	private long users_number;
//	private long suppliers_number;
	private long tenantid;
	@OneToMany(mappedBy = "subscription",fetch = FetchType.EAGER)
	private Set<User> users;
	
	

	public boolean isPayed() {
		return payed;
	}
	public void setPayed(boolean payed) {
		this.payed = payed;
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
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Date getStarting_date() {
		return starting_date;
	}
	public void setStarting_date(Date starting_date) {
		this.starting_date = starting_date;
	}
	public Date getExpiring_date() {
		return expiring_date;
	}
	public void setExpiring_date(Date expiring_date) {
		this.expiring_date = expiring_date;
	}
//	public long getProducts_number() {
//		return products_number;
//	}
//	public void setProducts_number(long products_number) {
//		this.products_number = products_number;
//	}
//	public long getWarehouses_number() {
//		return warehouses_number;
//	}
//	public void setWarehouses_number(long warehouses_number) {
//		this.warehouses_number = warehouses_number;
//	}
//	public long getUsers_number() {
//		return users_number;
//	}
//	public void setUsers_number(long users_number) {
//		this.users_number = users_number;
//	}
//	public long getSuppliers_number() {
//		return suppliers_number;
//	}
//	public void setSuppliers_number(long suppliers_number) {
//		this.suppliers_number = suppliers_number;
//	}
	public long getTenantid() {
		return tenantid;
	}
	public void setTenantid(long tenant_id) {
		this.tenantid = tenant_id;
	}
	
	

}
