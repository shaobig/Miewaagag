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
import com.sun.istack.NotNull;

@Entity(name = "Member")
public class Member implements IdEntity<Integer> {
	
	private static final int MIN_AGE_DIFFERENCE = 14;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
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
	
	public void setBirthYear(int birthYear) throws IllegalArgumentException {
		int currentYear = LocalDate.now().getYear();
		
		if (birthYear >= 0 && birthYear <= currentYear) {
			this.birthYear = birthYear;
		}
		else {
			throw new IllegalArgumentException("The birth year doesn't satisfy the appropriate range between 0 and " + currentYear);
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
	
	public void setMother(Member mother) throws IllegalArgumentException {
		if (mother != null && mother.getSex().equals(Sex.FEMALE)) {
			if (checkParentValidAge(mother)) {
				getParents().setMother(mother);
			}
			else {
				throw new IllegalArgumentException("Mother's age doesn't satisfy the min age difference with own child");
			}
		}
	}
	
	public void setFather(Member father) throws IllegalArgumentException {
		if (father != null && father.getSex().equals(Sex.MALE)) {
			if (checkParentValidAge(father)) {
				getParents().setFather(father);
			}
			else {
				throw new IllegalArgumentException("Father's age doesn't satisfy the min age difference with own child");
			}
		}
	}

	public void setParents(Parents parents) {
		if (parents != null) {
			this.parents = parents;
		}
	}
	
	public boolean checkParentValidAge(Member parent) {
		return getBirthYear() - parent.getBirthYear() > MIN_AGE_DIFFERENCE;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + birthYear;
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((parents == null) ? 0 : parents.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
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
		Member other = (Member) obj;
		if (birthYear != other.birthYear)
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (parents == null) {
			if (other.parents != null)
				return false;
		} else if (!parents.equals(other.parents))
			return false;
		if (sex != other.sex)
			return false;
		return true;
	}
}
