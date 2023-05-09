package com.s0qva.domain.repository;

import com.s0qva.domain.entity.IndividualData;
import com.s0qva.domain.entity.primarykey.AttributePrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualDataRepository extends JpaRepository<IndividualData, AttributePrimaryKey> {
}
