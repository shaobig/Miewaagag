package com.shaobig.genealogy.miewaagag.service;

interface UpdateEntity<E, I> {
	void updateById(I id, E entity);
}
