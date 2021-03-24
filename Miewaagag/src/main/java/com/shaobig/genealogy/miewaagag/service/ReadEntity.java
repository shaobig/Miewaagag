package com.shaobig.genealogy.miewaagag.service;

import java.util.List;

interface ReadEntity<E, I> {
	E getById(I id);
	List<E> getAll();
}
