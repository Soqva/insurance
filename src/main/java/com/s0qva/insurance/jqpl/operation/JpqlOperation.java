package com.s0qva.insurance.jqpl.operation;

import com.s0qva.insurance.dto.JpqlQuery;

@FunctionalInterface
public interface JpqlOperation<T> {

    T executeQuery(JpqlQuery query);
}
