package com.shaobig.genealogy.miewaagag.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shaobig.genealogy.miewaagag.model.entities.Parents;

@Repository
public interface ParentsRepository extends JpaRepository<Parents, Integer> {}
