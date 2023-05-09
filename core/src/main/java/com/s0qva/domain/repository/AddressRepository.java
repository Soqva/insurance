package com.s0qva.domain.repository;

import com.s0qva.domain.entity.Address;
import com.s0qva.domain.entity.primarykey.AttributePrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, AttributePrimaryKey> {
}
