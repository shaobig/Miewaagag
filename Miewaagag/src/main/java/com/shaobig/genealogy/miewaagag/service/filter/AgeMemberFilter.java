package com.shaobig.genealogy.miewaagag.service.filter;

import java.util.List;

import com.shaobig.genealogy.miewaagag.model.entities.Member;

public interface AgeMemberFilter {
	List<Member> getMembersByAgeRange(int minAge, int maxAge);
}
