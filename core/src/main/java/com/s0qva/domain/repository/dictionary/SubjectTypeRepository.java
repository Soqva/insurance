package com.s0qva.domain.repository.dictionary;

import com.s0qva.domain.entity.dictionary.SubjectType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectTypeRepository extends JpaRepository<SubjectType, String> {
}
