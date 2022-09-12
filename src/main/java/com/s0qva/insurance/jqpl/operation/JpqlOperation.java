package com.s0qva.insurance.jqpl.operation;

@FunctionalInterface
public interface JpqlOperation<T> {

    T execute(String query);
}
