package com.shaobig.genealogy.miewaagag.controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.shaobig.genealogy.miewaagag.model.entities.Member;
import com.shaobig.genealogy.miewaagag.service.MemberService;
import com.shaobig.genealogy.miewaagag.service.sorting.member.comparator.MemberComparatorFactory;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/member/{id}")
	public String getMemberByIdPage(
			@PathVariable Integer id,
			Model model
			) {
		
		Member member = service.getById(id);
		
		model.addAttribute("id", id);
		model.addAttribute("member", member);
		
		return "member";
	}
	
	@GetMapping("/all")
	public String getAllPage(
			@RequestParam(name = "sortby", defaultValue = "id") String sortField,
			Model model
			) {
		
		sortField = sortField.toLowerCase();
		
		List<Member> members = service.getAllSorted(sortField);
		model.addAttribute("members", members);
		
		return "members";
	}
	
	@GetMapping("/filter")
	public String getFilterPage(
			@RequestParam(name = "min_age", defaultValue = "0") int minAge,
			@RequestParam(name = "max_age", defaultValue = "100") int maxAge,
			@RequestParam(name = "sortby", defaultValue = "id") String sortField,
			Model model
			) {
		
		Comparator<Member> comparator = MemberComparatorFactory.getComparator(sortField);
		
		List<Member> members = service.getMembersByAgeRange(minAge, maxAge);
		members.sort(comparator);		
		
		model.addAttribute("members", members);
		
		return "members";
	}
}
