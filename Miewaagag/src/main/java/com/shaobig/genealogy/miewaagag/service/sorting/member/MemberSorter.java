package com.shaobig.genealogy.miewaagag.service.sorting.member;

import java.util.List;

import com.shaobig.genealogy.miewaagag.model.entities.Member;
import com.shaobig.genealogy.miewaagag.model.repository.MemberRepository;

public interface MemberSorter {
	List<Member> getAllSorted(MemberRepository repository);
}
