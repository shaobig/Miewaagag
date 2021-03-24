package com.shaobig.genealogy.miewaagag.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shaobig.genealogy.miewaagag.model.entities.Parents;

@Repository
public interface ParentsRepository extends CrudRepository<Parents, Integer> {}
