package com.shaobig.genealogy.miewaagag.model.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.shaobig.genealogy.miewaagag.model.entities.name.FullName;
import com.shaobig.genealogy.miewaagag.model.entities.other.IdEntity;
import com.shaobig.genealogy.miewaagag.model.entities.sex.Sex;

@Entity(name = "Member")
public class Member implements IdEntity<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "full_name_id")
	private FullName fullName;
	private int birthYear;
	
	@Enumerated
	private Sex sex;
	
	@ManyToOne
	@JoinColumn(name = "parents_id")
	private Parents parents;
	
	public Member() {}
	
	private Member(FullName name) {
		this.fullName = name;
	}
	
	public Member(FullName fullName, int birthYear, Sex sex, Parents parents) {
		this.fullName = fullName;
		this.birthYear = birthYear;
		this.sex = sex;
		this.parents = parents;
	}

	public FullName getFullName() {
		return fullName;
	}
	
	public void setFullName(FullName fullName) {
		if (fullName != null) {
			this.fullName = fullName;
		}
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	
	public void setBirthYear(int birthYear) {
		if (birthYear >= 0 && birthYear <= LocalDate.now().getYear()) {
			this.birthYear = birthYear;
		}
	}
	
	public Sex getSex() {
		return sex;
	}
	
	public void setSex(Sex sex) {
		if (sex != null) {
			this.sex = sex;
		}
	}
	
	public Parents getParents() {
		return parents;
	}

	public void setParents(Parents parents) {
		if (parents != null) {
			this.parents = parents;
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
	
	public static class Builder {
		private Member member;
		
		public Builder(FullName name) {
			member = new Member(name);
		}
		
		public Builder setBirthYear(int year) {
			member.setBirthYear(year);
			return this;
		}
		
		public Builder setSex(Sex sex) {
			member.setSex(sex);
			return this;
		}
		
		public Builder setParents(Parents parents) {
			member.setParents(parents);
			return this;
		}
		
		public Member getMember() {
			return member;
		}
	}
}
