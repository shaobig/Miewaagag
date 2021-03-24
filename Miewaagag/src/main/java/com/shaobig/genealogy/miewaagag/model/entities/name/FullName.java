package com.shaobig.genealogy.miewaagag.model.entities.name;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.shaobig.genealogy.miewaagag.model.entities.other.IdEntity;

@Entity(name = "FullName")
public class FullName implements IFullName, IdEntity<Integer> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "name_id")
	private Name commonName;
	private String patronymic;
	
	public FullName() {}
	
	public FullName(Name commonName) {
		this.commonName = commonName;
		this.patronymic = "";
	}

	public FullName(Name commonName, String patronymic) {
		this.commonName = commonName;
		this.patronymic = patronymic;
	}
	
	public Name getCommonName() {
		return commonName;
	}
	public void setCommonName(Name commonName) {
		this.commonName = commonName;
	}
	
	public String getPatronymic() {
		return patronymic;
	}
	
	public void setName(String name) {
		if (name != null) {
			getCommonName().setName(name);
		}
	}
	
	public void setPatronymic(String patronymic) {
		if (patronymic != null) {
			this.patronymic = patronymic;
		}
	}
	
	public void setSurname(String surname) {
		if (surname != null) {
			getCommonName().setSurname(surname);
		}
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
