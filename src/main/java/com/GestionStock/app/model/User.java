package com.GestionStock.app.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6984991797556637464L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_USER", unique = true)
	private long id;
	private String name;
	private String surname;
	@Column(name="MAIL", unique = true)
	private String mail;
	private String phone;
	private String adress;
	private String picture;
	private String password;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_role")
	private Role role;
	@OneToMany(mappedBy = "tenant",fetch = FetchType.EAGER)
	private Set<User> users;
	@OneToMany(mappedBy = "creating_user",fetch = FetchType.EAGER)
	private Set<History> creating_users;
	@OneToMany(mappedBy = "last_interacting_user",fetch = FetchType.EAGER)
	private Set<History> last_interacting_users;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_tenant")
	private User tenant;
	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
	private Set<Product> products;
	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
	private Set<Quotation> quotations;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_company")
	private Company company;
	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
	private Set<Client> clients;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_subscription")
	private Subscription subscription;
	
	
	public Set<History> getCreating_users() {
		return creating_users;
	}

	public void setCreating_users(Set<History> creating_users) {
		this.creating_users = creating_users;
	}

	public Set<History> getLast_interacting_users() {
		return last_interacting_users;
	}

	public void setLast_interacting_users(Set<History> last_interacting_users) {
		this.last_interacting_users = last_interacting_users;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Set<Quotation> getQuotations() {
		return quotations;
	}

	public void setQuotations(Set<Quotation> quotations) {
		this.quotations = quotations;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public User getTenant() {
		return tenant;
	}

	public void setTenant(User tenant) {
		this.tenant = tenant;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
}
