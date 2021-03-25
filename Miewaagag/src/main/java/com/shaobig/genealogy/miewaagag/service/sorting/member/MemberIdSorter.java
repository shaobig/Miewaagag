package com.shaobig.genealogy.miewaagag.service.sorting.member;

import java.util.List;

import com.shaobig.genealogy.miewaagag.model.entities.Member;
import com.shaobig.genealogy.miewaagag.model.repository.MemberRepository;

public class MemberIdSorter implements MemberSorter {

	@Override
	public List<Member> getAllSorted(MemberRepository repository) {
		return repository.findAll();
	}

}
