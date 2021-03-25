package com.shaobig.genealogy.miewaagag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.shaobig.genealogy.miewaagag.model.entities.Member;
import com.shaobig.genealogy.miewaagag.service.MemberService;

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
			Model model
			) {
		
		List<Member> members = service.getAll();
		model.addAttribute("members", members);
		
		return "members";
	}
	
	@GetMapping("/filter")
	public String getFilterPage(
			@RequestParam(name = "min") int minAge,
			@RequestParam(name = "max") int maxAge,
			Model model
			) {
		
		List<Member> members = service.getMembersByAgeRange(minAge, maxAge);
		model.addAttribute("members", members);
		
		return "members";
	}
}
