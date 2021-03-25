package com.shaobig.genealogy.miewaagag.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaobig.genealogy.miewaagag.model.entities.Member;
import com.shaobig.genealogy.miewaagag.model.repository.MemberRepository;
import com.shaobig.genealogy.miewaagag.service.entity.CrudEntity;
import com.shaobig.genealogy.miewaagag.service.filter.AgeMemberFilter;

@Service
public class MemberService implements CrudEntity<Member, Integer>, AgeMemberFilter {
	
	@Autowired
	private MemberRepository repository;

	@Override
	public Member create(Member member) {
		return repository.save(member);
	}

	@Override
	public Member getById(Integer id) {
		Member member = new Member();
		
		try {
			member = repository.getOne(id);
		}
		catch (EntityNotFoundException e) {
			e.printStackTrace();
		}
		
		return member;
	}

	@Override
	public List<Member> getAll() {
		return repository.findAll();
	}

	@Override
	public void updateById(Integer id, Member newMember) {
		Member member = getById(id);
		
		member.setBirthYear(newMember.getBirthYear());
		member.setFullName(newMember.getFullName());
		member.setParents(newMember.getParents());
		member.setSex(newMember.getSex());
		
		create(member);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Member> getMembersByAgeRange(int minAge, int maxAge) {
		int currentYear = LocalDate.now().getYear();
		
		int minYear = currentYear - maxAge;
		int maxYear = currentYear - minAge;
		
		return repository.findByBirthYearBetween(minYear, maxYear);
	}
}
