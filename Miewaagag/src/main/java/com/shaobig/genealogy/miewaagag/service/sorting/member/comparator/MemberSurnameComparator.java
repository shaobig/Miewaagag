package com.shaobig.genealogy.miewaagag.service.sorting.member.comparator;

import java.util.Comparator;

import com.shaobig.genealogy.miewaagag.model.entities.Member;

public class MemberSurnameComparator implements Comparator<Member> {

	@Override
	public int compare(Member m1, Member m2) {
		return m1.getFullName().getCommonName().getSurname()
				.compareTo(m2.getFullName().getCommonName().getSurname());
	}

}
