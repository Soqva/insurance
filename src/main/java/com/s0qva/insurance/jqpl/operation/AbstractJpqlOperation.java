package com.s0qva.insurance.jqpl.operation;

import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
public abstract class AbstractJpqlOperation<T> implements JpqlOperation<T> {
    protected final EntityManager entityManager;
}
