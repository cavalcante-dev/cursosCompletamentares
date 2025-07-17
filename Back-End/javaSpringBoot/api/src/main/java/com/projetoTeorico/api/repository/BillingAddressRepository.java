package com.projetoTeorico.api.repository;

import com.projetoTeorico.api.entity.BillingAddress;
import com.projetoTeorico.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BillingAddressRepository extends JpaRepository<BillingAddress, UUID> {



}
