package com.s0qva.insurance.repository;

import com.s0qva.insurance.dto.JpqlQuery;

public interface JpqlRepository {

    Object executeQuery(JpqlQuery query);
}
