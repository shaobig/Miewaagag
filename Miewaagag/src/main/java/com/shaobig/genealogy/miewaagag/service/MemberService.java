package com.shaobig.genealogy.miewaagag.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaobig.genealogy.miewaagag.model.entities.Member;
import com.shaobig.genealogy.miewaagag.model.repository.MemberRepository;

@Service
public class MemberService implements CrudEntity<Member, Integer> {
	
	@Autowired
	private MemberRepository repository;

	@Override
	public Member create(Member member) {
		return repository.save(member);
	}

	@Override
	public Member getById(Integer id) {
		return repository.findById(id)
				.get();
	}

	@Override
	public List<Member> getAll() {
		Iterator<Member> memberIterator = repository.findAll().iterator();
		List<Member> members = new ArrayList<>();
		
		while (memberIterator.hasNext()) {
			members.add(memberIterator.next());
		}
		
		return members;
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
}
