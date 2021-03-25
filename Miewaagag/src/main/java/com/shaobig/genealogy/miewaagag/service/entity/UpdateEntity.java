package com.shaobig.genealogy.miewaagag.service.entity;

interface UpdateEntity<E, I> {
	void updateById(I id, E entity);
}
