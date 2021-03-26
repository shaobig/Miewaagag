package com.shaobig.genealogy.miewaagag.service.sorting.member.comparator;

import java.util.Comparator;

import com.shaobig.genealogy.miewaagag.model.entities.Member;

public class MemberComparatorFactory {
	
	public static Comparator<Member> getComparator(String sortField) {
		switch (sortField) {
			case "name": return new MemberNameComparator();
			case "patronymic": return new MemberPatronymicComparator();
			case "surname": return new MemberSurnameComparator();
			case "age": return new MemberAgeComparator();
			case "sex": return new MemberSexComparator();
			default: return new MemberIdComparator();
		}
	}
}
