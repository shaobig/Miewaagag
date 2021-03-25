package com.shaobig.genealogy.miewaagag.service.entity;

import java.util.List;

interface ReadEntity<E, I> {
	E getById(I id);
	List<E> getAll();
}
