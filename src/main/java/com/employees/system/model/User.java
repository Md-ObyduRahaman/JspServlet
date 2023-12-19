package com.employees.system.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * User.java
 * This is a model class represents a User entity
 * @author Ramesh Fadatare
 *
 */

@Entity
@Table(name="userInfo")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	protected Long id;
	
	@Column(name="name")
	protected String name;
	
	@Column(name="email")
	protected String email;
	
	@Column(name="password")
	protected String password;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	Set<Product> products = new HashSet<>();



	public User() {
	}

	public User( String name, String email, String password) {

		this.name = name;
		this.email = email;
		this.password = password;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
