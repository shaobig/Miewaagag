package com.shaobig.genealogy.miewaagag.model.entities.name;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.shaobig.genealogy.miewaagag.model.entities.other.IdEntity;
import com.sun.istack.NotNull;

@Entity(name = "Name")
public class Name implements IdEntity<Integer> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Integer id;
	
	private String name;
	private String surname;
	
	public Name() {}
	
	public Name(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	public Name(Integer id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
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

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		if (id > 0) {
			this.id = id;
		}
	}	
}
