package com.shaobig.genealogy.miewaagag.service.sorting.member;

public class MemberSorterFactory {
	
	public static MemberSorter getMemberSorter(String sortField) {
		switch (sortField) {
			case "age": return new MemberAgeSorter();
			case "sex": return new MemberSexSorter();
			default: return new MemberIdSorter();
		}
	}
}
