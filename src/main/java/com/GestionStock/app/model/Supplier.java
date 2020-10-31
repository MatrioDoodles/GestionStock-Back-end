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

@Entity(name="supplier")
public class Supplier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6817290985088225764L;

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_SUPPLIER", unique = true)
	private long id;
	private String name;
	@Column(name="MAIL", unique = true)
	private String mail;
	private String phone;
	private String adress;
	private String logo;
	private String description;
	private String reference;
	private long tenant_id;
	@OneToMany(mappedBy = "supplier",fetch = FetchType.EAGER)
	private Set<Product> products; 
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
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
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public long getTenant_id() {
		return tenant_id;
	}
	public void setTenant_id(long tenant_id) {
		this.tenant_id = tenant_id;
	}
	public Set<Product> getIdproduct() {
		return products;
	}
	public void setIdproduct(Set<Product> idproduct) {
		this.products = idproduct;
	}
	
	
	
}
