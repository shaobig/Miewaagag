package com.shaobig.genealogy.miewaagag.service;

import java.util.List;

import com.shaobig.genealogy.miewaagag.model.entities.Member;

public interface MemberServiceSorter {
	List<Member> getAllSorted(String sortField);
}
