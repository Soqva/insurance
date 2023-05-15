package com.s0qva.core.repository;

import com.s0qva.core.entity.LegalEntityData;
import com.s0qva.core.entity.primarykey.AttributePrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegalEntityDataRepository extends JpaRepository<LegalEntityData, AttributePrimaryKey> {
}
