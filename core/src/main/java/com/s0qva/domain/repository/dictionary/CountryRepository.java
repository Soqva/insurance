package com.s0qva.domain.repository.dictionary;

import com.s0qva.domain.entity.dictionary.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
}
