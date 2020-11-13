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

@Entity(name="warehouse")
public class Warehouse implements Serializable {


	private static final long serialVersionUID = -910142404679535010L;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_WAREHOUSE", unique = true)
	private long id;
	private String reference;
	private String label;
	private String type;
	private long tenantid;
	@OneToMany(mappedBy = "warehouse",fetch = FetchType.EAGER)
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
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getTenantid() {
		return tenantid;
	}
	public void setTenantid(long tenant_id) {
		this.tenantid = tenant_id;
	}
}
