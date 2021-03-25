package com.shaobig.genealogy.miewaagag.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shaobig.genealogy.miewaagag.model.entities.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
	List<Member> findByBirthYearBetween(int min, int max);
}
