package com.s0qva.core.repository;

import com.s0qva.core.entity.IndividualData;
import com.s0qva.core.entity.primarykey.AttributePrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualDataRepository extends JpaRepository<IndividualData, AttributePrimaryKey> {
}
