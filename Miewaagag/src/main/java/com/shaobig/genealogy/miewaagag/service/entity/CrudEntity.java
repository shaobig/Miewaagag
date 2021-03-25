package com.shaobig.genealogy.miewaagag.service.entity;

public interface CrudEntity<E, I> extends CreateEntity<E>, ReadEntity<E, I>, UpdateEntity<E, I>, DeleteEntity<I> {}
