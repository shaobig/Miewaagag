package com.shaobig.genealogy.miewaagag.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shaobig.genealogy.miewaagag.model.entities.name.FullName;

@Repository
public interface FullNameRepository extends CrudRepository<FullName, Integer> {}
