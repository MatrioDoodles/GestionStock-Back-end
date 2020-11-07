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

@Entity(name="category")
public class Category implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8201586255984317214L;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_CATEGORY", unique = true)
	private long id;
	private String label;
	private String description;
	private long tenantid;
	@OneToMany(mappedBy = "categoryprimary", fetch = FetchType.EAGER)
	private Set<Category> sous_category;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_category_primary")
	private Category categoryprimary;
	@OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
	private Set<Product> products;
	
	
	
	public Category getCategory_primary() {
		return categoryprimary;
	}
	public void setCategory_primary(Category category_primary) {
		this.categoryprimary = category_primary;
	}
	public Set<Category> getSous_category() {
		return sous_category;
	}
	public void setSous_category(Set<Category> sous_category) {
		this.sous_category = sous_category;
	}
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
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getTenant_id() {
		return tenantid;
	}
	public void setTenant_id(long tenant_id) {
		this.tenantid = tenant_id;
	}

}
