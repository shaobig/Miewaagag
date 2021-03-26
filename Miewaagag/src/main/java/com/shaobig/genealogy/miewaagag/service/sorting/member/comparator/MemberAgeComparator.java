package com.shaobig.genealogy.miewaagag.service.sorting.member.comparator;

import java.util.Comparator;

import com.shaobig.genealogy.miewaagag.model.entities.Member;

public class MemberAgeComparator implements Comparator<Member> {

	@Override
	public int compare(Member m1, Member m2) {
		return m2.getBirthYear() - m1.getBirthYear();
	}

}
