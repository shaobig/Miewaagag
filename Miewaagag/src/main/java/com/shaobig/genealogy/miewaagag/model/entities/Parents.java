package com.shaobig.genealogy.miewaagag.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.shaobig.genealogy.miewaagag.model.entities.other.IdEntity;

@Entity(name = "Parents")
public class Parents implements IdEntity<Integer> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "mother_id")
	private Member mother;
	@ManyToOne
	@JoinColumn(name = "father_id")
	private Member father;
	
	public Parents() {}
	
	public Parents(Member mother, Member father) {
		this.mother = mother;
		this.father = father;
	}

	public Member getMother() {
		return mother;
	}

	public void setMother(Member mother) {
		this.mother = mother;
	}

	public Member getFather() {
		return father;
	}

	public void setFather(Member father) {
		this.father = father;
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
