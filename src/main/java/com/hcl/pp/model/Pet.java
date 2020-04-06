package com.hcl.pp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pets")
public class Pet {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	@Column(name = "PET_NAME")
	private String name;
	@Column(name = "PET_AGE")
	private int age;
	@Column(name = "PET_PLACE")
	private String place;
	@ManyToOne
	@JoinColumn(name = "PET_OWNERID")
	//@Column(name = "PET_OWNERID")
	private User owner;
	
	public Pet() {}

	public Pet(String name, int age, String place, User owner) {
		this.name = name;
		this.age = age;
		this.place = place;
		this.owner = owner;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", age=" + age + ", place=" + place + ", owner=" + owner + "]";
	}
	
	
	
}
