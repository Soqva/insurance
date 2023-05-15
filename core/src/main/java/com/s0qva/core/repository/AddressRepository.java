package com.s0qva.core.repository;

import com.s0qva.core.entity.Address;
import com.s0qva.core.entity.primarykey.AttributePrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, AttributePrimaryKey> {
}
