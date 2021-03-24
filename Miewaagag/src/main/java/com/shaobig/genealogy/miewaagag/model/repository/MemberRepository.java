package com.shaobig.genealogy.miewaagag.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shaobig.genealogy.miewaagag.model.entities.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, Integer> {}
