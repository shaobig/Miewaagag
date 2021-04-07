package com.shaobig.genealogy.miewaagag.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.shaobig.genealogy.miewaagag.model.entities.other.IdEntity;
import com.shaobig.genealogy.miewaagag.model.entities.sex.Sex;
import com.sun.istack.NotNull;

@Entity(name = "Parents")
public class Parents implements IdEntity<Integer> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
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
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) throws IllegalArgumentException {
		if (id > 0) {
			this.id = id;
		}
		else {
			throw new IllegalArgumentException("Id is less than 0");
		}
	}

	public Member getMother() {
		return mother;
	}

	public void setMother(Member mother) {
		if (mother != null) {
			this.mother = mother;
		}
	}

	public Member getFather() {
		return father;
	}

	public void setFather(Member father) {
		if (father != null) {
			this.father = father;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((father == null) ? 0 : father.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mother == null) ? 0 : mother.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parents other = (Parents) obj;
		if (father == null) {
			if (other.father != null)
				return false;
		} else if (!father.equals(other.father))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mother == null) {
			if (other.mother != null)
				return false;
		} else if (!mother.equals(other.mother))
			return false;
		return true;
	}	
}
