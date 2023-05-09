package com.s0qva.domain.repository;

import com.s0qva.domain.entity.LegalEntityData;
import com.s0qva.domain.entity.primarykey.AttributePrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegalEntityDataRepository extends JpaRepository<LegalEntityData, AttributePrimaryKey> {
}
